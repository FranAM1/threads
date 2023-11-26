public class Consumer implements Runnable {
    private int consumedQuantity;

    private Thread thread;

    public Consumer(int consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public void run() {
        for (int i = 0; i < 100; i++){

            if(LabParameters.PROTECCION_RC) {

            } else {

            }

            if(LabParameters.TIEMPO_ALEATORIO_CONSUMIDORES) {
                try {
                    Thread.sleep(LabParameters.VALOR_TIEMPO_ALEATORIO_CONSUMIDORES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(LabParameters.VALOR_FIJO_TIEMPO_CONSUMIDORES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if(LabParameters.PROTECCION_RC) {

            } else {

            }

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
