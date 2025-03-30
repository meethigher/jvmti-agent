package top.meethigher.agent;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class AgentMainTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        System.out.println("agentMain transform Class:" + className);
        try {
            ClassPool cp = ClassPool.getDefault();
            ClassClassPath classPath = new ClassClassPath(this.getClass());
            cp.insertClassPath(classPath);
            CtClass cc = cp.get("top.meethigher.Person");
            if (cc.isFrozen()) {
                cc.defrost();
            }
            CtMethod m = cc.getDeclaredMethod("sayHello");
            m.setBody("{ System.out.println(\"hello world\"); }");
            return cc.toBytecode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}