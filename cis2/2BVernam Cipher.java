public class Prac2B {
    public static void main(String[] args) {
        String text = "Mountain"; 
        String key = "akinus";
        char[] encoded = new char[text.length()];

        System.out.println("Original: " + text);
        System.out.println("Key: " + key);

        System.out.print("\nEncoded (as numbers): ");
for (int i = 0; i < text.length(); i++) {
    // Use the modulo operator to wrap the key index
    encoded[i] = (char) (text.charAt(i) ^ key.charAt(i % key.length()));
    // Cast the char to an int to see its numerical value
    System.out.print((int)encoded[i] + " "); 
}

        System.out.print("\nDecoded: ");
        for (int i = 0; i < text.length(); i++) {
            // Use the same logic for decoding
            System.out.print((char) (encoded[i] ^ key.charAt(i % key.length())));
        }
        System.out.println(); // For a clean new line at the end
    }
}