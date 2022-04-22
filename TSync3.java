class Example{
    synchronized static void display(){
        Thread g=Thread.currentThread();
        for(int i=1;i<=5;i++){
            System.out.println(g.getName()+" "+i);
            try{
                Thread.sleep(400);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}

class T extends Thread{
   
    public void run(){
        Example.display();
    }
}

public class TSync3 {
    public static void main(String[] args) {

        Example ex=new Example();
        T t1=new T();
        T t2=new T();
        T t3=new T();
        t1.start();
        t2.start();
        t3.start();
      
    }
}

