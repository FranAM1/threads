public class Producer implements Runnable{
    private int producedQuantity;

    private Thread thread;

    public Producer(int producedQuantity) {
        this.producedQuantity = producedQuantity;
    }

    public void run() {

    }

    public int getProducedQuantity() {
        return producedQuantity;
    }

    public void setProducedQuantity(int producedQuantity) {
        this.producedQuantity = producedQuantity;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
