import java.time.Clock;
import java.time.LocalTime;
import java.util.Random;

public class Productor implements Runnable{

    ProductorConsumidorModel model;

    public Productor(ProductorConsumidorModel model) {
        this.model = model;
    }

    public void run() {
        if (this.model.getController().getPrimero().isAfter(LocalTime.now())){
            this.model.getController().setPrimero(LocalTime.now());
        }


        this.model.getController().getContadorPI().inc();;
        for (int i = 0; i < 100; i++){
            this.model.getController().getContador().inc();
            try {
                Random rand = new Random();
                int sleepTime = rand.nextInt(100);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.model.getController().getContadorPI().desc();
        this.model.getController().getContadorPA().inc();

        if (this.model.getController().getUltimo().isBefore(LocalTime.now())){
            this.model.getController().setUltimo(LocalTime.now());
        }
    }
}
