import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class AppCopyFiles {
    public static void main(String [] args){
        Path toCopy = Paths.get("src", "..","tocopy.txt");
        Path copyIn = Paths.get("src", "..","copy.txt");
        System.out.println(copyIn.toFile().exists());
        try{
            Files.copy(toCopy, copyIn, StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
}
