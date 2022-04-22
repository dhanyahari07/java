class Example{
    synchronized void display(){
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
    Example e;
    T(Example e){
        this.e=e;
    }
    public void run(){
        e.display();
    }
}

public class TSync1 {
    public static void main(String[] args) {

        Example ex=new Example();
        T t1=new T(ex);
        T t2=new T(ex);
        T t3=new T(ex);
        t1.start();
        t2.start();
        t3.start();
      
    }
}

