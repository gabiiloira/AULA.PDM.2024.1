package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class IMCResultado extends AppCompatActivity {

    TextView txtResulIMC, txtNome, txtPeso, txtAlt;
    ImageView imgResul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        txtResulIMC = findViewById(R.id.txtIMC);
        txtNome = findViewById(R.id.lblNome);
        txtAlt = findViewById(R.id.lblAltura);
        txtPeso = findViewById(R.id.lblPeso);
        imgResul = findViewById(R.id.imgResul);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String nomeS = bundle.getString("nome");
        String alturaS = bundle.getString("altura");
        String pesoS = bundle.getString("peso");

        txtNome.setText(nomeS);
        txtPeso.setText(pesoS);
        txtAlt.setText(alturaS);

        Double altura = Double.parseDouble(alturaS);
        Double peso = Double.parseDouble(pesoS);

        DecimalFormat df = new DecimalFormat("##.##");

        double imc = (peso/(altura*altura));
        String resp = df.format(imc);

        txtResulIMC.setText("IMC: "+resp);

        Log.d("i", resp);
        Toast.makeText(this, resp,Toast.LENGTH_SHORT).show();


        //Integer imc = Integer.parseInt(s);

        //Log.d("Valor do IMC:", bundle.getString("valorIMC"));

        if (imc<=18.5){
            imgResul.setImageResource(R.drawable.abaixopeso);
        }
        if (imc>=18.5 && imc<=24.9) {
            imgResul.setImageResource(R.drawable.normal);
        }
        if (imc>=25 && imc<=29.9) {
            imgResul.setImageResource(R.drawable.sobrepeso);
        }
        if (imc>=30 && imc<=34.9) {
            imgResul.setImageResource(R.drawable.obesidade1);
        }
        if (imc>=35 && imc<=39.9) {
            imgResul.setImageResource(R.drawable.obesidade2);
        }
        if (imc>40) {
            imgResul.setImageResource(R.drawable.obesidade3);
        }

    }
}