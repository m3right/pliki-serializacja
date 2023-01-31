import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Osoba o1 = new Osoba("Adam", "Mickiewicz", 1798);
		Osoba o2 = new Osoba("Juliusz", "Slowacki", 1809);
    Osoba o3 = new Osoba("Anna", "Dermin", 1999);
    Osoba o4 = new Osoba("Rafał", "Pot", 1994);

    ArrayList<Osoba> osoby = new ArrayList<Osoba>();
    osoby.add(o3);
    osoby.add(o4);
	
		FileOutputStream fos = new FileOutputStream("plik.ser");
    FileOutputStream wos = new FileOutputStream ("plik2.ser");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
    BufferedOutputStream los = new BufferedOutputStream(wos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);
    ObjectOutputStream os = new ObjectOutputStream(los);
		
		oos.writeObject(o1);
		oos.writeObject(o2);
    os.writeObject(o3);
		
		oos.close();
    os.close();
 
    
		FileInputStream fis = new FileInputStream("plik.ser");
    FileInputStream wis = new FileInputStream("plik2.ser");
		BufferedInputStream bis = new BufferedInputStream(fis);
    BufferedInputStream lis = new BufferedInputStream(wis);
		ObjectInputStream ois = new ObjectInputStream(bis);
    ObjectInputStream oi = new ObjectInputStream(lis);
    
    while(bis.available() > 0) {
			Osoba o = (Osoba) ois.readObject();
			System.out.println(o);
		}

    while(lis.available()>0){
      Osoba o = (Osoba) oi.readObject();
      System.out.println(o);
    }
			
		ois.close();
    oi.close();
	}
}


/* Zadania:
 * 1. Utworz liste ArrayList<Osoba>.
 * 2. Dodaj do niej dwa obiekty klasy Osoba.
 * 3. Otworz kolejny plik do zapisu i zapisz do niego obiekt klasy ArrayList<Osoba>.
 * 4. Wczytaj obiekt klasy ArrayList<Osoba> z drugiego pliku.
 * 5. Wyswietl go na ekranie.
 */
