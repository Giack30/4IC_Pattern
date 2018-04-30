public class Tesla extends Car {

    private final Product product;
    private final String carType;

    Tesla(Product product, String carType) {
        super(product, carType);
        this.product = product;
        this.carType = carType;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling "+product.getProductName()+" for "+carType);
    }

    @Override
    public void produceProduct() {
        product.produce();
        System.out.println("Modifying product "+product.getProductName()+" according to "+carType);
    }
}
