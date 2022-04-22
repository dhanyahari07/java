import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            service.execute(new Task());
        }
       
        System.out.println("Thread Name"+Thread.currentThread().getName());
   
        
    }
    
}

class Task implements Runnable{
    public void run(){
        System.out.println("Thread Name"+Thread.currentThread().getName());
    }

}

