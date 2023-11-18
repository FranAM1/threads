import java.util.ArrayList;

public class TJTLModel {
    TJTLController controller;

    public TJTLModel(TJTLController controller) {
        this.controller = controller;
    }

    public void play(){
        ArrayList<Thread> threads = new ArrayList<>();
        long totalTimeThread = 0;

        for (int i = 0; i < this.getController().getNumeroProdcutores(); i++){
            Productor productor = new Productor(this);

            long inicioThread = System.currentTimeMillis();
            Thread hilo = new Thread(productor);
            long finalThread = System.currentTimeMillis();
            totalTimeThread += finalThread - inicioThread;

            hilo.start();
            threads.add(hilo);
        }

        for (int i = 0; i < this.getController().getNumeroConsumidores(); i++){
            Consumidor consumidor = new Consumidor(this);

            long inicioThread = System.currentTimeMillis();
            Thread hilo = new Thread(consumidor);
            long finalThread = System.currentTimeMillis();
            totalTimeThread += finalThread - inicioThread;

            hilo.start();
            threads.add(hilo);
        }

        double tiempoMedioThread = (double) totalTimeThread / threads.size();


//        for (Thread hilo : threads) {
//            try {
//                hilo.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public TJTLController getController() {
        return controller;
    }

    public void setController(TJTLController controller) {
        this.controller = controller;
    }
}
