package com.example.mariajosemolina.magiccounterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.graphics.Color;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {
    int p1Lives=20;
    int p1Poison=0;
    int p2Lives=20;
    int p2Poison=0;

    Button p1LifeMinus;
    Button p1LifePlus;
    TextView p1LifeScore;
    Button p1PoisonMinus;
    Button p1PoisonPlus;
    TextView p1PoisonScore;
    Button p2LifeMinus;
    Button p2LifePlus;
    TextView p2LifeScore;
    Button p2PoisonMinus;
    Button p2PoisonPlus;
    TextView p2PoisonScore;

    Button resetButton;
    Button exitButton;

    public void resetScreen() {
        p1LifeMinus.setEnabled(true);
        p2LifeMinus.setEnabled(true);
        p1LifePlus.setEnabled(true);
        p2LifePlus.setEnabled(true);

        p1PoisonMinus.setEnabled(true);
        p2PoisonMinus.setEnabled(true);
        p1PoisonPlus.setEnabled(true);
        p2PoisonPlus.setEnabled(true);

        p1Lives = 20;
        p2Lives = 20;

        p1Poison=0;
        p2Poison=0;

        p1LifeScore.setText(String.valueOf(p1Lives));
        p2LifeScore.setText(String.valueOf(p2Lives));

        p1PoisonScore.setText(String.valueOf(p1Poison));
        p2PoisonScore.setText(String.valueOf(p2Poison));

        p1LifeScore.setTextColor(Color.BLACK);
        p2LifeScore.setTextColor(Color.BLACK);
    }

    public void askExit() {

        String btn_yes = "Yes";
        String btn_no = "No";
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setTitle("Are you sure you want to Exit?")
                .setCancelable(false)
                .setMessage("Leru Leru")
                .setPositiveButton(btn_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(1);
                    }
                })
                .setNegativeButton(btn_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    public void showWinner(String p) {

        String btn_reset = "Reset";
        String btn_close = "Exit";
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                //.setTitle(MainActivity.this.getResources().getString(R.string.app_name))
                .setTitle(p + " won!")
                .setCancelable(false)
                .setMessage("Leru Leru")
                //.setIcon(R.drawable.logo)
                .setPositiveButton(btn_reset, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resetScreen();
                    }
                })
                .setNegativeButton(btn_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(1);
                    }
                })
                .show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        p1LifeMinus = (Button) findViewById(R.id.p1_life_minus);
        p1LifePlus = (Button) findViewById(R.id.p1_life_plus);
        p1LifeScore = (TextView) findViewById(R.id.p1_lifeScore);
        p1PoisonMinus = (Button) findViewById(R.id.p1_poison_minus);
        p1PoisonPlus = (Button) findViewById(R.id.p1_poison_plus);
        p1PoisonScore = (TextView) findViewById(R.id.p1_poisonScore);
        p2LifeMinus = (Button) findViewById(R.id.p2_life_minus);
        p2LifePlus = (Button) findViewById(R.id.p2_life_plus);
        p2LifeScore = (TextView) findViewById(R.id.p2_lifeScore);
        p2PoisonMinus = (Button) findViewById(R.id.p2_poison_minus);
        p2PoisonPlus = (Button) findViewById(R.id.p2_poison_plus);
        p2PoisonScore = (TextView) findViewById(R.id.p2_poisonScore);
        resetButton = (Button) findViewById(R.id.resetButton);
        exitButton = (Button) findViewById(R.id.exitButton);

        p1LifeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1Lives = p1Lives - 1;

                if (p1Lives <= 5){
                    p1LifeScore.setTextColor(Color.RED);
                }
                else if (p1Lives > 5){
                    p1LifeScore.setTextColor(Color.BLACK);
                }
                if (p1Lives <= 0){
                    showWinner("Player 2");

                }
                p1LifeScore.setText(String.valueOf(p1Lives));
            }
        });

        p1LifePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1Lives = p1Lives + 1;
                if (p1Lives > 5){
                    p1LifeScore.setTextColor(Color.BLACK);
                }
                p1LifeScore.setText(String.valueOf(p1Lives));
            }
         });

        p1PoisonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1Poison = p1Poison - 1;
                if (p1Poison <= 0)
                    p1Poison = 0;
                p1PoisonScore.setText(String.valueOf(p1Poison));
            }
        });
       p1PoisonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1Poison = p1Poison + 1;
                if (p1Poison >= 10){
                    showWinner("Player 2");
                }
                p1PoisonScore.setText(String.valueOf(p1Poison));
            }
        });

        p2LifeMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2Lives = p2Lives - 1;

                if (p2Lives <= 5){
                    p2LifeScore.setTextColor(Color.RED);
                }
                else if (p2Lives > 5){
                    p2LifeScore.setTextColor(Color.BLACK);
                }
                if (p2Lives <= 0){
                    showWinner("Player 1");

                }
                p2LifeScore.setText(String.valueOf(p2Lives));
            }
        });
        p2LifePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2Lives = p2Lives + 1;
                if (p2Lives > 5){
                    p2LifeScore.setTextColor(Color.BLACK);
                }
                p2LifeScore.setText(String.valueOf(p2Lives));
            }
        });
        p2PoisonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2Poison = p2Poison - 1;
                if (p2Poison <= 0)
                    p2Poison = 0;
                p2PoisonScore.setText(String.valueOf(p2Poison));
            }
        });

        p2PoisonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p2Poison = p2Poison + 1;
                if (p2Poison >= 10){
                    showWinner("Player 1");
                }
                p2PoisonScore.setText(String.valueOf(p2Poison));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScreen();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askExit();
            }
        });

    }

}
