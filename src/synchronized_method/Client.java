package synchronized_method;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        Adder adder = new Adder(c);
        Subtractor subtractor = new Subtractor(c);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.getValue());
    }
}
