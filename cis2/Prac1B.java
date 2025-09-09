import java.util.Scanner;
public class Prac1B {

    static String process(String text, int shift, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int newVal = c + (encrypt ? shift : -shift);
            result.append((char)(newVal % 256));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1: Encrypt  2: Decrypt");
        int choice = sc.nextInt();
        System.out.print("Enter shift: ");
        int shift = sc.nextInt();
        sc.nextLine();  // consume leftover newline
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean encrypt = (choice == 1);
        String result = process(text, shift, encrypt);
        System.out.println("Result: " + result);
    }
}