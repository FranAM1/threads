public class Product extends ProtectedCounter{
    private String description;
    private int producedQuantity;
    private int consumedQuantity;

    public Product(String description) {
        super();
        this.description = description;
        this.producedQuantity = 0;
        this.consumedQuantity = 0;
    }

    public void produce(){
        inc();

        producedQuantity++;
    }

    public synchronized void produce_syncronized(){
        inc_syncronized();

        producedQuantity++;
    }

    public void consume(){
        dec();

        consumedQuantity++;
    }

    public synchronized void consume_syncronized(){
        dec_syncronized();

        consumedQuantity++;
    }

    public int getStock(){
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProducedQuantity() {
        return producedQuantity;
    }

    public void setProducedQuantity(int producedQuantity) {
        this.producedQuantity = producedQuantity;
    }

    public int getConsumedQuantity() {
        return consumedQuantity;
    }

    public void setConsumedQuantity(int consumedQuantity) {
        this.consumedQuantity = consumedQuantity;
    }
}
