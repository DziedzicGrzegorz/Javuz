## Struktury danych w pakiecie `java.util`

Poniżej znajdziesz listę głównych struktur danych dostępnych w pakiecie `java.util` w języku Java. Pakiet `java.util` zawiera wiele różnych klas i interfejsów, ale oto niektóre z najważniejszych struktur danych:

1. **Listy**:
    - `ArrayList`: Dynamiczna tablica.
    - `LinkedList`: Lista dwukierunkowa.
    - `Vector`: Implementacja dynamicznej tablicy z synchronizacją.
    - `Stack`: Implementacja stosu.

2. **Zbiory**:
    - `HashSet`: Nieuporządkowany zestaw niepowtarzalnych elementów.
    - `LinkedHashSet`: Zestaw zachowujący kolejność wstawiania elementów.
    - `TreeSet`: Zestaw elementów uporządkowanych w porządku naturalnym lub na podstawie dostarczonego komparatora.

3. **Mapy**:
    - `HashMap`: Implementacja mapy opartej na tablicy hashującej.
    - `LinkedHashMap`: Mapa zachowująca kolejność wstawiania par klucz-wartość.
    - `TreeMap`: Mapa z uporządkowanymi kluczami.

4. **Kolejki**:
    - `PriorityQueue`: Kolejka priorytetowa oparta na kopcu.

5. **Dequeue**:
    - `ArrayDeque`: Implementacja dwustronnej kolejki (Deque).

6. **Iterator i ListIterator**:
    - `Iterator`: Interfejs do iteracji przez elementy kolekcji.
    - `ListIterator`: Interfejs do iteracji przez listy z dostępem do elementów w obie strony.

7. **BitSet**:
    - `BitSet`: Reprezentacja zbioru bitów.

8. **EnumSet**:
    - `EnumSet`: Zestaw elementów dla typów wyliczeniowych.

9. **Hashtable**:
    - `Hashtable`: Implementacja mapy opartej na tablicy hashującej, z synchronizacją (starsza wersja, zalecane jest stosowanie `HashMap`).

10. **Random**:
    - `Random`: Klasa do generowania liczb pseudolosowych.

11. **Date i Calendar**:
    - `Date`: Klasa reprezentująca datę i godzinę (starsza, zalecane jest stosowanie `java.time` od Java 8).
    - `Calendar`: Klasa do manipulacji datami (starsza, zalecane jest stosowanie `java.time` od Java 8).

12. **UUID**:
    - `UUID`: Unikalny identyfikator uniwersalny.

To tylko kilka głównych struktur danych dostępnych w pakiecie `java.util`. Jest wiele innych klas i interfejsów, które można wykorzystać w zależności od potrzeb programu. Warto także zauważyć, że od Java 8 wprowadzono nowe API do obsługi daty i czasu (`java.time`), które zastępuje starsze klasy `Date` i `Calendar`.
