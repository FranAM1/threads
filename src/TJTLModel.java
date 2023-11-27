import java.util.ArrayList;

public class TJTLModel {

    private TJTLController controller;

    ArrayList<Thread> threads;

    public TJTLModel(TJTLController controller){
        this.threads = new ArrayList<>();
        this.controller = controller;
        resetConfigParameters();
        resetConfigResults();
    }

    public void play(){


        for (int i = 0; i < LabParameters.NUM_PRODUCTORES; i++){
            Producer producer = new Producer(0);

            long iniTimeThread = System.currentTimeMillis();
            Thread thread = new Thread(producer);
            long endTimeThread = System.currentTimeMillis();
            LabResults.MS_CREAR_THREADS += (endTimeThread - iniTimeThread);

            long iniTimeStart = System.currentTimeMillis();
            thread.start();
            long endTimeStart = System.currentTimeMillis();
            LabResults.MS_INICIALIZAR_THREADS += (endTimeStart - iniTimeStart);

            threads.add(thread);
        }

        for (int i = 0; i < LabParameters.NUM_CONSUMIDORES; i++){
            Consumer consumer = new Consumer(0);

            long iniTimeThread = System.currentTimeMillis();
            Thread thread = new Thread(consumer);
            long endTimeThread = System.currentTimeMillis();
            LabResults.MS_CREAR_THREADS += (endTimeThread - iniTimeThread);

            long iniTimeStart = System.currentTimeMillis();
            thread.start();
            long endTimeStart = System.currentTimeMillis();
            LabResults.MS_INICIALIZAR_THREADS += (endTimeStart - iniTimeStart);

            threads.add(thread);
        }
    }

    public void pause(){
        System.out.println("Sistema parado");
    }

    public void resetConfigParameters(){
        LabParameters.PROTECCION_RC = false;
        LabParameters.PREVENIR_STOCK_NEGATIVO = false;

        LabParameters.NUM_PRODUCTORES = 400;
        LabParameters.NUM_ITEMS_PRODUCTORES = 100;
        LabParameters.VALOR_TIEMPO_ALEATORIO_PRODUCTORES = 100;
        LabParameters.VALOR_FIJO_TIEMPO_PRODUCTORES = 100;
        LabParameters.TIEMPO_ALEATORIO_PRODUCTORES = true;

        LabParameters.NUM_CONSUMIDORES = 200;
        LabParameters.NUM_ITEMS_CONSUMIDORES = 100;
        LabParameters.VALOR_TIEMPO_ALEATORIO_CONSUMIDORES = 100;
        LabParameters.VALOR_FIJO_TIEMPO_CONSUMIDORES = 100;
        LabParameters.TIEMPO_ALEATORIO_CONSUMIDORES = true;
    }

    public void resetConfigResults(){
        LabResults.MS_CREAR_THREADS = 0;
        LabResults.MS_INICIALIZAR_THREADS = 0;
        LabResults.MS_PROCESAR_THREADS_PRODUCTORES = 0;
        LabResults.MS_PROCESAR_THREADS_CONSUMIDORES = 0;

        LabResults.CANTIDAD_ITEMS_PRODUCIDOS = new ProtectedCounter();
        LabResults.CANTIDAD_HILOS_PRODUCTORES_INI = new ProtectedCounter();
        LabResults.CANTIDAD_HILOS_PRODUCTORES_FIN = new ProtectedCounter();

        LabResults.CANTIDAD_ITEMS_CONSUMIDOS = new ProtectedCounter();
        LabResults.CANTIDAD_HILOS_CONSUMIDORES_INI = new ProtectedCounter();
        LabResults.CANTIDAD_HILOS_CONSUMIDORES_FIN = new ProtectedCounter();
    }

    public TJTLController getController() {
        return controller;
    }

    public void setController(TJTLController controller) {
        this.controller = controller;
    }
}
