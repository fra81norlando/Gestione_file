package com.example.gestionefile;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Gestore {

    public String leggiFile(String nomeFile, Context c){
        String testoDaRestituire;
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader fileIn = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
            while ( (testoDaRestituire = fileIn.readLine()) != null){
                sb.append(testoDaRestituire + "\n");
            }
        }
        catch(FileNotFoundException e){
            Log.e(tag:"classeGest", msg:"Il file non esiste");
        }
        catch(IOException e){
            Log.e(tag:"classeGest", msg:"impossibile leggere il file");
        }
        return sb.toString();
    }

    public String scriviFile(String nomeFile, Context c){
        String esito;
        FileOutputStream fileO;
        String testoDaScrivere = "Questo + il testo che voglio scrivere";
        try{
            fileO = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
            fileO.write(testoDaScrivere.getBytes());
        }
        catch (FileNotFoundException e) {
            esito = "File non trovato";
        }
        catch (IOException e) {
            esito = "Impossibile scrivere il file";
        }
        return "";
    }
}
