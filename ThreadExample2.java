public class ThreadExample2 {
    public static class MyThread extends Thread{
        public void run(){
            System.out.println("MyThread Running");
          //  System.out.println("MyThread stopped");

            }
        }
    public static void main(String[] args){
        MyThread t1 = new MyThread();
        t1.start();
       System.out.println("Main Thread stopped");
        }

    }
    

