package vsu.cs.ru.num16;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N = readValue('N');
        int a = readValue('a');
        printFinalSum(N, a);
    }

    private static int readValue(char name) {
        System.out.printf("Input %s: ", name );
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static void printElements(int ... arrayOfElements) {
        for (int i = 0; i < arrayOfElements.length; i++) {
            System.out.print(arrayOfElements[i] + " ");
        }
    }

    private static boolean checkInput(int N) {
        return N > 2;
    }

    private static int calcInitialSum(int A1, int A2, int A3, int a) {
        if (a > A3) {
            return A1 + A2 + A3;
        } else if ( a > A2) {
            return A1 + A2;
        } else if (a > A1) {
            return A1;
        }
        else return 0;
    }

    private static int calcFinalSum(int N, int a) {
        if (!checkInput(N)) {
            return 0;
        }

        int A1 = 1, A2 = 2, A3 = 3, Ak;
        int sum = calcInitialSum(A1, A2, A3, a);

        printElements(A1,A2,A3);

        for (int k = 4; k <= N; k++) {
            Ak = A3 + A2 - 2 * A1 ;
            printElements(Ak);
            A1 = A2; A2 = A3; A3 = Ak;
            if (Ak < a) {
                sum += Ak;
            }
        }
        return sum;
    }

    private static void printFinalSum(int N, int a) {
        int sum = calcFinalSum(N, a);
        System.out.print("\n" + "Сумма чисел = " + sum);
    }
}
