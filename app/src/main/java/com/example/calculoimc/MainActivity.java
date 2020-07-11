package com.example.calculoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private sObjetosTela soObjetosTela = new sObjetosTela();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.soObjetosTela.edtAltura = findViewById(R.id.edtAltura);
        this.soObjetosTela.edtPeso = findViewById(R.id.edtPeso);
    }

    public void calcularImc (View view) {
        double valorIMC = 0.0;
        String classificacao = "";
        double altura = 0.0;
        double peso = 0.0;

        altura = Double.parseDouble(this.soObjetosTela.edtAltura.getText().toString());
        peso = Double.parseDouble(this.soObjetosTela.edtPeso.getText().toString());

        valorIMC = (peso / Math.pow(altura, 2));

        if (valorIMC <= 18.4) {
            classificacao = "DESNUTRIÇÃO GRAU I";
        } else if (valorIMC <= 24.9) {
            classificacao = "NORMAL";
        } else if (valorIMC <= 29.9) {
            classificacao = "PRE-OBESIDADE";
        } else if (valorIMC <= 34.5) {
            classificacao = "OBESIDADE GRAU I";
        } else if (valorIMC <= 39.9) {
            classificacao = "OBESIDADE GRAU II";
        } else {
            classificacao = "OBESIDADE GRAU III";
        }
        valorIMC = Double.valueOf(String.format("%.2f", valorIMC));
        Intent vetor = new Intent(this, ResultadoActivity.class);
        vetor.putExtra("valorIMC", valorIMC);
        vetor.putExtra("classificacao", classificacao);
        startActivity(vetor);
    }

    private static class sObjetosTela {
        EditText edtAltura;
        EditText edtPeso;
    }
}
