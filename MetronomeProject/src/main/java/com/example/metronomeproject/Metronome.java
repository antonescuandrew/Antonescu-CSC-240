package com.example.metronomeproject;

public class Metronome extends TimeSignature{
    long bpm;
    long delay;

    public void setBpm(long bpm) {
        this.bpm = bpm;
    }

    public void setDelay(long bpm) {
        this.delay = (long)((60.0/bpm) * 1000);
        if(bottomSignatureNumber == 8){
            this.delay = delay / 2;}
        if(bottomSignatureNumber == 2){
            this.delay = delay * 2;
        }
    }
    public void setDelayWithoutCalculation(long delay){
        this.delay = delay;
    }
    public long getBpm() {
        return this.bpm;
    }
    public long getDelay(){
        return this.delay;
    }
}
