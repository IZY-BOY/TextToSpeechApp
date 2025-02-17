package com.example.texttospeechgui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TextToSpeechGui extends Application {

    private static final int App_With = 375;
    private static final int App_Height = 475;

    //private TextArea textArea;
    private ComboBox<String>voices, rates, volume;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = createScene();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style.css")).toExternalForm());
        stage.setTitle("TextToSpeech App");
        stage.setScene(scene);
        stage.show();
    }

    private Scene createScene(){
        VBox box = new VBox();
        box.getStyleClass().add("body");

        Label textToSpeechLabel = new Label("Text_To_Speech");
        textToSpeechLabel.getStyleClass().add("text-to-speech-label");
        textToSpeechLabel.setMaxWidth(Double.MAX_VALUE);
        textToSpeechLabel.setAlignment(Pos.CENTER);
        box.getChildren().add(textToSpeechLabel);

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.getStyleClass().add("text-area");
        box.getChildren().add(textArea);

        StackPane textAreaPane = new StackPane();
        textAreaPane.setPadding(new Insets(0, 15, 0, 15));
        textAreaPane.getChildren().add(textArea);
        box.getChildren().add(textAreaPane);

        GridPane settingsPane = createSettingComponents();
        box.getChildren().add(settingsPane);

        Button speakButton = createImageButton();
        StackPane speakButtonPane = new StackPane();
        speakButtonPane.setPadding(new Insets(30, 20, 0, 20));
        speakButtonPane.getChildren().add(speakButton);

        box.getChildren().add(speakButtonPane);

        return new Scene(box, App_With, App_Height);
    }

    private Button createImageButton(){
        Button button = new Button("Speak");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setAlignment(Pos.CENTER);
        button.getStyleClass().add("speak-btn");

        //add image
        ImageView imageView = new ImageView(
                new Image(
                        Objects.requireNonNull(getClass().getResourceAsStream("speak.png"))
                )
        );

        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        button.setGraphic(imageView);

        return button;
    }

    private GridPane createSettingComponents(){
        //initialise the gridPane.
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 0, 0, 0));

        //set the labels
        Label voiceLabel = new Label("Voice");
        voiceLabel.getStyleClass().add("setting-label");

        Label rateLabel = new Label("Rate");
        rateLabel.getStyleClass().add("setting-label");

        Label volumeLabel = new Label("Volume");
        volumeLabel.getStyleClass().add("setting-label");

        //add the labels to their respective rows and columns in the gridPane.
        gridPane.add(voiceLabel, 0, 0);
        gridPane.add(rateLabel, 1, 0);
        gridPane.add(volumeLabel, 2, 0);

        //align the labels horizontally to the center of their pane.
        GridPane.setHalignment(voiceLabel, HPos.CENTER);
        GridPane.setHalignment(rateLabel, HPos.CENTER);
        GridPane.setHalignment(volumeLabel, HPos.CENTER);

        //initialise the combo-boxes
        voices = new ComboBox<>();
        voices.getItems().addAll(
                TextToSpeechController.getVoices()
        ); //imports items from the freetts module in the TextToSpeechController.java
        voices.setValue(voices.getItems().getFirst()); //set the first value of the list as default
        voices.getStyleClass().add("combo-box-setting"); //imports style from the style.css

        rates = new ComboBox<>();
        rates.getItems().addAll(
                TextToSpeechController.getSpeedRates()
        ); //imports items from the TextToSpeechController.java
        rates.setValue(rates.getItems().get(2)); //set the third value of the list as default
        rates.getStyleClass().add("combo-box-setting"); //imports style from the style.css

        volume = new ComboBox<>();
        volume.getItems().addAll(
                TextToSpeechController.getVolumeLevels()
        ); //imports items from the TextToSpeechController.java
        volume.setValue(volume.getItems().get(1)); //set the second value of the list as default
        volume.getStyleClass().add("combo-box-setting");//imports style from the style.css

        //add the combo-boxes to their respective rows and columns in the gridPane.
        gridPane.add(voices, 0, 1);
        gridPane.add(rates, 1, 1);
        gridPane.add(volume, 2, 1);

        gridPane.setAlignment(Pos.CENTER);

        return gridPane;
    }

    public static void main(String[] args) {

        try {
            TextToSpeechGui.launch(TextToSpeechGui.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //launch();
    }
}