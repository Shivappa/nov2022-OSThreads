package NumberPrinter;

public class Client {

    public static void main(String[] args) {
        System.out.println("Thread name:" + Thread.currentThread().getName());

        for(int i=1; i<=100; i++){
            NumberPrinter printer = new NumberPrinter(i);
            Thread t = new Thread(printer);
            t.start();
        }
    }
}
