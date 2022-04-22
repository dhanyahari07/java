
public class ThreadExample9 {
    public static void main(String[] args) {
    //job1
    System.out.println("Application started");
    //job2
    MyTask task=new MyTask();
    task.start();

    //job3
    for(int i=0;i<10;i++)
    {
        System.out.println("^^ printing document"+i+"printer1");
    }
    //job4
    System.out.println("Application finished");
    } 
}

class MyTask extends Thread{
    @Override
    public void run(){
        for(int doc=0;doc<10;doc++)
        {
            System.out.println("@@ printing document"+doc+"printer2");
        }       
    }    
}