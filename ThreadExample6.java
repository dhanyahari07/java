public class ThreadExample6 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread name is: " + threadName);
        };

        Thread thread = new Thread(runnable,"MyThread");
        thread.start();
        Thread thread1 = new Thread(runnable,"MyThread1");
        thread1.start();

}
