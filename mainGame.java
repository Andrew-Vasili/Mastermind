package uk.ac.bmth.aprog.mastermind;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;


public class mainGame extends Activity {

    int[] aiChoice = new int[4]; //Array for colour values colour values below
    int[] userChoice = new int[4]; //Array for users chosen colors
    int score = 0;

    /**
     * Values // Colours
     *  0 / Red
     *  1 / Blue
     *  2 / Green
     *  3 / Yellow
     *  4 / Purple
     */


    /**
     * AI CHOICE CREATOR
     * Allows me to randomly create colours using ints
     */
    public void aiRandom() {
        TextView []txtArray=new TextView[5];
        int x = 0;
        while (x > 5) {
            Random rand = new Random();
            aiChoice[x] = rand.nextInt(4) + 1; //Random value of up 1 - 4 change if I need to up colour count
            x = x + 1;
            txtArray[x].setText("x");
        }



    }

    public void compare() {

        int x = 0;
        int y = 0;
        while(x<5){

            while (y<5){
                if (aiChoice[x] == userChoice[y]){

                }
                else{


                }

            }

            x = x+1;
            y=0;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_layout);
        aiRandom();
        score = 40;
    }


}
