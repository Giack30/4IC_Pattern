package singleton;
public class SingletonTester{
    /*Questa implementazione funziona solo se non si lavora in multithreading.*/
    public static void main(String[] args){
        Singleton sT1 = Singleton.getInstance();
        System.out.println("First instance aquired");
        Singleton sT2 = Singleton.getInstance();
        System.out.println("Second instance aquired");
        System.out.println("sT1 Singleton instance hash code: " + sT1.hashCode() + "\nsT2 Singleton instance hash code: " + sT2.hashCode());
    }
}