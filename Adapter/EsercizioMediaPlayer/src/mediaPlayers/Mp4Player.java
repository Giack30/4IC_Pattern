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
public class Mp4Player implements AdvancedMediaPlayer {

    public Mp4Player() {        //permette di riprodurre solo file mp4
    }

    @Override
    public void playVlc(String fileName) {
        //non fa niente 
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("riproduco "+fileName+".mp4 file");
    }
    
}
