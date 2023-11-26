public class Product extends ProtectedCounter{
    private String description;
    private int producedQuantity;
    private int consumedQuantity;

    public Product(String description) {
        this.description = description;
        this.producedQuantity = 0;
        this.consumedQuantity = 0;
    }

    public void produce(){
        producedQuantity++;
    }

    public void consume(){
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
