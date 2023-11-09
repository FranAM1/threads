public class Contador {
    private int valor;

    public Contador() {
        this.valor = 0;
    }

    public synchronized void inc() {
        this.valor++;
    }

    public synchronized void desc() {
        this.valor--;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
