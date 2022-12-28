package helloWorldPrinter;

public class Client {

    public static void main(String[] args) {
        System.out.println("Thread name:" + Thread.currentThread().getName());
        HelloWorldPrinter printer = new HelloWorldPrinter();
        Thread t = new Thread(printer);
        t.start();
    }
}
