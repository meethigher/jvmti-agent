package top.meethigher;

import java.lang.management.ManagementFactory;

public class TestMain {

    public static void main(String[] args) throws Exception {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        System.out.println("pid:" + s);
        Person.start();
    }
}
