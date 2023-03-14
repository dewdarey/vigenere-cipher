import java.util.Scanner;

public class Main {
    public static String encrypt(String text, String key) {
        String res = "";
        text = text.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        } return res;
    }

    public static String decrypt(String text, String key) {
        String res = "";
        text = text.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        } return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert the text: ");
        String message = scanner.nextLine();
        System.out.print("Insert the key: ");   // VIGENERECIPHER
        String key = scanner.nextLine();
        String encryptedMsg = encrypt(message, key);

        System.out.println("String: " + message);
        System.out.println("Key: " + key);
        System.out.println("Encrypted message: " + encryptedMsg);
        System.out.println("Decrypted message: " + decrypt(encryptedMsg, key));
    }
}