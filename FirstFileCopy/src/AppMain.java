import java.io.*;

public class AppMain {
    public static void main(String[] args){
        final int TAM = 1024 * 16;

        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream("tocopy.txt"));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("copy.txt"))){

            int cantidadBytes = 0;
            byte[] buffer = new byte[TAM];

            while ((cantidadBytes = bin.read(buffer, 0, TAM)) != -1) {
                bout.write(buffer, 0, cantidadBytes);
            }

            System.out.println("El fichero se ha copiado correctamente");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
