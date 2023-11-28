public class ProtectedCounter {
    private int value;

    public ProtectedCounter() {
        this.value = 0;
    }

    public synchronized void inc_syncronized() {
        this.value++;

        if (LabParameters.PREVENIR_STOCK_NEGATIVO){
            notifyAll();
        }
    }

    public synchronized void dec_syncronized() {
        if (LabParameters.PREVENIR_STOCK_NEGATIVO){
            while (this.value == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        this.value--;
    }

    public void inc() {
        this.value++;

        if (LabParameters.PREVENIR_STOCK_NEGATIVO){
            notifyAll();
        }
    }

    public void dec() {
        if (LabParameters.PREVENIR_STOCK_NEGATIVO){
            while (this.value == 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        this.value--;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
