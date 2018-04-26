package instagramobserver;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Florian
 */
public class FXMLDocumentController implements Initializable {
    
    private final int N_FOTO_INIZIALMENTE = 3;
    // simuliamo che ci siano 3 immagini per ora (poi potranno essere aggiunte piu immagini...)
    private int nFotoPubblicate = N_FOTO_INIZIALMENTE;    
    
    private Inseguito utente_followato;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        utente_followato = new Inseguito("charlyjordan10","Charly","Jordan","La mia bio","La mia descrizione","ilmiosito.com",N_FOTO_INIZIALMENTE);
        
        Inseguitore uno = new Inseguitore("Pino");
        Inseguitore due = new Inseguitore("Giorgio");
        Inseguitore tre = new Inseguitore("Un altro Giorgio");
        
        uno.richiediFollow(utente_followato);
        due.richiediFollow(utente_followato);
        tre.richiediFollow(utente_followato);
        
        // utente followato puo voler che qualcuno lo followi come NO!
        /*
        TUTTE LE RICHIESTE FATTE VENGONO SALVATE IN UNA CODA
        */
        // HO USATO UNA CODA QUINDI FIFO FIRST IN FIRST OUT
        utente_followato.accetta();     // ACCETTO PINO
        utente_followato.accetta();     // ACCETTO GIORGIO
        utente_followato.declina();     // MA NON ACCETTO L'ALTRO GIORGIO 
        
        edita(utente_followato.getNickName(),utente_followato.getNome(),
                utente_followato.getBio(),utente_followato.getDescrizione(),utente_followato.getSitoInternet());
        
        followers.setText(utente_followato.getNFollowers()+"");
        seguiti.setText(utente_followato.getNPersoneCheSeguo()+"");
    }

    @FXML
    private void spegni() {
        System.exit(0);
    }

    @FXML
    private void editaProfilo() {
        edita("nuovo_nick_name","Nuovo Nome","Nuova Bio","Nuova Descrizione","nuovosito.com");
    }
    
    private void edita(String nick,String nome,String bio,String descrizione,String sito){
        this.nickName.setText(nick);
        this.nome.setText(nome);
        this.bio.setText(bio);
        this.descrizione.setText(descrizione);
        this.sito.setText(sito);
    }

    @FXML
    private void aggiungiFoto() {
        selezionaFoto.setVisible(!selezionaFoto.isVisible());
        dietro.setVisible(!dietro.isVisible());
    }
    
    @FXML
    private void pubblicaFoto() {
        
        if(immaginePrecendente==null){
            return;
        }
        
        hboxImmagini.getChildren().set(incrementaFoto()-N_FOTO_INIZIALMENTE,immaginePrecendente);
        immaginePrecendente = null;
        
        // potrei salvare una variabile tmp
        
        hboxImmagini.getChildren().get(this.nFotoPubblicate-N_FOTO_INIZIALMENTE).setDisable(false); 
        hboxImmagini.getChildren().get(this.nFotoPubblicate-N_FOTO_INIZIALMENTE).setOpacity(1);
      
        selezionaFoto.setVisible(!selezionaFoto.isVisible());
        dietro.setVisible(!dietro.isVisible());
        
        utente_followato.aggiungoFoto();    // INFORMO TUTTI GLI OBSERVER CHE HO CARICATO UNA NUOVA FOTO
    }
    
    @FXML
    private void selezionato(MouseEvent event){
        ImageView immagine = (ImageView) event.getPickResult().getIntersectedNode();
        
        immagine.setScaleX(PERC_INGRANDIMENTO);
        immagine.setScaleY(PERC_INGRANDIMENTO);
        
        if(immaginePrecendente!=null && immaginePrecendente != immagine){   // senza un array bhuum baby
            immaginePrecendente.setScaleX(PERC_IMMAGINE);
            immaginePrecendente.setScaleY(PERC_IMMAGINE);
        }
        
        immaginePrecendente = immagine;
    }
    
    private int incrementaFoto(){
        posts.setText(""+(nFotoPubblicate+1));
        return (nFotoPubblicate<5) ? nFotoPubblicate++ : nFotoPubblicate;
    }

    
    @FXML
    private HBox hboxImmagini;
    @FXML
    private AnchorPane selezionaFoto;
    @FXML
    private VBox dietro;
    @FXML
    private Label nome;
    @FXML
    private Label nickName;
    @FXML
    private Label bio;
    @FXML
    private Label descrizione;
    @FXML
    private Label sito;
    @FXML
    private Label followers;
    @FXML
    private Label seguiti;
    @FXML
    private Label posts;
    
    private final float PERC_INGRANDIMENTO = 1.2f;//&
    private final float PERC_IMMAGINE = 1f;//%
    private ImageView immaginePrecendente = null;

}
