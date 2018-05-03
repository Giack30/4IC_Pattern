package singleton;
public class SingletonTester{
    /*Questa implementazione funziona solo se non si lavora in multithreading. É molto probabile, infatti, 
    che due o più thread, chiamando il metodo 'getInstance()' della classe 'Singleton', entrino contemporaneamente 
    nella condizione del metodo, e se ciò accadesse, si verrebbero a creare due o più istanze della classe che a 
    questo punto non si potrebbe più chiamare singleton.*/
    public static void main(String[] args){
        System.out.println("Thread name:\tSingleton instance hash code:\n");
        for(int i=0;i<10;i++)
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance().hashCode());
            }, "Thread_"+(i+1)).start();
    }
}