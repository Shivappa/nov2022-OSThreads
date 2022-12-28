public class Main {
    public static void main(String[] args) {
        System.out.println("Current thread:" + Thread.currentThread().getName());
        doSomething();
    }

    private static void doSomething() {
        System.out.println("Printing from doSomething() current thread:" + Thread.currentThread().getName());
    }
}