package TP1;

import java.io.File;

public class Exercice1
{
    public static void main( String[] args )
    {
        System.out.println( "Exercice 1A" );

        File currentDirectory = new File(".");
        String[] currentDirectoryElements =  currentDirectory.list();

        for( String element : currentDirectoryElements)
            System.out.println( element );
    }
}
