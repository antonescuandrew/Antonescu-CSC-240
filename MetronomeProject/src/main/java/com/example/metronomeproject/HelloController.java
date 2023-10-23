package com.example.metronomeproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.concurrent.Executors;

public class HelloController {
    ObservableList topTimeSignatures = FXCollections.observableArrayList();
    ObservableList bottomTimeSignatures = FXCollections.observableArrayList();
    ObservableList packChoices = FXCollections.observableArrayList();
    @FXML
    private Label currentBpmLabel;
    @FXML
    private Button playButton;
    @FXML
    private Button setBpmButton;
    @FXML
    private TextField bpmField;
    @FXML
    private Button setTimeButton;
    @FXML
    private ChoiceBox<String> topTimeSignatureChoiceBox;
    @FXML
    private ChoiceBox<String> bottomTimeSignatureChoiceBox;
    @FXML
    private ChoiceBox<String> packChoiceBox;
    @FXML
    private Button setSoundPackButton;

    boolean isToggled = false;
    Pack currentPack = new QuartzPack();
    private void setCurrentBPMLabel(){
        currentBpmLabel.setText(Long.toString(currentPack.getBpm())+ " BPM");
    }
    @FXML
    private void initialize(){
        currentPack.revertToDefault();
        setCurrentBPMLabel();
        loadTimeSignatures();
        loadPackBox();
    }

    @FXML
    private void onDefaultButtonClick(){
        if(!isToggled){
            changePackToQuartzPack();
            currentPack.revertToDefault();
            setCurrentBPMLabel();
            topTimeSignatureChoiceBox.setValue("4");
            bottomTimeSignatureChoiceBox.setValue("4");
            bpmField.clear();
            packChoiceBox.setValue("Quartz");

        }
    }
    @FXML
    private void onSetBpmButtonClick(){
        String inputBpmText = bpmField.getText();
        int inputBpm = Integer.parseInt(inputBpmText);
        setBpm(inputBpm);
    }
    @FXML
    private void onPlayButtonClick(){
        isToggled = !isToggled;
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                while(isToggled){
                    currentPack.play();
                }
            }
        });
        playButton.setText("Play");
        }
    public void changePackToBellPack() {
        currentPack = new BellPack();}
    public void changePackToQuartzPack(){
        currentPack = new QuartzPack();
    }
    public void changePackToRefPack(){
        currentPack = new RefPack();
    }
    public void changePackToStickPack(){
        currentPack = new StickPack();
    }
    public void changePackToTambPack(){
        currentPack = new TambPack();
    }
    public void changePackToToyPack() {
        currentPack = new ToyPack();
    }
    public void setBpm(int bpm){
        currentPack.setBpm(bpm);
        currentPack.setDelay(bpm);
        setCurrentBPMLabel();
    }
    private void loadTimeSignatures(){
        topTimeSignatures.removeAll(topTimeSignatures);
        topTimeSignatures.addAll("2", "3", "4", "5", "6", "7", "8", "9","10", "11",
                "12", "13", "14", "15");
        topTimeSignatureChoiceBox.getItems().addAll(topTimeSignatures);

        bottomTimeSignatures.removeAll(bottomTimeSignatures);
        bottomTimeSignatures.addAll("2", "4", "8");
        bottomTimeSignatureChoiceBox.getItems().addAll(bottomTimeSignatures);

        topTimeSignatureChoiceBox.setValue("4");
        bottomTimeSignatureChoiceBox.setValue("4");
    }
    @FXML
    private void onSetTimeButtonClick(){
        String topTimeChoiceString = (String) topTimeSignatureChoiceBox.getValue();
        int topTimeChoice = Integer.parseInt(topTimeChoiceString);
        currentPack.setTopSignatureNumber(topTimeChoice);
        String bottomTimeChoiceString = (String) bottomTimeSignatureChoiceBox.getValue();
        int bottomTimeChoice = Integer.parseInt(bottomTimeChoiceString);
        currentPack.setBottomSignatureNumber(bottomTimeChoice);
        currentPack.setDelay(currentPack.getBpm());
    }
    private void loadPackBox(){
        packChoices.removeAll(packChoices);
        packChoices.addAll("Quartz", "Bell", "Referee", "Stick", "Tambourine",
                "Toy");
        packChoiceBox.getItems().addAll(packChoices);
        packChoiceBox.setValue("Quartz");
    }
    @FXML
    private void onSetSoundPackButtonClick(){
        long currentBPM = currentPack.getBpm();
        long currentDelay = currentPack.getDelay();
        int currentTopSignatureNumber = currentPack.topSignatureNumber;
        int currentBottomSignatureNumber = currentPack.bottomSignatureNumber;
        String soundPackChoice = (String) packChoiceBox.getValue();
        if(soundPackChoice.equals("Quartz")){
            changePackToQuartzPack();
        }
        if(soundPackChoice.equals("Bell")){
            changePackToBellPack();
        }
        if (soundPackChoice.equals("Referee")){
            changePackToRefPack();
        }
        if(soundPackChoice.equals("Stick")){
            changePackToStickPack();
        }
        if(soundPackChoice.equals("Tambourine")){
            changePackToTambPack();
        }
        if(soundPackChoice.equals("Toy")){
            changePackToToyPack();
        }
        currentPack.setProperties(currentBPM, currentTopSignatureNumber, currentBottomSignatureNumber);
        currentPack.setDelayWithoutCalculation(currentDelay);
    }
}