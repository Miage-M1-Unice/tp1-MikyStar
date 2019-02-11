package TP1;

import java.io.File;
import java.io.FilenameFilter;

public class Exercice1
{
    public void myLs()
    {
        File currentDirectory = new File(".");
        String[] currentDirectoryElements =  currentDirectory.list();

        for( String element : currentDirectoryElements)
            System.out.println( element );
    }

    public void recursiveListDirectories( File entryPoint )
    {
        for( File aFile : entryPoint.listFiles() )
        {
            if( aFile.isDirectory() )
                recursiveListDirectories( aFile );
            else
                System.out.println( aFile );
        }
    }

    public void recursiveListDirectoriesWithFilter( File entryPoint, FilenameFilter filter)
    {
        for( File aFile : entryPoint.listFiles( filter ) )
        {
            if( aFile.isDirectory() )
                recursiveListDirectoriesWithFilter( aFile, filter );
            else
                System.out.println( aFile );
        }
    }
}
