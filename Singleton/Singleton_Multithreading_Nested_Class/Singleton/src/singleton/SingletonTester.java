package singleton;
public class SingletonTester{
    /*Un ultimo approccio è quello di utilizzare nella classe Singleton una classe statica interna 'SingletonHelper' 
    in modo da creare l' unica istanza della classe 'Singleton' nel momento della prima chiamata del metodo 
    'getInstance()'. Questa implementazione ovviamente non ha problemi quando si parla di multithreading. Questo è 
    l'approccio più utilizzato per le classi Singleton, in quanto non richiede la sincronizzazione.*/
    public static void main(String[] args){
        System.out.println("Thread name:\tSingleton instance hash code:\n");
        for(int i=0;i<10;i++)
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance().hashCode());
            }, "Thread_"+(i+1)).start();
    }
}