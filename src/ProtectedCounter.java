public class ProtectedCounter {
    private int value;

    public ProtectedCounter() {
        this.value = 0;
    }

    public synchronized void inc_syncronized() {
        this.value++;
    }

    public synchronized void dec_syncronized() {
        this.value--;
    }

    public void inc() {
        this.value++;
    }

    public void dec() {
        this.value--;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
