package br.senai.sp.jankenpo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class  JogoActivity extends AppCompatActivity {

    LinearLayout llPrincipal;
    RadioGroup rgGrupo;
    ImageView ivVoce, ivComputador, ivVs;
    TextView tvVitoria, tvDerrota, tvEmpate, tvJogadas;
    int[][] jogadas = {{0,2,1},
                       {1,0,2},
                       {2,1,0}};
    int[] imagens = {R.drawable.pedra_grande,R.drawable.papel_grande, R.drawable.tesoura_grande};
    int[] imagens_arena = {R.drawable.vs,R.drawable.lose,R.drawable.win};
    int[] cores =   {Color.parseColor("#FFFF00"),Color.parseColor("#FF0000"),Color.parseColor("#0000FF")};
    int[] placar = {0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_jogo);

        rgGrupo = findViewById(R.id.rgGrupo);
        ivComputador = findViewById(R.id.ivComputador);
        ivVoce = findViewById(R.id.ivVoce);
        ivVs = findViewById(R.id.ivVs);
        tvDerrota = findViewById(R.id.tvDerrota);
        tvEmpate = findViewById(R.id.tvEmpate);
        tvJogadas = findViewById(R.id.tvJogadas);
        tvVitoria = findViewById(R.id.tvVitoria);
        llPrincipal = findViewById(R.id.llPrincipal);

        ivComputador.setImageResource(0);
        ivVoce.setImageResource(0);
    }

    public void pedra(View v){
        jogar(0);
    }

    public void papel(View v){
        jogar(1);
    }

    public void tesoura(View v){
        jogar(2);
    }

    private void jogar(int iJogador){
        int iComputador = (new Random()).nextInt(3);
        placar[jogadas[iComputador][iJogador]]++;
        placar[3]++;

        ivVoce.setImageResource(imagens[iJogador]);
        ivComputador.setImageResource(imagens[iComputador]);
        ivVs.setImageResource(imagens_arena[jogadas[iComputador][iJogador]]);
        llPrincipal.setBackgroundColor(cores[jogadas[iComputador][iJogador]]);

        tvVitoria.setText("Vitórias: " + String.valueOf(placar[2]));
        tvDerrota.setText("Derrotas: " + String.valueOf(placar[1]));
        tvEmpate.setText("Empates: " + String.valueOf(placar[0]));
        tvJogadas.setText("Jogadas: " + String.valueOf(placar[3]));
    }

    public void reiniciar(View v){
        Intent intencao = new Intent(JogoActivity.this,SplashActivity.class);
        startActivity(intencao);
        finish();
    }

    public void instrucoes(View v){
        Intent intencao = new Intent(JogoActivity.this,InstrucaoActivity.class);
        startActivity(intencao);
        //finish();
    }
}
