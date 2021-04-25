package com.example.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int playerScore = 0;
    int cpuScore = 0;

    SubBoard subBoard1;
    SubBoard subBoard2;
    SubBoard subBoard3;
    SubBoard subBoard4;
    SubBoard subBoard5;
    SubBoard subBoard6;
    SubBoard subBoard7;
    SubBoard subBoard8;
    SubBoard subBoard9;

    int[][] boardStatus = {{0,0,0},{0,0,0},{0,0,0}};

    private  boolean firstRound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        subBoard1 = new SubBoard(findViewById(R.id.subbord1));
        subBoard2 = new SubBoard(findViewById(R.id.subbord2));
        subBoard3 = new SubBoard(findViewById(R.id.subbord3));

        subBoard4 = new SubBoard(findViewById(R.id.subbord4));
        subBoard5 = new SubBoard(findViewById(R.id.subbord5));
        subBoard6 = new SubBoard(findViewById(R.id.subbord6));

        subBoard7 = new SubBoard(findViewById(R.id.subbord7));
        subBoard8 = new SubBoard(findViewById(R.id.subbord8));
        subBoard9 = new SubBoard(findViewById(R.id.subbord9));

    }

    public void printDoneStatus(){
        Log.d("onclick", "Done status1: " + String.valueOf(subBoard1.doneStatus));
        Log.d("onclick", "Done status2: " + String.valueOf(subBoard2.doneStatus));
        Log.d("onclick", "Done status3: " + String.valueOf(subBoard3.doneStatus));
        Log.d("onclick", "Done status4: " + String.valueOf(subBoard4.doneStatus));
        Log.d("onclick", "Done status5: " + String.valueOf(subBoard5.doneStatus));
        Log.d("onclick", "Done status6: " + String.valueOf(subBoard6.doneStatus));
        Log.d("onclick", "Done status7: " + String.valueOf(subBoard7.doneStatus));
        Log.d("onclick", "Done status8: " + String.valueOf(subBoard8.doneStatus));
        Log.d("onclick", "Done status9: " + String.valueOf(subBoard9.doneStatus));

    }

    public void toggleBoard(SubBoard board){
        this.printDoneStatus();
        Log.d("onclick", "board: " + board.toString());
        if(firstRound == false || board.doneStatus == 1 ){
            this.togleAllBoards();
            this.firstRound = true ;
        }else{
            board.togleButtons();
        }

        //board.togleButtons();
    }

    public void togleAllBoards(){
        if(subBoard1.doneStatus != 1){
            subBoard1.togleButtons();
        }
        if(subBoard2.doneStatus != 1){
            subBoard2.togleButtons();
        }
        if(subBoard3.doneStatus != 1){
            subBoard3.togleButtons();
        }
        if(subBoard4.doneStatus != 1){
            subBoard4.togleButtons();
        }
        if(subBoard5.doneStatus != 1){
            subBoard5.togleButtons();
        }
        if(subBoard6.doneStatus != 1){
            subBoard6.togleButtons();
        }
        if(subBoard7.doneStatus != 1){
            subBoard7.togleButtons();
        }
        if(subBoard8.doneStatus != 1){
            subBoard8.togleButtons();
        }
        if(subBoard9.doneStatus != 1){
            subBoard9.togleButtons();
        }
    }

    private class SubBoard implements View.OnClickListener {

        GridLayout layout;
        ArrayList<View> layoutButtons;
        int[][] boardStatus = {{0,0,0},{0,0,0},{0,0,0}};

        public boolean locked = true;
        //public boolean boardDone = false;
        public int doneStatus = 0;  //0 not done and can still be enabled | 1 are won or draw and cant be unset

        public SubBoard(GridLayout layout) {
            this.layout = layout;
            this.layoutButtons = this.layout.getTouchables();
            this.setupListener();

        }

        private void setupListener(){
            for(View v : this.layoutButtons){
                if( v instanceof Button) {
                    ((Button)v).setOnClickListener( this);
                }
            }
        }

        public void togleButtons() {
            // loop through them, if they are an instance of Button, disable it.
            int index = 0;
            if(!(doneStatus == 1 && this.locked == false)) {
                this.locked = !locked;
            }
            for(View v : this.layoutButtons){
                if( v instanceof Button) {
                    ((Button)v).setEnabled(locked);
                    ((Button)v).setText(String.valueOf(index));
                    index++;
                }
            }
        }

        private void checkBoard() {
            //((Button)v).setBackgroundColor(Color.rgb(81, 219, 78)); // color picker.

            if(this.boardStatus[0][0] + this.boardStatus[1][0] + this.boardStatus[2][0] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }
            if(this.boardStatus[0][1] + this.boardStatus[1][1] + this.boardStatus[2][1] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }
            if(this.boardStatus[0][2] + this.boardStatus[1][2] + this.boardStatus[2][2] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }
            if(this.boardStatus[0][0] + this.boardStatus[0][1] + this.boardStatus[0][2] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }
            if(this.boardStatus[1][0] + this.boardStatus[1][1] + this.boardStatus[1][2] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }
            if(this.boardStatus[2][0] + this.boardStatus[2][1] + this.boardStatus[2][2] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }
            if(this.boardStatus[0][0] + this.boardStatus[1][1] + this.boardStatus[2][2] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }
            if(this.boardStatus[2][0] + this.boardStatus[1][1] + this.boardStatus[0][2] == 3){
                this.doneStatus = 1;
                this.togleButtons();
            }

            //check to see if the whole game is done.
        }


        private void playRound(String board, String field){

            //Update the board.
            switch (field){
                case "00":
                    this.boardStatus[0][0] = 1;
                    break;
                case "10":
                    this.boardStatus[1][0] = 1;
                    break;
                case "20":
                    this.boardStatus[2][0] = 1;
                    break;
                case "01":
                    this.boardStatus[0][1] = 1;
                    break;
                case "11":
                    this.boardStatus[1][1] = 1;
                    break;
                case "21":
                    this.boardStatus[2][1] = 1;
                    break;
                case "02":
                    this.boardStatus[0][2] = 1;
                    break;
                case "12":
                    this.boardStatus[1][2] = 1;
                    break;
                case "22":
                    this.boardStatus[2][2] = 1;
                    break;
            }

            //Check board to see if there the board is done
            this.checkBoard();

            //Disable board just played
            switch (board){
                case "subbord1":
                    toggleBoard(subBoard1);
                    break;
                case "subbord4":
                    toggleBoard(subBoard4);
                    break;
                case "subbord7":
                    toggleBoard(subBoard7);
                    break;
                case "subbord2":
                    toggleBoard(subBoard2);
                    break;
                case "subbord5":
                    toggleBoard(subBoard5);
                    break;
                case "subbord8":
                    toggleBoard(subBoard8);
                    break;
                case "subbord3":
                    toggleBoard(subBoard3);
                    break;
                case "subbord6":
                    toggleBoard(subBoard6);
                    break;
                case "subbord9":
                    toggleBoard(subBoard9);
                    break;
            }

            //unlock the next board.
            switch (field){
                case "00":
                    toggleBoard(subBoard1);
                    break;
                case "10":
                    toggleBoard(subBoard4);
                    break;
                case "20":
                    toggleBoard(subBoard7);
                    break;
                case "01":
                    toggleBoard(subBoard2);
                    break;
                case "11":
                    toggleBoard(subBoard5);
                    break;
                case "21":
                    toggleBoard(subBoard8);
                    break;
                case "02":
                    toggleBoard(subBoard3);
                    break;
                case "12":
                    toggleBoard(subBoard6);
                    break;
                case "22":
                    toggleBoard(subBoard9);
                    break;
            }
        }

        @Override
        public void onClick(View v) {
            Log.d("onclick", v.toString());
            if( v instanceof Button) {
                v.setBackgroundColor(Color.rgb(47, 185,216));
            }
            String important =  v.toString().split("/")[1];
            String board = important.split("_")[0];
            String field = important.split("_")[1].substring(0,2);
            Log.d("onclick", "Board: " + board + " Field: " + field);

            this.playRound(board,field);
        }
    }
}






