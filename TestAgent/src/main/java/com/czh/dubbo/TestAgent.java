package com.czh.dubbo;


import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class TestAgent
{
    public static void premain( String args, Instrumentation inst ) throws UnmodifiableClassException {
        // 注册一个 Transformer，该 Transformer在类加载时被调用
        inst.addTransformer(new Transformer(), true);
        inst.retransformClasses(TestClass.class);
        System.out.println("premain done");
    }


}