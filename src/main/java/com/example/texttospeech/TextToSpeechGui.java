package com.example.texttospeech;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TextToSpeechGui extends Application {

    private static final int App_With = 375;
    private static final int App_Height = 475;

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = createScene();
        stage.setTitle("TextToSpeech App");
        stage.setScene(scene);
        stage.show();
    }

    private Scene createScene(){
        VBox box = new VBox();

        Label textToSpeechLabel = new Label("Text_To_Speech");
        textToSpeechLabel.setMaxWidth(Double.MAX_VALUE);
        textToSpeechLabel.setAlignment(Pos.CENTER);
        box.getChildren().add(textToSpeechLabel);
        return new Scene(box, App_With, App_Height);
    }

    public static void main(String[] args) {
        launch();
    }
}