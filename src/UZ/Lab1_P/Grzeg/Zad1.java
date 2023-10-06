package UZ.Lab1_P.Grzeg;

public class Zad1 {
    public static void main(String[] args) {
    }

    public void printfStars(int length) {
        for (int i = 0; i < length; i++) {
            for (int j = length - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}



