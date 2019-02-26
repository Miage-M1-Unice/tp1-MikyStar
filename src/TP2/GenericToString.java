package TP2;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;

public class GenericToString
{
    static int depthCounter = 0;

    public String toString( Object object ) throws IllegalAccessException
    {
        return toString( object, -1);
    }

    public String toString( Object object, int depth ) throws IllegalAccessException
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append( object.getClass().getName() );
        stringBuilder.append( "[" );
        stringBuilder.append( retrieveFieldsWithTheirValues( object, depth ) );
        stringBuilder.append( "; serialVersionUID=" ).append( getSerialVersionUID( object ) );
        stringBuilder.append( "]" );


        return stringBuilder.toString();
    }

    private String retrieveFieldsWithTheirValues( Object object, int depth ) throws IllegalAccessException
    {
        StringBuilder stringBuilder = new StringBuilder();

        Field[] fields = object.getClass().getFields();

        for( int i = 0; i < fields.length; i++ )
        {
            Field aField = fields[ i ];

            Class fieldClass = aField.getType();

            if( !fieldClass.isArray() )
            {
                if( fieldClass.isPrimitive() )
                {
                    stringBuilder.append( aField.getName() ).append( "=" ).append( aField.get(object) );

                    if( ( fields.length > 1 ) && ( i != ( fields.length -1 ) ) )
                        stringBuilder.append( "; " );
                }
                else
                {
                    if( depthCounter < depth )
                    {
                        depth++;
                        stringBuilder.append( toString( aField ) );
                    }
                }
            }
            else
            {
                Object[] theArray = (Object[]) aField.get( object );
                toStringArray( theArray, depth );
            }
        }

        return stringBuilder.toString();
    }

    private String toStringArray( Object[] array, int depth ) throws IllegalAccessException
    {
        StringBuilder stringBuilder = new StringBuilder();

        if( array.getClass().isPrimitive() )
        {
            for( int i = 0; i < array.length; i++ )
            {
                stringBuilder.append( array[ i ].toString() );

                if( ( array.length > 1 ) && ( i != ( array.length -1 ) ) )
                    stringBuilder.append( ", " );
            }
        }
        else
        {
            for( int i = 0; i < array.length; i++)
            {
                stringBuilder.append( retrieveFieldsWithTheirValues( array[ i ], depth ) );
            }
        }

        return stringBuilder.toString();
    }

    private String getSerialVersionUID( Object object )
    {
        return String.valueOf(ObjectStreamClass.lookup( object.getClass() ).getSerialVersionUID());
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
