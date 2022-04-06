public class ThreadExample5 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("MyRunnable Running");
            System.out.println("MyRunnable stopped");
        };

        Thread thread = new Thread(runnable);
        thread.start();


    }
    
}
