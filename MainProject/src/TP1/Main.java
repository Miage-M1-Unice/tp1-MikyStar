package TP1;

import TP1.Exercices.Exercice1A;
import TP1.Exercices.Filtre;

import java.io.File;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Exercice 1A" );
        Exercice1A exercice1A = new Exercice1A();

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n1)" );
        exercice1A.myLs();

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n2)" );
        exercice1A.recursiveListDirectories( new File( ".") );

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\n3)" );
        exercice1A.recursiveListDirectoriesWithFilter(new File("."), new Filtre() );

        ////////////////////////////////////////////////////////////////////////

        System.out.println( "\nExercice 1B" );
    }
}
