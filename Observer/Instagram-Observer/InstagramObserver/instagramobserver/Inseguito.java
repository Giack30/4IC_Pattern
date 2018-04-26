package instagramobserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Florian
 */
class Inseguito implements Observable{

    private String nickName, nome, cognome, bio, descrizione, sitoInternet;
    private int nFoto;

    private Queue<Observer> persone_che_desiderano_seguirmi = new LinkedList<>();     // Persone che hanno fatto la richiesta di follow
    private ArrayList<Observer> persone_che_ho_accettato = new ArrayList<>();        // Persone che mi seguono
    
    private boolean statoCambiato;

    public Inseguito(String nickName, String nome, String cognome, String bio, String descrizione, String sitoInternet, int nFoto) {
        this.nickName = nickName;
        this.nome = nome;
        this.cognome = cognome;
        this.bio = bio;
        this.descrizione = descrizione;
        this.sitoInternet = sitoInternet;
        this.nFoto = nFoto;
    }

    public String getNickName() {
        return nickName;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getSitoInternet() {
        return sitoInternet;
    }

    public void setSitoInternet(String sitoInternet) {
        this.sitoInternet = sitoInternet;
    }

    public int getnFoto() {
        return nFoto;
    }

    public void setnFoto(int nFoto) {
        this.nFoto = nFoto;
    }

    void declina() {
        if(persone_che_desiderano_seguirmi.size()>=1){
            System.out.println("Io "+this.nome+" ho deciso di di declinare "+((Inseguitore)persone_che_desiderano_seguirmi.poll()).getNomeUtente()+" mi dispiace.");
        }else{
            // NON CI SONO PERSONE DA DECLINARE
        }
    }

    void accetta() {
        if(persone_che_desiderano_seguirmi.size()>=1){
            Observer tmp = persone_che_desiderano_seguirmi.poll();
            registerObserver(tmp);
            System.out.println("Io "+this.nome+" ho deciso di di accettare "+((Inseguitore)tmp).getNomeUtente()+".");
        }else{
            // NON CI SONO PERSONE DA ACCETTARE
        }
    }

    @Override
    public void proponiFollow(Observer personaCheVorrebbe) {
        persone_che_desiderano_seguirmi.add(personaCheVorrebbe);
    }
    
    public void aggiungoFoto(){
        statoCambiato = true;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        persone_che_ho_accettato.add(observer);
        // QUANDO L INSEGUITO ACCETTA LA RICHIESTA DELL INSEGUITORE
        ((Inseguitore)observer).setObservable(this);
        // ANCHE L INSEGUITORE DEVE ASSOLUTAMENTE SAPERLO!
    }

    @Override
    public void notifyObserver() {
        if (statoCambiato) {
            for (Observer observer : this.persone_che_ho_accettato) {
                observer.update();
            }
        }
    }

    @Override
    public void unRegisterObserver(Observer observer) {
        persone_che_ho_accettato.remove(observer);
    }

    @Override
    public Object getUpdate() {
        /*
        Per semplicità faccio che ad ogni foto caricata informo i miei followers che ho accettato
        di quante foto ho ora !
        Nulla mi impedisce di inviarli anziche il numero, le foto stesse... 
        o magari anche solo l'ultima fatta...
        */
        return nFoto;
    }

    @Override
    public String toString() {
        return this.nickName+"\n"
                + "\t Name : "+nome+"\n"
                + "\t Surname : "+cognome+"\n"
                + "\t Bio : "+bio+"\n"
                + "\t Description : "+descrizione+"\n"
                + "\t No Of Photos : "+nFoto+"\n";
    }

    int getNFollowers() {
        return this.persone_che_ho_accettato.size();
    }

    int getNPersoneCheSeguo() {
        return 0;
    }
    
    
}
