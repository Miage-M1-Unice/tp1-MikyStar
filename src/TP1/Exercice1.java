package TP1;

import java.io.File;
import java.io.FilenameFilter;

public class Exercice1
{
    public static void main( String[] args )
    {
        System.out.println( "Exercice 1A" );

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n1)" );


        File currentDirectory = new File(".");
        String[] currentDirectoryElements =  currentDirectory.list();

        for( String element : currentDirectoryElements)
            System.out.println( element );


        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n2)" );

        recursiveListDirectories( new File( ".") );

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n3)" );

        recursiveListDirectoriesWithFilter(new File("."), new Filtre() );
    }


    ///////////////////////////////////////////////////////////////////////////

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

    private static void recursiveListDirectoriesWithFilter( File entryPoint, FilenameFilter filter)
    {
        File[] files = entryPoint.listFiles( filter );

        for( File aFile : files )
        {
            if( aFile.isDirectory() )
                recursiveListDirectoriesWithFilter( aFile, filter );
            else
                System.out.println( aFile );
        }
    }
}
