public class Test {

    public static void main(String[] args) {
        Product product = new CentralLocking("Central Locking");
        Product product2 = new GearLocking("Gear Locking");
        Car car = new Tesla(product , "Tesla Roadster");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        System.out.println();

        car = new Tesla(product2 , "Tesla Roadster");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        System.out.println("---");

        car = new Ferrari(product, "Ferrari Enzo");
        car.produceProduct();
        car.assemble();
        car.printDetails();

        System.out.println();

        car = new Ferrari(product2, "Ferrari Enzo");
        car.produceProduct();
        car.assemble();
        car.printDetails();

    }
}

