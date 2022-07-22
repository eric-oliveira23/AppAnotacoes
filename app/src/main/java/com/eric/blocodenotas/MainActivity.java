package com.eric.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText edtAnotacao;
    private SharedPreferences preferences;
    private AnotacaoPreferencias preferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtAnotacao = findViewById(R.id.edtAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String anotacao = edtAnotacao.getText().toString();
                if (anotacao.equals("") || anotacao.equals(null)){
                    Snackbar.make(view, "Não é possível salvar uma anotação vazia.",
                            Snackbar.LENGTH_SHORT).show();
                }
                else {
                    preferencias.SalvarAnotacao(anotacao);
                    Toast.makeText(MainActivity.this, "Anotação salva!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Recuperar valores
       String anotacao = preferencias.RecuperarAnotacao();

       if (!anotacao.equals("")){
           edtAnotacao.setText(anotacao);
       }

    }
}