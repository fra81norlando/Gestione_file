package com.example.orlando_txt;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLeggi;
    Button btnScrivi;
    TextView txtContenuto;
    Gestore gf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeggi = (Button) findViewById(R.id.btnLeggi);
        btnScrivi = (Button) findViewById(R.id.btnScrivi);
        txtContenuto = (TextView) findViewById(R.id.txtContenuto);

        gf = new Gestore();
        btnLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String testo;
                testo = gf.leggiFile("prova.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(), testo, Toast.LENGTH_LONG).show();



            }

        });
        btnScrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito;
                esito = gf.scriviFile("prova.txt", getApplicationContext());
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_LONG).show();
            }
        });
    }
}
