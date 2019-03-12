package TP3;

import java.net.URL;
import java.net.URLClassLoader;

public class Main
{
    public static void main( String[] args )
    {
        // This is where IntelliJ puts compiled files
        String stringClassURL = "file:///Users/mike/Documents/depots/M1-Miage-Prog-Avancee-TP1/ClassLoaderProject_1/out/production/ClassLoaderProject_1/";
        String nameClass = "TP3.Test";

        try
        {
            System.out.println( "------------- Without URLClassLoader -------------" );

            Class classIWantToLoadWithoutURLClassLoader = Class.forName( stringClassURL );
            // Throws a ClassNotFoundException
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }

        try
        {

            System.out.println( "------------- With URLClassLoader -------------" );

            URL[] classURL = new URL[] { new URL( stringClassURL ) };

            URLClassLoader classLoader = new URLClassLoader( classURL );

            Class classIWantToLoad = classLoader.loadClass( nameClass );
            // Throws a ClassNotFoundException
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
