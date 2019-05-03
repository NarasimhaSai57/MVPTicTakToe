package com.example.mvptictaktoe;

import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class AppPresenter implements AppContract.ApplicationPresenter {
    private AppContract.ApplicationView view;

    public AppPresenter(AppContract.ApplicationView view) {
        this.view = view;
    }


    @Override
    public void CheckingForResult(int [][] boardStatus)
    {
        Log.i("%%%", "Inside checkWinner");

        //Horizontal --- rows
        for(int i=0; i<3; i++)
        {
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2])
            {
                if (boardStatus[i][0]==1){
                    view.displayResult("Player 0(person1) winner\n" + (i+1)+" row");
                    break;
                }
                else if (boardStatus[i][0]==2) {
                    view.displayResult("Player 1(person2) winner\n" + (i+1)+" row");
                    break;
                }
            }
        }

        //Vertical --- columns
        for(int i=0; i<3; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i]==1){
                    view.displayResult("Player 0(person1) winner\n" + (i+1)+" column");
                    break;
                }
                else if (boardStatus[0][i]==2) {
                    view.displayResult("Player 1(person2) winner\n" + (i+1)+" column");
                    break;
                }
            }
        }

        //First diagonal
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                view.displayResult("Player 0(person1) winner\nFirst Diagonal");
            }
            else if (boardStatus[0][0]==2) {
                view.displayResult("Player 1(person2) winner\nFirst Diagonal");
            }
        }

        //Second diagonal
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0])
        {
            if (boardStatus[0][2]==1){
                view.displayResult("Player 0(person1) winner\nSecond Diagonal");
            }
            else if (boardStatus[0][2]==2) {
                view.displayResult("Player 1(person2) winner\nSecond Diagonal");
            }
        }
    }

    @Override
    public void ActionButtonReset(int [][] boardstatus)
    {

        for(int i=0 ; i<3 ; i++)
        {

            for(int j=0 ; j<3 ; j++)
            {

                boardstatus[i][j] = 0;
            }
        }
        view.resetButtonClick();
    }

    @Override
    public void generateRandomNumber(int[][] boardStatus) {
        Random rand = new Random();
        int random = rand.nextInt(3);
        Log.i("***", "Random -->" + random);
        int random1 = rand.nextInt(3);
        Log.i("***", "Random -->" + random1);

        if (boardStatus[random][random1] == 0)
        {
            boardStatus[random][random1] = 2;
            int cRandom = Integer.parseInt(random + "" + random1);
            Log.i("***", "Random -->" + cRandom);
            view.displayRandomNumber(cRandom);
        }else{
            view.callRandomIntegerAgain();
        }


    }


}
