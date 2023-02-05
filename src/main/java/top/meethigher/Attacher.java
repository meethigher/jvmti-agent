package top.meethigher;

import com.sun.tools.attach.VirtualMachine;

import java.io.File;

public class Attacher {
    public static void main(String[] args) {
        try {
            String pid = "22928";
            VirtualMachine virtualMachine = VirtualMachine.attach(pid);
            String property = System.getProperty("user.dir");
            String absolutePath = new File(property, "target/jvmti-agent-1.0-jar-with-dependencies.jar").getAbsolutePath();
            virtualMachine.loadAgent(absolutePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}