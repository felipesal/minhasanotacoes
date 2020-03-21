package com.example.minhasanotaes3;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias anotacaoPreferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.anotacao);

        anotacaoPreferencias = new AnotacaoPreferencias(getApplicationContext());
        FloatingActionButton fab = findViewById(R.id.fab_salvar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editAnotacao.getText().toString().equals("")) {
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG).show();
                } else {
                    anotacaoPreferencias.salvarAnotacao(editAnotacao.getText().toString());
                    Snackbar.make(view, "Anotação salva com sucesso", Snackbar.LENGTH_LONG).show();
                }

            }
        });



        anotacaoPreferencias.recuperarAnotacao();

        if(!anotacaoPreferencias.recuperarAnotacao().equals("")){
            editAnotacao.setText(anotacaoPreferencias.recuperarAnotacao());
        }

    }


}
