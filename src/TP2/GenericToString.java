package TP2;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Field;

public class GenericToString
{
    public String toString( Object object ) throws IllegalAccessException
    {
        return toString( object, -1);
    }

    public String toString( Object object, int depth ) throws IllegalAccessException
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( object.getClass().getName() );
        stringBuilder.append( "[" ).append( retrieveFieldsWithTheirValues( object ) ).append( "]" );


        return stringBuilder.toString();
    }

    private String retrieveFieldsWithTheirValues( Object object ) throws IllegalAccessException
    {
        StringBuilder stringBuilder = new StringBuilder();

        Field[] fields = object.getClass().getFields();

        for( int i = 0; i < fields.length; i++ )
        {
            Field aField = fields[ i ];
            stringBuilder.append( aField.getName() ).append( "=" ).append( aField.get(object) );

            if( ( fields.length > 1 ) && ( i != ( fields.length -1 ) ) )
                stringBuilder.append( "; " );
        }

        return stringBuilder.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    static public void main(String[] args)
    {
        try
        {
            System.out.println(new GenericToString().toString(new Point(12,24)));

            Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
            pol.getBounds();

            System.out.println( new GenericToString().toString(pol, 2));
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
