import java.util.Random;

public class Consumer implements Runnable {
    private int consumedQuantity;

    private Thread thread;

    public Consumer(int consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }

    public void run() {
        long iniTimeRun = System.currentTimeMillis();

        if (LabParameters.PROTECCION_RC) {
            LabResults.CANTIDAD_HILOS_CONSUMIDORES_INI.inc_syncronized();
        } else {
            LabResults.CANTIDAD_HILOS_CONSUMIDORES_INI.inc();
        }

        for (int i = 0; i < 100; i++){
            while(LabParameters.IS_PAUSED){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (LabParameters.PROTECCION_RC) {
                LabResults.PRODUCT.consume_syncronized();
            } else {
                LabResults.PRODUCT.consume();
            }

            if(LabParameters.TIEMPO_ALEATORIO_CONSUMIDORES) {
                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(LabParameters.VALOR_TIEMPO_ALEATORIO_CONSUMIDORES));
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
        }

        if (LabParameters.PROTECCION_RC) {
            LabResults.CANTIDAD_HILOS_CONSUMIDORES_FIN.inc_syncronized();
            LabResults.CANTIDAD_HILOS_CONSUMIDORES_INI.dec_syncronized();
        } else {
            LabResults.CANTIDAD_HILOS_CONSUMIDORES_FIN.inc();
            LabResults.CANTIDAD_HILOS_CONSUMIDORES_INI.dec();
        }

        long endTimeRun = System.currentTimeMillis();
        LabResults.MS_PROCESAR_THREADS_CONSUMIDORES += (endTimeRun - iniTimeRun);
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
