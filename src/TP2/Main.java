package TP2;

import java.awt.*;

public class Main
{
    public static void main( String[] args )
    {
        try
        {
            System.out.println( AnalyseurDeClasse.getClasse( "java.awt.Point" ) );
        }
        catch (ClassNotFoundException e)
        {
            System.err.println( "Classe introuvable ! : " + e );
        }
    }
}
