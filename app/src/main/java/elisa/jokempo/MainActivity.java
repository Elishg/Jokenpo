package elisa.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    private ImageView m1;
    private ImageView m2;
    private int escolha1 = 0;
    private int escolha2 = 0;
    private TextView player1;
    private TextView player2;
    private TextView jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1 = findViewById(R.id.mao1);
        m2 = findViewById(R.id.mao2);
        player1 = findViewById(R.id.p1);
        player2 = findViewById(R.id.p2);
        jogar = findViewById(R.id.play);


        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (escolha1 == 0) {
                    m1.setImageResource(R.drawable.jesus);
                    escolha1++;
                } else if (escolha1 == 1) {
                    m1.setImageResource(R.drawable.papel);
                    escolha1++;
                } else if (escolha1 == 2) {
                    m1.setImageResource(R.drawable.tesoura);
                    escolha1 = 0;
                }
            }
        });
        jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geramao2();
                verifica();
            }
        });

    }

    private void geramao2() {
        escolha2 = (int) (Math.random() * 3);

        if (escolha2 == 0) {
            m2.setImageResource(R.drawable.tesoura);
        } else if (escolha2 == 1) {
            m2.setImageResource(R.drawable.jesus);
        } else if (escolha2 == 2) {
            m2.setImageResource(R.drawable.papel);
        }

    }

    private void verifica(){
        if (escolha1 == escolha2) {
            jogar.setText("Empatou!!!");
        }else if (escolha1 == 0 & escolha2 == 2) {
            jogar.setText("Jogador 1 GANHOU!");
        }else if (escolha1 == 2 & escolha2 == 0) {
            jogar.setText("Jogador 2 GANHOU!");
        }else if(escolha1 > escolha2){
            jogar.setText("Jogador 1 GANHOU!");
        }else if(escolha1 < escolha2){
            jogar.setText("Jogador 2 GANHOU!");
        }
    }
}