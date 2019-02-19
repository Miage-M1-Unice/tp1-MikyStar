package TP2;

/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */

import java.lang.reflect.*;
import java.io.*;

public class AnalyseurDeClasse
{

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException
    {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = getClasse( nomClasse ); // CODE A ECRIRE !

        afficheEnTeteClasse( nomClasse );

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /** Retourne la classe dont le nom est passé en paramètre */
    public static Class getClasse( String nomClasse ) throws ClassNotFoundException
    {
        return Class.forName( nomClasse );
    }

    /** Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {" */
    public static void afficheEnTeteClasse( String nomClasse ) throws ClassNotFoundException
    {
        Class cl = getClasse( nomClasse );

        // Accesseurs
        System.out.print( Modifier.toString( cl.getModifiers() ) + " " + getClasse( nomClasse ) );

        // Superclass
        if( ( cl.getSuperclass() != null ) && ( cl.getSuperclass() != Object.class ) )
            System.out.print( " extends " + cl.getSuperclass() );

        // Interfaces
        if( cl.getInterfaces().length != 0 )
        {
            System.out.print( " implements " );

            for( int i = 0; i < cl.getInterfaces().length; i++ )
            {
                System.out.print( cl.getInterfaces()[ i ].getSimpleName() );

                if( i != ( cl.getInterfaces().length - 1 ) )
                    System.out.print( ", " );
            }
        }

        System.out.print(" \n{"); // ! Parce que c'est de cette manière qu'un beau code est indenté
    }

    public static void afficheAttributs(Class cl)
    {
        Field[] fields = cl.getFields();

        for( Field aField : fields )
        {
            String modifier = Modifier.toString( aField.getModifiers() );
            String aclass = aField.getType().getSimpleName();

            System.out.println( "\t" + modifier + " " + aclass + " " + aField.getName() + ";" );
        }
    }

    public static void afficheConstructeurs(Class cl)
    {
        // CODE A ECRIRE
        System.out.println("{}");

    }

    public static void afficheMethodes(Class cl)
    {
        // CODE A ECRIRE
        System.out.println("{}");
    }

    public static String litChaineAuClavier() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args)
    {
        boolean ok = false;

        while(!ok)
        {
            try
            {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
                String nomClasse = litChaineAuClavier();

                analyseClasse(nomClasse);

                ok = true;
            }
            catch(ClassNotFoundException e)
            {
                System.out.println("Classe non trouvée.");
            }
            catch(IOException e)
            {
                System.out.println("Erreur d'E/S!");
            }
        }
    }
}