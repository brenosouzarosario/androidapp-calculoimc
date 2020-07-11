package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private sObjetosTela soObjetosTela = new sObjetosTela();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        this.soObjetosTela.txtResultado = findViewById(R.id.txtResultado);
        this.soObjetosTela.txtClassificacao = findViewById(R.id.txtClassificacao);

        Intent vetor = getIntent();

        Double valorIMC = vetor.getDoubleExtra("valorIMC", 0);
        String classificacao = vetor.getStringExtra("classificacao");

        this.soObjetosTela.txtResultado.setText(String.valueOf(valorIMC));
        this.soObjetosTela.txtClassificacao.setText(classificacao);


    }

    private static class sObjetosTela {
        TextView txtResultado;
        TextView txtClassificacao;
    }
}
