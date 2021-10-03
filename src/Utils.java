import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    /**
     * wait for the user to enter an integer between 0 and max
     * @param max
     * @return the integer
     */
    public static int enterPositiveInt(int max) {
        Scanner sc = new Scanner(System.in);
        int a;
        try {
            a = sc.nextInt();
            if (a < 0 || a > max) {
                System.out.println("entrÃ©e invalide, recommencez");
                return enterPositiveInt(max);
            }
            return a;
        } catch (InputMismatchException e) {
            System.out.println("entrÃ©e invalide, recommencez");
            return enterPositiveInt(max);
        }

    }
}