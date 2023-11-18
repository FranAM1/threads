import java.util.Random;

public class Consumidor implements Runnable{

    TJTLModel model;

    public Consumidor(TJTLModel model) {
        this.model = model;
    }

    public void run() {
        if (this.model.getController().getPrimero() > System.currentTimeMillis()){
            this.model.getController().setPrimero(System.currentTimeMillis());
        }

        this.model.getController().getContadorCI().inc();
        for (int i = 0; i < 100; i++){

            this.model.getController().getContador().desc();
            try {
                int sleepTime = 0;
                if (this.model.getController().isTiempoConsumirAleatorio()){
                    Random rand = new Random();

                    sleepTime = rand.nextInt(this.model.getController().getTiempoConsumir() == 0? 1 : this.model.getController().getTiempoConsumir());
                }else{
                    sleepTime = this.model.getController().getTiempoConsumir();
                }

                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.model.getController().getContadorCI().desc();
        this.model.getController().getContadorCA().inc();

        if (this.model.getController().getUltimo() < System.currentTimeMillis()){
            this.model.getController().setUltimo(System.currentTimeMillis());
        }
    }
}
