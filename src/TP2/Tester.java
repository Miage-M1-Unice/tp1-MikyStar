package TP2;

import java.awt.*;

public class Tester
{
    public static void main( String[] args )
    {
        try
        {
            AnalyseurDeClasse.afficheEnTeteClasse( "java.awt.Point" );
        }
        catch (ClassNotFoundException e)
        {
            System.err.println( "Classe introuvable ! : " + e );
        }
    }
}
