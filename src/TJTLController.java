public class TJTLController {
    private TJTLVista vista;

    public TJTLController() {
        this.vista = new TJTLVista(this);
    }

    public static void main(String args[]) {
        TJTLController controller = new TJTLController();
    }
}
