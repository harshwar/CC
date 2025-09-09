import java.io.*;

class Prac1A {
    public static void main(String[] args) {
        try (
            FileInputStream fis = new FileInputStream("1.txt");
            FileOutputStream fos = new FileOutputStream("2.txt");
            FileOutputStream os  = new FileOutputStream("3.txt")
        ) {
            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);      // copy as is
                os.write(ch + 6);   // shifted by 6
            }
            System.out.println("File copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}