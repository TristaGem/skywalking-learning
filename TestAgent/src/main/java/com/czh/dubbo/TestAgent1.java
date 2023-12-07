package com.czh.dubbo;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 *
 */
public class TestAgent1
{
    public static void premain( String args, Instrumentation inst )
    {
        System.out.println( "this is a hava agent with two args" );
        System.out.println("parameter: " + args + "\n");
    }

    public static void premain(String args) {

        System.out.println( "this is a hava agent with one args" );
        System.out.println("parameter: " + args + "\n");
    }
}
