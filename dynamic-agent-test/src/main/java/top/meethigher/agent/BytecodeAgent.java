package top.meethigher.agent;


import java.lang.instrument.Instrumentation;

public class BytecodeAgent {
    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new PreMainTransformer(), true);
        System.out.println("premain agent loaded !");
    }

    public static void agentmain(String args, Instrumentation inst) {
        inst.addTransformer(new AgentMainTransformer(), true);
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses(top.meethigher.Person.class);
            System.out.println("Agent load done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}