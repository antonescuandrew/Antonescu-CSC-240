package com.example.metronomeproject;

import javafx.scene.media.AudioClip;

public abstract class Pack extends Metronome implements Clickable{
    String highClickFile;
    String lowClickFile;

    AudioClip highClip;
    AudioClip lowClip;

    public Pack(String highClickFile, String lowClickFile) {
        this.highClickFile = highClickFile;
        this.lowClickFile = lowClickFile;

        this.highClip = new AudioClip(getClass().getResource(highClickFile).toExternalForm());
        this.lowClip = new AudioClip(getClass().getResource(lowClickFile).toExternalForm());
    }

    public void highClick(){
        highClip.play();
    }
    public void lowClick(){
        lowClip.play();
    }

    @Override
    public void play(){
        try {
            highClick();
            Thread.sleep(delay);
            for(int i = 0; i < topSignatureNumber - 1; i++){
                lowClick();
                Thread.sleep(delay);
            }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    public void revertToDefault(){
        this.setBpm(120);
        this.setDelay(120);
        this.setTopSignatureNumber(4);
        this.setBottomSignatureNumber(4);
    }
    public void setProperties(long currentBpm, int topTimeSignatureNumber, int bottomTimeSignatureNumber){
        setBpm(currentBpm);
        setTopSignatureNumber(topTimeSignatureNumber);
        setBottomSignatureNumber(bottomTimeSignatureNumber);
    }
}
