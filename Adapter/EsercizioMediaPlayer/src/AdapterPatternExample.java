
import mediaPlayers.AudioPlayer;
/**
 *
 * @author giacomo.ravagnan
 */
public class AdapterPatternExample {
    public static void main(String[] args) {
       AudioPlayer audioPlayer = new AudioPlayer();
       
       audioPlayer.play("mp3", "canzone1");
       audioPlayer.play("mp4", "canzone2");
       audioPlayer.play("vlc", "canzone3");
       audioPlayer.play("avi", "canzone4");
    }
    
}
