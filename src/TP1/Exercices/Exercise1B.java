package TP1.Exercices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;


/**
 * @see "http://www.java2s.com/Code/Java/JDK-7/UsingtheSimpleFileVisitorclasstotraversefilesystems.htm"
 */
public class Exercise1B
{
    private class ListFiles extends SimpleFileVisitor<Path>
    {

    }

    public void myLs()
    {
        try
        {
            Path currentDirectory = Paths.get( "." );
            ListFiles listFiles = new ListFiles();
            Files.walkFileTree( currentDirectory, listFiles );
        }
        catch (IOException e)
        { e.printStackTrace(); }
    }
}
