import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static double calculateS(char a, char n, char b, char m) {
        char operation1 = '+';
        char operation2 = '%';
        int constant = 2;
        double result = 0.0;

        try {
            if (a > n || b > m) {
                System.err.println("Error: a та b повинні бути не більшими ніж n та m.");
                return result;
            }

            for (char i = a; i <= n; i++) {
                for (char j = b; j <= m; j++) {
                    double numerator = (double) (i * operation2 * j);
                    double denominator = (double) (i * operation1 * constant);
                    result += numerator / denominator;
                }
            }
        } catch (ArithmeticException e) {
            System.err.println("Error: Ділення на нуль.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char a, n, b, m;

        while (true) {
            try {
                System.out.print("a: ");
                a = scanner.next().charAt(0);
                System.out.print("n: ");
                n = scanner.next().charAt(0);
                System.out.print("b: ");
                b = scanner.next().charAt(0);
                System.out.print("m: ");
                m = scanner.next().charAt(0);

                if (a > n || b > m) {
                    System.err.println("Error. a та b повинні бути не більшими ніж n та m.");
                    continue;
                }

                break;
            } catch (InputMismatchException e) {
                System.err.println("Error. Введено некоректні дані. Будь ласка, введіть символи.");
                scanner.nextLine();
            }
        }

        double result = calculateS(a, n, b, m);
        System.out.println("S = " + result);
    }
}
