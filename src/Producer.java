public class Producer implements Runnable{
    private int producedQuantity;

    private Thread thread;

    public Producer(int producedQuantity) {
        this.producedQuantity = producedQuantity;
    }

    public void run() {
        for (int i = 0; i < LabParameters.NUM_ITEMS_PRODUCTORES; i++){

            if (LabParameters.PROTECCION_RC){
                LabParameters.PRODUCT.inc_syncronized();
            }else{
                LabParameters.PRODUCT.inc();
            }

            if (LabParameters.TIEMPO_ALEATORIO_PRODUCTORES){
                try {
                    Thread.sleep(LabParameters.VALOR_TIEMPO_ALEATORIO_PRODUCTORES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    Thread.sleep(LabParameters.VALOR_FIJO_TIEMPO_PRODUCTORES);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (LabParameters.PROTECCION_RC){
                LabParameters.PRODUCT.dec_syncronized();
            }else{
                LabParameters.PRODUCT.dec();
            }
        }
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
