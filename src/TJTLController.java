public class TJTLController {
    private TJTLVista vista;
    private TJTLModel modelo;

    public TJTLController() {
        this.modelo = new TJTLModel(this);
        this.vista = new TJTLVista(this);

    }

    public static void main(String args[]) {
        TJTLController controller = new TJTLController();


    }

    public void play(){
        modelo.play();

        Thread thread = new Thread(this.vista.getResultsViewer());
        thread.start();
    }

    public void resetConfig(){
        modelo.resetConfigParameters();
        modelo.resetConfigResults();
    }
}
