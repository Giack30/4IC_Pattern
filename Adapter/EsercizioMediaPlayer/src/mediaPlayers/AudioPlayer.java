package mediaPlayers;


import interfaces.MediaPlayer;

/**
 *
 * @author giacomo.ravagnan
 */
public class AudioPlayer implements MediaPlayer{
    MediaAdapter mediaAdapter; //instanza dell'adapter
    @Override
    public void play(String audioType, String fileName) {
        
        if(audioType.equalsIgnoreCase("mp3")){ //formato supportato dal vecchio audioPlayer
            System.out.println("riproduco "+fileName+".mp3 file");
        }
        else if(audioType.equalsIgnoreCase("mp4") || audioType.equalsIgnoreCase("vlc")){ //se formato è diverso creo un'adapter
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("formato "+audioType+" non disponibile");
        }
    }
    
}
