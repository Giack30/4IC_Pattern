package singleton;
public class SingletonTester{
    /*Un altro approccio è quello di utilizzare nella classe 'Singleton' il campo 'instance' già inizializzato 
    al momento della costruzione delle classi. Questa implementazione ovviamente non ha problemi quando si parla 
    di multithreading, ma presenta un inconveniente ovvero l'istanza viene creata anche se l'applicazione client 
    potrebbe non utilizzarla. Se la tua classe singleton non utilizza molte risorse, questo è l'approccio da 
    utilizzare. Ma nella maggior parte dei casi, bisognerebbe evitare l'istanziazione fino a quando il client 
    non chiama il metodo ‘getInstance()’.*/
    public static void main(String[] args){
        System.out.println("Thread name:\tSingleton instance hash code:\n");
        for(int i=0;i<10;i++)
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance().hashCode());
            }, "Thread_"+(i+1)).start();
    }
}