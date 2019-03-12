import java.net.URL;
import java.net.URLClassLoader;

public class Main
{
    public static void main( String[] args )
    {
        try
        {
            String stringClassURL = "file:///Users/mike/Documents/depots/M1-Miage-Prog-Avancee-TP1/ClassLoaderProject_1/src/Test.java";
            String nameClass = "Test";

            URL[] classURL = new URL[] { new URL( stringClassURL ) };

            URLClassLoader classLoader = new URLClassLoader( classURL );

            Class classIWantToLoad = classLoader.loadClass( nameClass ); // Throws a ClassNotFoundException
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
