public class ThreadExample7 {
    Runnable runnable = () -> {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread name is: " + threadName+"Running");

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread name is: " + threadName+"stopped");
    }; 
    Thread thread=new Thread(runnable,"MyThread");
    thread.start();
}
