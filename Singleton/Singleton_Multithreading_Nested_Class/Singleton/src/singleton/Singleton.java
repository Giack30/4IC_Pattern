package singleton;
public class Singleton{
    private Singleton(){}
    private static class SingletonHelper{
        private static final Singleton instance = new Singleton();
    }
    static public Singleton getInstance(){
        return SingletonHelper.instance;
    }
}