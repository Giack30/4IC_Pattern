package singleton;
public class SingletonTester{
    /*Mentre, nell’esempio precedente, la parola chiave synchronized gestiva l’accesso all’intero metodo, ora 
    viene gestito l’accesso solo per entrare nella seconda condizione, risparmiando così tempo inutile per 
    l'acquisizione del lock. In questo modo, più thread possono passare contemporaneamente la prima condizione 
    ma per la seconda entra in gioco la sincronizzazione. In termini di prestazioni è di certo migliore, in quanto 
    più veloce. La precedente implementazione è sicuramente la più ottimizzata, d' altra però, è un' implementazione 
    scorretta in quanto non tiene conto dell'interazione tra thread e memoria di cui fa uso Java. Quando si scrivono 
    programmi a thread singolo, non è possibile vedere il ri-ordine delle operazioni di memoria. Con i programmi 
    multithreading, la situazione è abbastanza diversa: un thread può leggere le posizioni di memoria scritte da 
    un altro thread. Se il thread A modifica alcune variabili in un certo ordine, in assenza di sincronizzazione, 
    il thread B potrebbe non vederle nello stesso ordine, o potrebbe non vederle neanche. Ciò potrebbe risultare dal 
    fatto che il compilatore ha riordinato le istruzioni temporaneamente o ha memorizzato una variabile in un registro 
    e l'ha scritta in memoria in un secondo momento; o perché il processore ha eseguito le istruzioni in parallelo o in 
    un ordine diverso da quello specificato dal compilatore; oppure perché le istruzioni erano in diverse regioni di 
    memoria, e la cache aggiorna le corrispondenti posizioni di memoria in un ordine diverso da quello in cui sono state 
    scritte. In ogni caso, i programmi multithreading sono intrinsecamente meno prevedibili,,a meno che non si assicuri 
    esplicitamente che i thread abbiano una visione coerente della memoria utilizzando appunto la sincronizzazione. Ma 
    cosa significa realmente 'sincronizzazione'? Java considera ogni thread come se fosse eseguito sul proprio 
    processore con la propria memoria locale, ognuno dei quali parla e si sincronizza con una memoria principale 
    condivisa. Quando un thread effettua una modifica nella sua memoria locale, tale modifica dovrebbe eventualmente 
    apparire anche nella memoria principale, e il JMM (Java Memory Model) definisce le regole per il momento in cui 
    la JVM (Java Virtual Machine) deve trasferire i dati dalla memoria locale alla principale, così da sincronizzarle. 
    Questa è quella che viene chiamata 'sincronizzazione'. Ora, questa implementazione si basa sull' utilizzo non 
    sincronizzato del campo 'instance'. Questo potrebbe sembrare essere innocuo, ma non lo è. Per capire perché, 
    immaginiamo che il thread A si trovi all'interno del blocco synchronized, e stia eseguendo l' istruzione 
    'instance = new SingleTon()', mentre il thread B sta in questo momento entrando nel metodo 'getInstance()'. 
    Consideriamo l'effetto sulla memoria di questa inizializzazione. La memoria verrà assegnata all'istanza e al campo 
    'instance' verrà assegnato un riferimento all'oggetto appena creato. Tuttavia, poiché il thread B non viene 
    eseguito all'interno di un blocco synchronized, è possibile che queste operazioni di memoria vengano visualizzate 
    in un ordine diverso rispetto a quello eseguito da il thread A. Potrebbe essere il caso che B veda questi eventi 
    nel seguente ordine: 
    1- allocazione memoria,
    2- assegnazione del riferimento dell' oggetto al campo 'instance',
    3- chiamata del costruttore.
    Supponiamo che il thread B arrivi dopo che la memoria è stata allocata e il campo 'instance' sia stato impostato, 
    ma prima che venga chiamato il costruttore. Il metodo vede che 'instance' non è nullo, salta il blocco synchronized 
    e restituisce un riferimento a una parte costruita di 'instance' ma non completa! A questo punto avremo un risultato 
    indesiderato. Va notato che questa implementazione potrebbe, in effetti, funzionare su alcuni tipi di versioni JVM, 
    poiché poche JVM implementano correttamente il JMM.*/
    public static void main(String[] args){
        System.out.println("Thread name:\tSingleton instance hash code:\n");
        for(int i=0;i<10;i++)
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + Singleton.getInstance().hashCode());
            }, "Thread_"+(i+1)).start();
    }
}