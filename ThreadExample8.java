public class ThreadExample8 {
    public static class StoppableRunnable extends Runnable{
        private boolean stopRequested = false;
        public synchronized void requestStop(){
            stopRequested = true;
        }
        public synchronized boolean isStopRequested(){
            return stopRequested;
        
        }
        private void sleep(int millis){
            try{
                Thread.sleep(millis);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        public void stop(){
            stop = true;
        }
    }
}
