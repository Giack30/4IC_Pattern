public class CentralLocking implements Product {

    private final String productName;

    CentralLocking(String productName){
        this.productName = productName;
    }

    @Override
    public String getProductName(){
        return productName;
    }

    @Override
    public void produce(){
        System.out.println("producing central locking system");
    }
}
