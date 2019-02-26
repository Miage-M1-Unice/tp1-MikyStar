package TP2;

import java.awt.*;
import java.io.IOException;

public class GenericToString
{
    public String toString( Object object )
    {
        return toString( object, -1);
    }

    public String toString( Object object, int depth )
    {
        return "GenericToString{}";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    static public void main(String[] args)
    {
        System.out.println(new GenericToString().toString(new Point(12,24)));

        Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
        pol.getBounds();
        System.out.println( new GenericToString().toString(pol, 2));
    }
}
