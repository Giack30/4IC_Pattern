package mediaPlayers;


import interfaces.AdvancedMediaPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    public VlcPlayer() {        //permette di riprodurre solo file vlc
    }
    @Override
    public void playVlc(String fileName) {
       System.out.println("riproduco "+fileName+".vlc file"); //non fa niente 
    }

    @Override
    public void playMp4(String fileName) {
        //non fa niente 
    }
}
