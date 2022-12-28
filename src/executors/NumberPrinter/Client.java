package executors.NumberPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0; i<100; i++){
            if(i==5 || i==19){
                System.out.println("debug");
            }
            NumberPrinter printer = new NumberPrinter(i);
            executorService.execute(printer);
        }
        executorService.shutdown();
    }
}
