import TreeFS.TreeFS;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        TreeFS tree = new TreeFS(new File("").getAbsolutePath());


        System.out.println( tree.createXMLCode() );
    }

}