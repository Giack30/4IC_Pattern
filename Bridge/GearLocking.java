public class GearLocking implements Product{
    private final String productName;

    GearLocking(String productName){
        this.productName = productName;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void produce() {
        System.out.println("Producing gear locking system");
    }
}
