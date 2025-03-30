package top.meethigher.agent;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Method;

public class MyAgent {
    public static void agentmain(String agentArgs, Instrumentation inst) {
        try {
            Class<?> clazz = Class.forName("top.meethigher.utils.ApplicationContextUtils");
            Method method = clazz.getDeclaredMethod("getSimpleBean");
            Object invoke = method.invoke(null);
            Class<?> beanClazz = invoke.getClass();
            Method name = beanClazz.getDeclaredMethod("setName", String.class);
            name.invoke(invoke, "hello, world");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
