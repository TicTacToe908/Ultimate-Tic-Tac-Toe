package com.example.ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    
    static String playerScore = "0";
    static String cpuScore = "0";
    ArrayList<SubBoard> subBoards; 
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
    int[][] cpuBoardStatus = {{0,0,0},{0,0,0},{0,0,0}};
    int[][] playerBoardStatus = {{0,0,0},{0,0,0},{0,0,0}};
    //                    Board       Status          btn
    // This is how    ///\\//\\//\\\///\\//\\//\\\///\\//\\/\
    // the status     // 00 01 02 \\// 00 01 02 \\// 0 3 6 \\
    // map to the     // 10 11 12 \\// 10 11 12 \\// 1 4 7 \\
    // board          // 20 21 22 \\// 20 21 22 \\// 2 5 8 \\
    //                ///\\//\\//\\\///\\//\\//\\\///\\//\\/\
    //     LAYOUT NOTES    //
    //2339073 8c9e849 b0b9768
    //8861003 d8434e2 d18d844
    //5ba84f  5644986 8374499

    private final boolean firstRound = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        resetBoards();
    }

    public void resetBoards(){
        subBoards = new ArrayList<>();
        subBoard1 = new SubBoard(findViewById(R.id.subbord1));
        subBoards.add(subBoard1);
        subBoard2 = new SubBoard(findViewById(R.id.subbord2));
        subBoards.add(subBoard2);
        subBoard3 = new SubBoard(findViewById(R.id.subbord3));
        subBoards.add(subBoard3);

        subBoard4 = new SubBoard(findViewById(R.id.subbord4));
        subBoards.add(subBoard4);
        subBoard5 = new SubBoard(findViewById(R.id.subbord5));
        subBoards.add(subBoard5);
        subBoard6 = new SubBoard(findViewById(R.id.subbord6));
        subBoards.add(subBoard6);

        subBoard7 = new SubBoard(findViewById(R.id.subbord7));
        subBoards.add(subBoard7);
        subBoard8 = new SubBoard(findViewById(R.id.subbord8));
        subBoards.add(subBoard8);
        subBoard9 = new SubBoard(findViewById(R.id.subbord9));
        subBoards.add(subBoard9);
    }

    public void updateMainBoard(String board, boolean player){
        int boardNumber = Integer.parseInt(board.substring(board.length()-1));

        if(boardNumber <= 3){
            this.boardStatus[0][boardNumber-1] = 1;
            if(player){
                this.cpuBoardStatus[0][boardNumber-1] = 1;
            }else{
                this.playerBoardStatus[0][boardNumber-1] = 1;
            }
        }else if(boardNumber <= 6){
            this.boardStatus[1][boardNumber-4] = 1;
            if(player){
                this.cpuBoardStatus[1][boardNumber-4] = 1;
            }else{
                this.playerBoardStatus[1][boardNumber-4] = 1;
            }
        }else if(boardNumber <= 9){
            this.boardStatus[2][boardNumber-7] = 1;
            if(player){
                this.cpuBoardStatus[2][boardNumber-7] = 1;
            }else{
                this.playerBoardStatus[2][boardNumber-7] = 1;
            }
        }

        checkBoard(player);
    }

    private void checkBoard(boolean player){
        if(player){
            if(this.cpuBoardStatus[0][0] + this.cpuBoardStatus[1][0] + this.cpuBoardStatus[2][0] == 3){
                this.gameDone("CPU");
            }
            if(this.cpuBoardStatus[0][1] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[2][1] == 3){
                this.gameDone("CPU");
            }
            if(this.cpuBoardStatus[0][2] + this.cpuBoardStatus[1][2] + this.cpuBoardStatus[2][2] == 3){
                this.gameDone("CPU");
            }
            if(this.cpuBoardStatus[0][0] + this.cpuBoardStatus[0][1] + this.cpuBoardStatus[0][2] == 3){
                this.gameDone("CPU");
            }
            if(this.cpuBoardStatus[1][0] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[1][2] == 3){
                this.gameDone("CPU");
            }
            if(this.cpuBoardStatus[2][0] + this.cpuBoardStatus[2][1] + this.cpuBoardStatus[2][2] == 3){
                this.gameDone("CPU");
            }
            if(this.cpuBoardStatus[0][0] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[2][2] == 3){
                this.gameDone("CPU");
            }
            if(this.cpuBoardStatus[2][0] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[0][2] == 3){
                this.gameDone("CPU");
            }
        }else{
            if(this.playerBoardStatus[0][0] + this.playerBoardStatus[1][0] + this.playerBoardStatus[2][0] == 3){
                this.gameDone("PLAYER");
            }
            if(this.playerBoardStatus[0][1] + this.playerBoardStatus[1][1] + this.playerBoardStatus[2][1] == 3){
                this.gameDone("PLAYER");
            }
            if(this.playerBoardStatus[0][2] + this.playerBoardStatus[1][2] + this.playerBoardStatus[2][2] == 3){
                this.gameDone("PLAYER");
            }
            if(this.playerBoardStatus[0][0] + this.playerBoardStatus[0][1] + this.playerBoardStatus[0][2] == 3){
                this.gameDone("PLAYER");
            }
            if(this.playerBoardStatus[1][0] + this.playerBoardStatus[1][1] + this.playerBoardStatus[1][2] == 3){
                this.gameDone("PLAYER");
            }
            if(this.playerBoardStatus[2][0] + this.playerBoardStatus[2][1] + this.playerBoardStatus[2][2] == 3){
                this.gameDone("PLAYER");
            }
            if(this.playerBoardStatus[0][0] + this.playerBoardStatus[1][1] + this.playerBoardStatus[2][2] == 3){
                this.gameDone("PLAYER");
            }
            if(this.playerBoardStatus[2][0] + this.playerBoardStatus[1][1] + this.playerBoardStatus[0][2] == 3){
                this.gameDone("PLAYER");
            }
        }
        int numberLocked = 0;
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(boardStatus[i][j] == 1){
                    numberLocked++;
                }
            }
        }
        if(numberLocked == 9){
            this.gameDone("DRAW");
        }
    }

    private void gameDone(String who){
        Log.d("DONE", "GAME OVER: " + who);
        switch (who) {
            case "CPU":
                int localPlayerScore = Integer.parseInt(playerScore);
                localPlayerScore++;
                playerScore = String.valueOf(localPlayerScore);
                TextView playerScoreText = findViewById(R.id.playerText);
                playerScoreText.setText(String.format("Player: %s wins", playerScore));
                break;
            case "PLAYER":
                int localCPUScore = Integer.parseInt(cpuScore);
                localCPUScore++;
                cpuScore = String.valueOf(localCPUScore);
                TextView cpuScoreText = findViewById(R.id.cpuText);
                cpuScoreText.setText(String.format("Player: %s wins", cpuScore));
                break;
            case "DRAW":

                break;
        }
        resetBoards();
    }


    public void toggleBoard(SubBoard board, int onOff){
        //Log.d("onclick", "board: " + board.toString());
        if(board.doneStatus == 1 ){
            this.toggleAllBoards(onOff);
        }else{
            board.toggleButtons(onOff);
        }
    }

    public void toggleAllBoards(int onOff){
        for (int i = 0; i < subBoards.size(); i++) {
            if(subBoards.get(i).doneStatus != 1){
                subBoards.get(i).toggleButtons(onOff);
            }
        }
    }

    public void cpuROUND(){
        //getting boards available to play in
        ArrayList<SubBoard> available = new ArrayList<>();
        ArrayList<String> availableName = new ArrayList<>();
        for (int i = 0; i < subBoards.size(); i++) {
            if(subBoards.get(i).doneStatus == 0 && subBoards.get(i).locked) {
                available.add(subBoards.get(i));
                availableName.add(String.valueOf(i + 1));
            }
        }

        //Selecting a random board
        int index = new Random().nextInt(available.size());
        Log.d("CPU", "index: " + index);
        Log.d("CPU", "size: " + available.size());
        SubBoard board = available.get(index);

        //Getting all the btn available in the list as string.
        ArrayList<String> btns = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board.boardStatus[i][j] == 0){
                    btns.add(String.valueOf(i) + j);
                }
            }
        }
        String field = btns.get(new Random().nextInt(btns.size()));

        //Get btn to change text and color

        String boardString = "subbord" + availableName.get(index);
        String btnString = boardString + "_" + field;
        int btnID = getResources().getIdentifier(btnString, "id", MainActivity.this.getPackageName());


        Button btn = findViewById(btnID);
        btn.setBackgroundColor(Color.rgb(239, 35,93));
        btn.setEnabled(false);
        board.playRound(false, field, boardString);
    }



    private class SubBoard implements View.OnClickListener {


        GridLayout layout;
        ArrayList<View> layoutButtons;

        int[][] boardStatus = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] cpuBoardStatus = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] playerBoardStatus = {{0,0,0},{0,0,0},{0,0,0}};

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
                    v.setOnClickListener( this);
                }
            }
        }

        public void toggleButtons(int onOff) {
            // loop through them, if they are an instance of Button, disable it.
            int index = 0;
            //if(!(doneStatus == 1 && this.locked == false)) {
            //    this.locked = !locked;
            //}

            if (onOff == 0){
                this.locked = false; //locked board
            }else if (onOff == 1){
                this.locked = true; //unlocked board
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(this.boardStatus[j][i] != 1 ){
                        this.layoutButtons.get(index).setEnabled(locked);
                    }
                    index++;
                }
            }
        }


        private void checkBoard(String board, boolean player) {
            //((Button)v).setBackgroundColor(Color.rgb(81, 219, 78)); // color picker.

            Log.d("checkBoard", "This is a check of board" + board + " by player " + player);
            if(player){
                if(this.cpuBoardStatus[0][0] + this.cpuBoardStatus[1][0] + this.cpuBoardStatus[2][0] == 3){
                    this.doneStatus = 1;
                }
                if(this.cpuBoardStatus[0][1] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[2][1] == 3){
                    this.doneStatus = 1;
                }
                if(this.cpuBoardStatus[0][2] + this.cpuBoardStatus[1][2] + this.cpuBoardStatus[2][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.cpuBoardStatus[0][0] + this.cpuBoardStatus[0][1] + this.cpuBoardStatus[0][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.cpuBoardStatus[1][0] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[1][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.cpuBoardStatus[2][0] + this.cpuBoardStatus[2][1] + this.cpuBoardStatus[2][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.cpuBoardStatus[0][0] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[2][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.cpuBoardStatus[2][0] + this.cpuBoardStatus[1][1] + this.cpuBoardStatus[0][2] == 3){
                    this.doneStatus = 1;
                }
            }else{
                if(this.playerBoardStatus[0][0] + this.playerBoardStatus[1][0] + this.playerBoardStatus[2][0] == 3){
                    this.doneStatus = 1;
                }
                if(this.playerBoardStatus[0][1] + this.playerBoardStatus[1][1] + this.playerBoardStatus[2][1] == 3){
                    this.doneStatus = 1;
                }
                if(this.playerBoardStatus[0][2] + this.playerBoardStatus[1][2] + this.playerBoardStatus[2][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.playerBoardStatus[0][0] + this.playerBoardStatus[0][1] + this.playerBoardStatus[0][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.playerBoardStatus[1][0] + this.playerBoardStatus[1][1] + this.playerBoardStatus[1][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.playerBoardStatus[2][0] + this.playerBoardStatus[2][1] + this.playerBoardStatus[2][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.playerBoardStatus[0][0] + this.playerBoardStatus[1][1] + this.playerBoardStatus[2][2] == 3){
                    this.doneStatus = 1;
                }
                if(this.playerBoardStatus[2][0] + this.playerBoardStatus[1][1] + this.playerBoardStatus[0][2] == 3){
                    this.doneStatus = 1;
                }
            }
            int numberLocked = 0;
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < 3; j++) {
                    if(boardStatus[i][j] == 1){
                        numberLocked++;
                    }
                }
            }
            if(numberLocked == 9){
                this.doneStatus = 1;
            }
            Log.d("checkBoard", "" + this.doneStatus);
            if(this.doneStatus == 1){
                updateMainBoard(board, player);
            }
            //check to see if the whole game is done.

        }


         public void playRound(boolean player, String field, String board){

            //Disable all boards
            toggleAllBoards(0);

            //Update the board.
            int index1 = Integer.parseInt(field.substring(0, 1));
            int index2 = Integer.parseInt(field.substring(1, 2));
            this.boardStatus[index1][index2] = 1;
            if(player){
                this.playerBoardStatus[index1][index2] = 1;
            }else{
                this.cpuBoardStatus[index1][index2] = 1;
            }

            //Check board to see if there the board is done
            this.checkBoard(board,player);

            //unlock the next board.
            switch (field){
                case "00":
                    toggleBoard(subBoard1,1);
                    break;
                case "10":
                    toggleBoard(subBoard4,1);
                    break;
                case "20":
                    toggleBoard(subBoard7,1);
                    break;
                case "01":
                    toggleBoard(subBoard2,1);
                    break;
                case "11":
                    toggleBoard(subBoard5,1);
                    break;
                case "21":
                    toggleBoard(subBoard8,1);
                    break;
                case "02":
                    toggleBoard(subBoard3,1);
                    break;
                case "12":
                    toggleBoard(subBoard6,1);
                    break;
                case "22":
                    toggleBoard(subBoard9,1);
                    break;
            }
             if(player){
                cpuROUND();
            }

        }

        @Override
        public void onClick(View v) {
            Log.d("onclick", v.toString());
            if( v instanceof Button) {
                v.setBackgroundColor(Color.rgb(47, 185,216));
                v.setEnabled(false);
            }
            String important =  v.toString().split("/")[1];
            String board = important.split("_")[0];
            String field = important.split("_")[1].substring(0,2);
            Log.d("onclick", "Board: " + board + " Field: " + field);

            this.playRound(true,field , board);
        }


    }
}






