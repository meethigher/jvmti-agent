package top.meethigher;

import com.sun.tools.attach.VirtualMachine;

import java.io.File;
import java.util.Scanner;

public class AttacherMain {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("input pid: ");
            String pid = scanner.next();
            VirtualMachine virtualMachine = VirtualMachine.attach(pid);
            String property = System.getProperty("user.dir");
            String absolutePath = new File(property, "dynamic-agent-test/target/dynamic-agent-test-1.0-jar-with-dependencies.jar").getAbsolutePath();
            virtualMachine.loadAgent(absolutePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}