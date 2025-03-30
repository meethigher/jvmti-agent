package top.meethigher;

public class Person {

    public void sayHello() {
        System.out.println("halo wode");
    }

    public static void start() {
        while (true) {
            try {
                new Person().sayHello();
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
