import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
public class ReentrantLockDemo {
  public static void main(String[] args) {
    ReentrantLock rl = new ReentrantLock();
    
    Thread t[] = new Thread[4];
    for(int i=1;i<4;i++) {
      t[i] = new Thread(new Task1(rl, "Thread " + i));
    }
    
    for(int i=1;i<4;i++) {
      t[i].start();
    }
    
  }
}
class Task implements Runnable {
  
  String name;
  ReentrantLock rl;
  
  public Task(ReentrantLock rl, String name) {
    this.rl = rl;
    this.name = name;
  }
  public void run() {
    boolean bFlag = false;
    while(!bFlag) {
      boolean bLock = rl.tryLock();
      if(bLock) {
        try {
          System.out.println(name + " going to acquire the lock at: " + new Date());
          Thread.sleep(1000);
          
          rl.lock();
          try {
            System.out.println(name + " acquired the lock at: " + new Date());
            Thread.sleep(1000);
            System.out.println("Acquired lock: " + rl.isLocked());
          }
          catch(InterruptedException e) {
            e.printStackTrace();
          }
          finally {
            System.out.println(name + " releasing the lock");
            rl.unlock();
          }
          
          System.out.println("Lock hold count: " + rl.getHoldCount());
          System.out.println("Queue length: " + rl.getQueueLength());
          System.out.println("Acquired lock: " + rl.isLocked());
          System.out.println("Completed execution of " + name);
          bFlag = true;
          
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        finally {
          System.out.println(name + " releasing the lock..");
          rl.unlock();
          System.out.println("Lock hold count: " + rl.getHoldCount());
        }
      }
      else {
        System.out.println(name + " is waiting for the lock..");
        try {
          Thread.sleep(1000);
        }
        catch(InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    
  }
  
}