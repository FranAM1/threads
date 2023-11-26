import java.util.ArrayList;

public class TJTLModel {

    private TJTLController controller;

    public TJTLModel(TJTLController controller){
        this.controller = controller;
        resetConfig();
    }

    public void play(){
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < LabParameters.NUM_PRODUCTORES; i++){
            Producer producer = new Producer(0);
            Thread thread = new Thread(producer);
            thread.start();
            threads.add(thread);
        }

        for (int i = 0; i < LabParameters.NUM_CONSUMIDORES; i++){
            Consumer consumer = new Consumer(0);
            Thread thread = new Thread(consumer);
            thread.start();
            threads.add(thread);
        }
    }

    public void resetConfig(){
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

        LabParameters.PRODUCT = new Product("test", 0,0);
    }

    public TJTLController getController() {
        return controller;
    }

    public void setController(TJTLController controller) {
        this.controller = controller;
    }
}
