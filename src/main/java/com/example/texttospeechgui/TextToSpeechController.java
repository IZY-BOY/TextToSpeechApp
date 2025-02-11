package com.example.texttospeechgui;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.util.ArrayList;

public class TextToSpeechController {
    public static VoiceManager voiceManager = VoiceManager.getInstance();
    public static ArrayList<String> getVoices(){
        System.setProperty("freetts.voices",
                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");

        ArrayList<String> voices = new ArrayList<>();
        for(Voice voice : voiceManager.getVoices()){
            voices.add(voice.getName());
        }

        return voices;
    }
}