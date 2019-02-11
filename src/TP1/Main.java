package TP1;

import java.io.File;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Exercice 1A" );
        Exercice1 exercice1 = new Exercice1();

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n1)" );
        exercice1.myLs();

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n2)" );
        exercice1.recursiveListDirectories( new File( ".") );

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n3)" );
        exercice1.recursiveListDirectoriesWithFilter(new File("."), new Filtre() );
    }
}
