package DataStruct;
import java.util.HashSet;
import java.util.Iterator;

/*  HashSet to implementacja interfejsu Set w języku Java,
 *   reprezentuje zbiór elementów. Jest to kolekcja,
 *   przechowuje unikalne elementy, co oznacza, że nie może zawierać duplikatów*/
// Tworzenie HashSet
public class HashSet_1 {
    public static void main(String[] args) {

    }


    public void usage() {

        HashSet<String> set = new HashSet<>();

        // Dodawanie elementów do HashSet
        set.add("jabłko");
        set.add("banan");
        set.add("truskawka");
        set.add("gruszka");
        set.add("jabłko"); // Ten element nie zostanie dodany, ponieważ HashSet nie przechowuje duplikatów

        // Rozmiar HashSet
        System.out.println("Rozmiar HashSet: " + set.size()); // Wyświetli: 4

        // Iterowanie przez elementy HashSet za pomocą Iteratora
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        // Usuwanie elementu z HashSet
        set.remove("banan");

        // Sprawdzanie obecności elementu
        boolean containsStrawberry = set.contains("truskawka");
        System.out.println("Czy truskawka jest w zbiorze? " + containsStrawberry); // Wyświetli: true

        // Czyszczenie HashSet
        set.clear();

        // Sprawdzanie, czy HashSet jest pusty
        boolean isEmpty = set.isEmpty();
        System.out.println("Czy HashSet jest pusty? " + isEmpty); // Wyświetli: true
    }
}
