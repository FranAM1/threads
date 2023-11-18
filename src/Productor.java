import java.util.Random;

public class Productor implements Runnable{

    TJTLModel model;

    public Productor(TJTLModel model) {
        this.model = model;
    }

    public void run() {
        if (this.model.getController().getPrimero() > System.currentTimeMillis()){
            this.model.getController().setPrimero(System.currentTimeMillis());
        }


        this.model.getController().getContadorPI().inc();;
        for (int i = 0; i < 100; i++){
            this.model.getController().getContador().inc();
            try {
                int sleepTime = 0;
                if (this.model.getController().isTiempoProducirAleatorio()){
                    Random rand = new Random();
                    sleepTime = rand.nextInt(this.model.getController().getTiempoProducir() == 0 ? 1 : this.model.getController().getTiempoProducir());
                }else{
                    sleepTime = this.model.getController().getTiempoProducir();
                }

                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.model.getController().getContadorPI().desc();
        this.model.getController().getContadorPA().inc();

        if (this.model.getController().getUltimo() < System.currentTimeMillis()){
            this.model.getController().setUltimo(System.currentTimeMillis());
        }
    }
}
