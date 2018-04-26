package instagramobserver;

/**
 *
 * @author Florian
 */
public class Inseguitore implements Observer {

    private String nomeUtente;
    private Observable chiStoInseguendo;

    private int nFotoHaCaricato;

    public Inseguitore(String nome) {
        nomeUtente = nome;
    }

    void richiediFollow(Observable chiVoglioInseguire) {
        System.out.println("Io "+nomeUtente+" vorrei seguire "+((Inseguito)chiVoglioInseguire).getNickName());
        chiVoglioInseguire.proponiFollow(this);
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    @Override
    public void update() {
        System.out.println("Sono "+nomeUtente+" e mi é arrivata la notifica che"+ ((Inseguito) chiStoInseguendo).getNickName() + " ha aggiunto una nuova foto!");
        nFotoHaCaricato = (Integer) (chiStoInseguendo).getUpdate();
    }

    @Override
    public void setObservable(Observable observable) {
        chiStoInseguendo = observable;
    }

    @Override
    public String toString() {
        return "Nome Utente : " + nomeUtente;
    }
    
    
}
