import java.util.Random;

public class Producer implements Runnable{
    private int producedQuantity;

    private Thread thread;

    public Producer(int producedQuantity) {
        this.producedQuantity = producedQuantity;
    }

    public void run() {
        long iniTimeRun = System.currentTimeMillis();

        if (LabParameters.PROTECCION_RC){
            LabResults.CANTIDAD_HILOS_PRODUCTORES_INI.inc_syncronized();
        }else{
            LabResults.CANTIDAD_HILOS_PRODUCTORES_INI.inc();
        }

        for (int i = 0; i < LabParameters.NUM_ITEMS_PRODUCTORES; i++){
            if (LabParameters.PROTECCION_RC){
                LabResults.CANTIDAD_ITEMS_PRODUCIDOS.inc_syncronized();
                LabResults.PRODUCT.inc_syncronized();
            }else{
                LabResults.CANTIDAD_ITEMS_PRODUCIDOS.inc();
                LabResults.PRODUCT.inc();
            }

            if (LabParameters.TIEMPO_ALEATORIO_PRODUCTORES){
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(LabParameters.VALOR_TIEMPO_ALEATORIO_PRODUCTORES));
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
        }

        if (LabParameters.PROTECCION_RC){
            LabResults.CANTIDAD_HILOS_PRODUCTORES_FIN.inc_syncronized();
            LabResults.CANTIDAD_HILOS_PRODUCTORES_INI.dec_syncronized();
        }else{
            LabResults.CANTIDAD_HILOS_PRODUCTORES_FIN.inc();
            LabResults.CANTIDAD_HILOS_PRODUCTORES_INI.dec();
        }

        long endTimeRun = System.currentTimeMillis();

        LabResults.MS_PROCESAR_THREADS_PRODUCTORES += (endTimeRun - iniTimeRun);
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
