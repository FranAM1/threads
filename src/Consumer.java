public class Consumer implements Runnable {
    private int consumedQuantity;

    private Thread thread;

    public Consumer(int consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public void run() {
        for (int i = 0; i < 100; i++){
//            try {
//                int sleepTime = 0;
//                if (this.model.getController().isTiempoConsumirAleatorio()){
//                    Random rand = new Random();
//
//                    sleepTime = rand.nextInt(this.model.getController().getTiempoConsumir() == 0? 1 : this.model.getController().getTiempoConsumir());
//                }else{
//                    sleepTime = this.model.getController().getTiempoConsumir();
//                }
//
//                Thread.sleep(sleepTime);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public int getConsumedQuantity() {
        return consumedQuantity;
    }

    public void setConsumedQuantity(int consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
