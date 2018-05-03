package singleton;
public class SingletonTester{
    /*Sincronizzando, attraverso la parola chiave synchronized, il metodo 'getInstance()' della classe 'Singleton' 
    verrà istanziato effettivamente un solo oggetto, anche utilizzando il multithreading. Tuttavia questa 
    implementazione non è estremamente efficiente in termini di prestazioni in quanto il metodo, ad ogni 
    chiamata, attenderà l'acquisizione del lock; mentre questo è necessario che venga fatto solamente per i primi 
    thread, che potrebbero creare istanze diverse, e non per tutti gli altri.*/
    public static void main(String[] args){
        System.out.println("Thread name:\tSingleton instance hash code:\n");
        for(int i=0;i<10;i++)
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance().hashCode());
            }, "Thread_"+(i+1)).start();
    }
}