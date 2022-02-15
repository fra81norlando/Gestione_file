package com.example.orlando_txt;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

    public class Gestore {

        public Gestore(){}

        public String leggiFile(String nomeFile, Context c) {
            //restituisce il contenuto
            StringBuilder sb = new StringBuilder();//concatena le stringhe

            try {
                BufferedReader fileDaLeggere = new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile)));
                //restituisce oggetto di tipo FileInputStream = orientato a byte 
                String testoDaRestituire;
                //inputStream trasforma da byte a caratteri, bufferedReader trasformiamo i caratteri in una riga dove si può leggere

                while ((testoDaRestituire=fileDaLeggere.readLine())!=null){
                    sb.append(testoDaRestituire + "\n");
                }

            } catch (FileNotFoundException e) {
                Log.e("gestore", "File inesistente");
            } catch (IOException e) {
                Log.e("gestore","impossibile leggere il file");
            }
            return sb.toString();
        }

        public String scriviFile(String nomeFile, Context c) {
            String esito;
            FileOutputStream fileO;

            String testoDaScrivere = "Questo è il testo del file creato";

            try {
                //Apre il file in output, se il file non esiste viene creato
                fileO = c.openFileOutput(nomeFile, Context.MODE_PRIVATE);
                // scrittura del file, dobbiamo scrivere dei byte (accetta solo byte)
                fileO.write(testoDaScrivere.getBytes());
                //chiusura del file
                fileO.close();
               
                esito= "file scritto correttamente";
                
            } catch (FileNotFoundException e) {
                esito = "non sono riuscito a trovare il file";
            } catch (IOException e) {
                esito = "Errore in fase di scrittura del file";
            }
            return esito;
        }
}
