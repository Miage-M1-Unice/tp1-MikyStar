package TP1;

import java.io.File;

public class Exercice1
{
    public static void main( String[] args )
    {
        System.out.println( "Exercice 1A" );

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "1)" );


        File currentDirectory = new File(".");
        String[] currentDirectoryElements =  currentDirectory.list();

        for( String element : currentDirectoryElements)
            System.out.println( element );


        ////////////////////////////////////////////////////////////////////////

        System.out.println( "2)" );

        recursiveListDirectories( new File( ".") );
    }

    private static void recursiveListDirectories( File entryPoint )
    {
        File[] files = entryPoint.listFiles();

        for( File aFile : files )
        {
            if( aFile.isDirectory() )
                recursiveListDirectories( aFile );
            else
                System.out.println( aFile );
        }
    }
}
