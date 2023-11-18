public class TJTLController {
    private TJTLModel model;

    private TJTLVista view;

    private int numeroProdcutores;

    private int numeroConsumidores;

    private int tiempoConsumir;

    private int tiempoProducir;

    private boolean tiempoConsumirAleatorio;

    private boolean tiempoProducirAleatorio;

    private Contador contador;

    private Contador contadorPI;
    private Contador contadorPA;

    private Contador contadorCI;
    private Contador contadorCA;

    private long primero;

    private long ultimo;

    private long tiempoTotal;

    private long tiempoTotalThread;

    private long tiempoMedioThread;

    private long tiempoTotalStart;

    private long tiempoMedioStart;

    private int sleepValue;

    public TJTLController() {
        this.contador = new Contador();
        this.contadorPI = new Contador();
        this.contadorPA = new Contador();
        this.contadorCI = new Contador();
        this.contadorCA = new Contador();
        this.primero = 0;
        this.ultimo = 0;
        this.tiempoTotal = 0;
        this.tiempoTotalThread = 0;
        this.tiempoMedioThread = 0;
        this.tiempoTotalStart = 0;
        this.tiempoMedioStart = 0;
        this.sleepValue = 100;

        this.model = new TJTLModel(this);
        this.view = new TJTLVista(this);

        this.numeroProdcutores = Integer.parseInt(this.view.getNumeroProductores().getText());
        this.tiempoProducir = this.view.getSliderProductorAleatorio().getValue();
        this.tiempoProducirAleatorio = true;

        this.numeroConsumidores = Integer.parseInt(this.view.getNumeroConsumidores().getText());
        this.tiempoConsumir = this.view.getSliderProductorAleatorio().getValue();
        this.tiempoConsumirAleatorio = true;

    }

    public static void main(String[] args){
        TJTLController controller = new TJTLController();

        Thread hilo = new Thread(controller.getView());
        hilo.start();
    }

    public void play(){
        this.contador.setValor(0);
        this.contadorPI.setValor(0);
        this.contadorPA.setValor(0);
        this.contadorCI.setValor(0);
        this.contadorCA.setValor(0);
        this.primero = 0;
        this.ultimo = 0;
        this.tiempoTotal = 0;

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

    public TJTLModel getModel() {
        return model;
    }

    public void setModel(TJTLModel model) {
        this.model = model;
    }

    public TJTLVista getView() {
        return view;
    }

    public void setView(TJTLVista view) {
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

    public boolean isTiempoConsumirAleatorio() {
        return tiempoConsumirAleatorio;
    }

    public void setTiempoConsumirAleatorio(boolean tiempoConsumirAleatorio) {
        this.tiempoConsumirAleatorio = tiempoConsumirAleatorio;
    }

    public boolean isTiempoProducirAleatorio() {
        return tiempoProducirAleatorio;
    }

    public void setTiempoProducirAleatorio(boolean tiempoProducirAleatorio) {
        this.tiempoProducirAleatorio = tiempoProducirAleatorio;
    }

    public long getPrimero() {
        return primero;
    }

    public void setPrimero(long primero) {
        this.primero = primero;
    }

    public long getUltimo() {
        return ultimo;
    }

    public void setUltimo(long ultimo) {
        this.ultimo = ultimo;
    }

    public long getTiempoTotalThread() {
        return tiempoTotalThread;
    }

    public void setTiempoTotalThread(long tiempoTotalThread) {
        this.tiempoTotalThread = tiempoTotalThread;
    }

    public long getTiempoMedioThread() {
        return tiempoMedioThread;
    }

    public void setTiempoMedioThread(long tiempoMedioThread) {
        this.tiempoMedioThread = tiempoMedioThread;
    }

    public long getTiempoTotalStart() {
        return tiempoTotalStart;
    }

    public void setTiempoTotalStart(long tiempoTotalStart) {
        this.tiempoTotalStart = tiempoTotalStart;
    }

    public long getTiempoMedioStart() {
        return tiempoMedioStart;
    }

    public void setTiempoMedioStart(long tiempoMedioStart) {
        this.tiempoMedioStart = tiempoMedioStart;
    }
}
