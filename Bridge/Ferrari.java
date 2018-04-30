public class Ferrari extends Car {

    private final Product product;
    private final String carType;

    Ferrari(Product product, String carType) {
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
        System.out.println("Modifing product "+product.getProductName()+" according to "+carType);
    }
}
