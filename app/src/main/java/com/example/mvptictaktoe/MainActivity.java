package com.example.mvptictaktoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  AppContract.ApplicationView{

    AppContract.ApplicationPresenter presenter;
    Button b00,b01,b02,b10,b11,b12,b20,b21,b22,btn_reset;
    Boolean player1 = true;
    Boolean player2 = false;

    ArrayList<Integer> arrayList = new ArrayList<>();

    int[][] boardStatus = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = (AppContract.ApplicationPresenter) new AppPresenter(this);

        btn_reset = findViewById(R.id.btn_reset);
        b00 = findViewById(R.id.b00);
        b01 = findViewById(R.id.b01);
        b02 = findViewById(R.id.b02);
        b10 = findViewById(R.id.b10);
        b11 = findViewById(R.id.b11);
        b12 = findViewById(R.id.b12);
        b20 = findViewById(R.id.b20);
        b21 = findViewById(R.id.b21);
        b22 = findViewById(R.id.b22);


        presenter.ActionButtonReset(boardStatus);

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                arrayList = new ArrayList<>();
               presenter.ActionButtonReset(boardStatus);
            }
        });

        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                b00.setText("1");
                boardStatus[0][0] = 1;
                arrayList.add(1);

                if(arrayList.size()>8){
                    Log.i("&&&","checking for result");
                }else{
                    presenter.generateRandomNumber(boardStatus);
                }

            }
        });

        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                b01.setText("1");
                boardStatus[0][1] = 1;
                arrayList.add(1);
                if(arrayList.size()>8){
                    Log.i("&&&","checking for result");
                }else{
                    presenter.generateRandomNumber(boardStatus);
                }

            }
        });


        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1==true && player2==false)
                {

                    b02.setText("1");
                    boardStatus[0][2] = 1;
                    arrayList.add(1);
                    if(arrayList.size()>8){
                        Log.i("&&&","checking for result");
                    }else{
                        presenter.generateRandomNumber(boardStatus);
                    }
                }
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1==true && player2==false)
                {

                    b10.setText("1");
                    boardStatus[1][0] = 1;
                    arrayList.add(1);
                    if(arrayList.size()>8){
                        Log.i("&&&","checking for result");
                    }else{
                        presenter.generateRandomNumber(boardStatus);
                    }
                }
            }
        });

        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1==true && player2==false)
                {

                    b11.setText("1");
                    boardStatus[1][1] = 1;
                    arrayList.add(1);
                    if(arrayList.size()>8){
                        Log.i("&&&","checking for result");
                        presenter.CheckingForResult(boardStatus);
                    }else{
                        presenter.generateRandomNumber(boardStatus);
                    }
                }
            }
        });

        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1==true && player2==false)
                {

                    b12.setText("1");
                    boardStatus[1][2] = 1;
                    arrayList.add(1);
                    if(arrayList.size()>8){
                        presenter.CheckingForResult(boardStatus);
                        Log.i("&&&","checking for result");
                    }else{
                        presenter.generateRandomNumber(boardStatus);
                    }
                }
            }
        });

        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1==true && player2==false)
                {

                    b20.setText("1");
                    boardStatus[2][0] = 1;
                    arrayList.add(1);
                    if(arrayList.size()>8){
                        presenter.CheckingForResult(boardStatus);
                        Log.i("&&&","checking for result");
                    }else{
                        presenter.generateRandomNumber(boardStatus);
                    }
                }
            }
        });

        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1==true && player2==false)
                {

                    b21.setText("1");
                    boardStatus[2][1] = 1;
                    arrayList.add(1);
                    if(arrayList.size()>8){
                        presenter.CheckingForResult(boardStatus);
                        Log.i("&&&","checking for result");
                    }else{
                        presenter.generateRandomNumber(boardStatus);
                    }
                }
            }
        });

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(player1==true && player2==false)
                {

                    b22.setText("1");
                    boardStatus[2][2] = 1;
                    arrayList.add(1);
                    if(arrayList.size()>8){
                        presenter.CheckingForResult(boardStatus);
                        Log.i("&&&","checking for result");
                    }else{
                        presenter.generateRandomNumber(boardStatus);
                    }
                }
            }
        });



    }



    @Override
    public void resetButtonClick()
    {

        b00.setEnabled(true);
        b01.setEnabled(true);
        b02.setEnabled(true);
        b10.setEnabled(true);
        b11.setEnabled(true);
        b12.setEnabled(true);
        b20.setEnabled(true);
        b21.setEnabled(true);
        b22.setEnabled(true);

        b00.setText("");
        b01.setText("");
        b02.setText("");

        b10.setText("");
        b11.setText("");
        b12.setText("");

        b20.setText("");
        b21.setText("");
        b22.setText("");


        player1 = true;
        player2 = false;

        Toast.makeText(this,"Board Reset",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void callRandomIntegerAgain()
    {
        presenter.generateRandomNumber(boardStatus);
    }


    @Override
    public void displayRandomNumber(Integer cRandom)
    {
        if (cRandom == 00)
        {
            b00.setText("2");
            arrayList.add(1);
        } else if (cRandom == 01) {
            b01.setText("2");
            arrayList.add(1);
        } else if (cRandom == 02) {
            b02.setText("2");
            arrayList.add(1);
        } else if (cRandom == 10) {
            b10.setText("2");
            arrayList.add(1);
        } else if (cRandom == 11) {
            b11.setText("2");
            arrayList.add(1);
        } else if (cRandom == 12) {
            b12.setText("2");
            arrayList.add(1);
        } else if (cRandom == 20) {
            b20.setText("2");
            arrayList.add(1);
        } else if (cRandom == 21) {
            b21.setText("2");
            arrayList.add(1);
        } else if (cRandom == 22) {
            b22.setText("2");
            arrayList.add(1);
        }

        presenter.CheckingForResult(boardStatus);
    }

    @Override
    public void displayResult(String winner)
    {
        b00.setEnabled(false);
        b01.setEnabled(false);
        b02.setEnabled(false);
        b10.setEnabled(false);
        b11.setEnabled(false);
        b12.setEnabled(false);
        b20.setEnabled(false);
        b21.setEnabled(false);
        b22.setEnabled(false);

        Log.i("%%%", "Inside result");
        Log.i("%%%","winner -->"+winner);
        Toast.makeText(getApplicationContext(),""+winner +" is winner",Toast.LENGTH_SHORT).show();
    }
}
