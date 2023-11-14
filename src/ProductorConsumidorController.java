import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;
import java.time.Clock;
import java.time.LocalTime;

public class ProductorConsumidorController {
    private ProductorConsumidorModel model;

    private ProductorConsumidorView view;

    private int numeroProdcutores;

    private int numeroConsumidores;

    private int tiempoConsumir;

    private int tiempoProducir;

    private boolean tiempoConsumirAleatorio;

    private boolean tiempoProducirAleatorio;

    private Contador contador;

    Contador contadorPI;
    Contador contadorPA;

    Contador contadorCI;
    Contador contadorCA;

    LocalTime primero;

    LocalTime ultimo;

    int sleepValue;

    public ProductorConsumidorController() {
        this.contador = new Contador();
        this.contadorPI = new Contador();
        this.contadorPA = new Contador();
        this.contadorCI = new Contador();
        this.contadorCA = new Contador();
        this.primero = LocalTime.now();
        this.ultimo = LocalTime.now();
        this.sleepValue = 100;

        this.model = new ProductorConsumidorModel(this);
        this.view = new ProductorConsumidorView(this);

        this.numeroProdcutores = Integer.parseInt(this.view.getNumeroProductores().getText());
        this.tiempoProducir = this.view.getSliderProductorAleatorio().getValue();
        this.tiempoProducirAleatorio = true;

        this.numeroConsumidores = Integer.parseInt(this.view.getNumeroConsumidores().getText());
        this.tiempoConsumir = this.view.getSliderProductorAleatorio().getValue();
        this.tiempoConsumirAleatorio = true;

    }

    public static void main(String[] args){
        ProductorConsumidorController controller = new ProductorConsumidorController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play(){
        this.contador.setValor(0);
        this.contadorPI.setValor(0);
        this.contadorPA.setValor(0);
        this.contadorCI.setValor(0);
        this.contadorCA.setValor(0);
        this.setPrimero(LocalTime.now());
        this.setUltimo(LocalTime.now());

        this.numeroProdcutores = Integer.parseInt(this.view.getNumeroProductores().getText());
        this.numeroConsumidores = Integer.parseInt(this.view.getNumeroConsumidores().getText());

        this.tiempoConsumirAleatorio = this.view.getCheckBoxConsumidorAleatorio().isSelected();
        this.tiempoProducirAleatorio = this.view.getCheckBoxProductorAleatorio().isSelected();


        this.tiempoConsumir = tiempoConsumirAleatorio ?
                this.view.getSliderConsumidorAleatorio().getValue() :
                Integer.parseInt(this.view.getConsumidorTiempoFijo().getText());

        this.tiempoProducir = tiempoProducirAleatorio ?
                this.view.getSliderProductorAleatorio().getValue() :
                Integer.parseInt(this.view.getProductorTiempoFijo().getText());

        this.model.play();
    }

    public ProductorConsumidorModel getModel() {
        return model;
    }

    public void setModel(ProductorConsumidorModel model) {
        this.model = model;
    }

    public ProductorConsumidorView getView() {
        return view;
    }

    public void setView(ProductorConsumidorView view) {
        this.view = view;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public Contador getContadorPI() {
        return contadorPI;
    }

    public void setContadorPI(Contador contadorPI) {
        this.contadorPI = contadorPI;
    }

    public Contador getContadorPA() {
        return contadorPA;
    }

    public void setContadorPA(Contador contadorPA) {
        this.contadorPA = contadorPA;
    }

    public Contador getContadorCI() {
        return contadorCI;
    }

    public void setContadorCI(Contador contadorCI) {
        this.contadorCI = contadorCI;
    }

    public Contador getContadorCA() {
        return contadorCA;
    }

    public void setContadorCA(Contador contadorCA) {
        this.contadorCA = contadorCA;
    }

    public LocalTime getPrimero() {
        return primero;
    }

    public void setPrimero(LocalTime primero) {
        this.primero = primero;
    }

    public LocalTime getUltimo() {
        return ultimo;
    }

    public void setUltimo(LocalTime ultimo) {
        this.ultimo = ultimo;
    }

    public int getSleepValue() {
        return sleepValue;
    }

    public void setSleepValue(int sleepValue) {
        this.sleepValue = sleepValue;
    }

    public int getNumeroProdcutores() {
        return numeroProdcutores;
    }

    public void setNumeroProdcutores(int numeroProdcutores) {
        this.numeroProdcutores = numeroProdcutores;
    }

    public int getNumeroConsumidores() {
        return numeroConsumidores;
    }

    public void setNumeroConsumidores(int numeroConsumidores) {
        this.numeroConsumidores = numeroConsumidores;
    }

    public int getTiempoConsumir() {
        return tiempoConsumir;
    }

    public void setTiempoConsumir(int tiempoConsumir) {
        this.tiempoConsumir = tiempoConsumir;
    }

    public int getTiempoProducir() {
        return tiempoProducir;
    }

    public void setTiempoProducir(int tiempoProducir) {
        this.tiempoProducir = tiempoProducir;
    }

    public boolean getTiempoConsumirAleatorio() {
        return tiempoConsumirAleatorio;
    }

    public void setTiempoConsumirAleatorio(boolean tiempoConsumirAleatorio) {
        this.tiempoConsumirAleatorio = tiempoConsumirAleatorio;
    }

    public boolean getTiempoProducirAleatorio() {
        return tiempoProducirAleatorio;
    }

    public void setTiempoProducirAleatorio(boolean tiempoProducirAleatorio) {
        this.tiempoProducirAleatorio = tiempoProducirAleatorio;
    }
}
