import java.nio.file.Path;
import java.nio.file.Paths;

public class AppPathMain {
    public static void main(String[] args){
        Path path = Paths.get(System.getProperty("user.home"),"documents", "java", "temario.txt");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0,2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

        Path path2 = Paths.get(System.getProperty("user.home"),"documents", "java", "..", "..", "temario.txt");
        System.out.println(path2.toString());

        Path normalized = path2.normalize();
        System.out.println(normalized.toString());


        Path basePath = Paths.get(System.getProperty("user.home"),"documents", "java");
        Path file = Paths.get("temario.txt");

        Path complete = basePath.resolve(file);

        System.out.println(complete.toString());


        Path p1 = Paths.get(System.getProperty("user.home"), "documents", "java", "..", "..", "documents", "java",
                "temario.txt");

        Path p2 = Paths.get(System.getProperty("user.home"), "documents", "java", "temario.txt");

        if (p1.equals(p2))
            System.out.println("Son iguales");
        else
            System.out.println("No son iguales");

        if (p1.normalize().equals(p2))
            System.out.println("Ahora sí son iguales");

    }
}
