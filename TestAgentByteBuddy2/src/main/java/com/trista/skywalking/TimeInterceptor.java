package com.trista.skywalking;

import net.bytebuddy.implementation.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class TimeInterceptor {
    @RuntimeType
    public static Object intercept(@Origin Method method, @SuperCall Callable<?> callable) throws Exception {
        long start = System.currentTimeMillis();
        try {
            return callable.call(); // Execute the original method
        } finally {
            System.out.println(method.getName() + ":" + (System.currentTimeMillis() - start) + "ms");
        }
    }
}