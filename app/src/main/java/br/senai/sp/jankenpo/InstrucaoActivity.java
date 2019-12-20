package br.senai.sp.jankenpo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InstrucaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_instrucao);
    }

    public void fechar(View v){
        //Intent intencao = new Intent(InstrucaoActivity.this,JogoActivity.class);
        //startActivity(intencao);
        finish();
    }
}
