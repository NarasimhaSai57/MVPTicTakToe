package com.example.mvptictaktoe;

import android.widget.Button;

import java.util.ArrayList;

public interface AppContract
{
    interface ApplicationView
    {
        void resetButtonClick();
        void callRandomIntegerAgain();
        void displayRandomNumber(Integer randomNumber);
        void displayResult(String string);
    }

    interface ApplicationPresenter
    {
        void CheckingForResult(int [][] boardstatus);
        void ActionButtonReset(int [][] boardstatus);
        void generateRandomNumber(int [][] boardstatus);
    }
}
