package uk.ac.bmth.aprog.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class mainGame extends Activity {

    int[] aiChoice = new int[4]; //Array for colour values colour values below
    int[] userChoice = new int[4]; //Array for users chosen colors
    int score = 0;
    int turns = 1;

    /**
     * Values // Colours
     * 0 / Blue
     * 1 / Red
     * 2 / Green
     * 3 / Yellow
     * 4 / Purple
     * 5 / White
     */

    Button button1, button2, button3, button4, buttonCompare;
    TextView textPeg, textPlace, textTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_layout);
        aiRandom();
        //    reset();
        score = 40;

        button1 = (Button) findViewById(R.id.choice1);
        button1.setOnClickListener(imgButtonHandler);
        button1.setBackgroundColor(Color.CYAN);
        button1.setText("blue");
        button1.setTextColor(Color.CYAN);

        button2 = (Button) findViewById(R.id.choice2);
        button2.setOnClickListener(imgButtonHandler);
        button2.setBackgroundColor(Color.CYAN);
        button2.setText("blue");
        button2.setTextColor(Color.CYAN);

        button3 = (Button) findViewById(R.id.choice3);
        button3.setOnClickListener(imgButtonHandler);
        button3.setBackgroundColor(Color.CYAN);
        button3.setText("blue");
        button3.setTextColor(Color.CYAN);

        button4 = (Button) findViewById(R.id.choice4);
        button4.setOnClickListener(imgButtonHandler);
        button4.setBackgroundColor(Color.CYAN);
        button4.setText("blue");
        button4.setTextColor(Color.CYAN);

        buttonCompare = (Button) findViewById(R.id.btnCompare);
        buttonCompare.setOnClickListener(imgButtonHandler);

        textPlace = (TextView) findViewById(R.id.txtPlace);
        textPeg = (TextView) findViewById(R.id.txtCorrect);
        textTotal = (TextView) findViewById(R.id.txtTotal);


    }

    /**
     * AI CHOICE CREATOR
     * Allows me to randomly create colours using ints
     */
    public void aiRandom() {

        int x = 0;
        while (x < 3) {
            Random rand = new Random();
            aiChoice[x] = rand.nextInt(5); //Random value of up 1 - 4 change if I need to up colour count
            x = x + 1;

        }


    }

    /**
     * Values // Colours
     * 0 / Blue
     * 1 / Red
     * 2 / Green
     * 3 / Yellow
     * 4 / Purple
     * 5 / White
     */

    //the main body of code for comparing the arrays
    public void compare() {

        int x = 0;
        int y = 0;
        textPeg.setText("null");
        textPlace.setText("null");
        int valuePosition = 0;
        int valuePegs = 0;
        String stringer;
        String stringer2;

        while (x < 4) {

            while (y < 4) {
                if (aiChoice[x] == userChoice[y]) {
                    if (x == y) {
                        valuePosition = valuePosition + 1;
                        valuePegs = valuePegs + 1;
                        stringer = Integer.toString(valuePosition);
                        stringer2 = Integer.toString(valuePegs);
                        textPeg.setText(stringer);
                        textPlace.setText(stringer2);


                    } else {
                        valuePegs = valuePegs + 1;
                        stringer2 = Integer.toString(valuePegs);
                        textPlace.setText(stringer2);


                    }

                } else {


                }
                y = y + 1;

            }

            x = x + 1;
            y = 0;
        }

        if (valuePosition == 4) {
            win();

        }

        if (turns == 13) {
            lose();
        }

        textTotal.setText(Integer.toString(turns));
    }

    //run if game is won
    public void win() {
        Intent intent = new Intent("Mastermind.Win");

        //load the intent with a key "content" and assign it's value to content
        intent.putExtra("turns", turns);

        //launch the BarcodeScanner activity and send the intent along with it
        //note that content  is passed in as well
        startActivity(intent);

    }

    //run if game is lost
    public void lose() {
        startActivity(new Intent("Mastermind.Lose"));

    }


    //saves the users choice into an array by converting the word into a number
    public void saveChoice() {


        if (button1.getText() == "blue") {
            userChoice[0] = 0;

        } else if (button1.getText() == "red") {
            userChoice[0] = 1;

        } else if (button1.getText() == "green") {
            userChoice[0] = 2;

        } else if (button1.getText() == "yellow") {
            userChoice[0] = 3;

        } else if (button1.getText() == "purple") {
            userChoice[0] = 4;

        } else if (button1.getText() == "white") {
            userChoice[0] = 5;
        }


        if (button2.getText() == "blue") {
            userChoice[1] = 0;

        } else if (button2.getText() == "red") {
            userChoice[1] = 1;

        } else if (button2.getText() == "green") {
            userChoice[1] = 2;

        } else if (button2.getText() == "yellow") {
            userChoice[1] = 3;

        } else if (button2.getText() == "purple") {
            userChoice[1] = 4;

        } else if (button2.getText() == "white") {
            userChoice[1] = 5;
        }

        if (button3.getText() == "blue") {
            userChoice[2] = 0;

        } else if (button3.getText() == "red") {
            userChoice[2] = 1;

        } else if (button3.getText() == "green") {
            userChoice[2] = 2;

        } else if (button3.getText() == "yellow") {
            userChoice[2] = 3;

        } else if (button3.getText() == "purple") {
            userChoice[2] = 4;

        } else if (button3.getText() == "white") {
            userChoice[2] = 5;
        }

        if (button4.getText() == "blue") {
            userChoice[3] = 0;

        } else if (button4.getText() == "red") {
            userChoice[3] = 1;

        } else if (button4.getText() == "green") {
            userChoice[3] = 2;

        } else if (button4.getText() == "yellow") {
            userChoice[3] = 3;

        } else if (button4.getText() == "purple") {
            userChoice[3] = 4;

        } else if (button4.getText() == "white") {
            userChoice[3] = 5;
        }

    }

    //Controls the colours of the buttons (user choice)
    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.choice1:

                    if (button1.getText() == "blue") {
                        button1.setBackgroundColor(Color.RED);
                        button1.setText("red");
                        button1.setTextColor(Color.RED);
                    } else if (button1.getText() == "red") {
                        button1.setBackgroundColor(Color.GREEN);
                        button1.setText("green");
                        button1.setTextColor(Color.GREEN);
                    } else if (button1.getText() == "green") {
                        button1.setBackgroundColor(Color.YELLOW);
                        button1.setText("yellow");
                        button1.setTextColor(Color.YELLOW);
                    } else if (button1.getText() == "yellow") {
                        button1.setBackgroundColor(Color.MAGENTA);
                        button1.setText("purple");
                        button1.setTextColor(Color.MAGENTA);
                    } else if (button1.getText() == "purple") {
                        button1.setBackgroundColor(Color.WHITE);
                        button1.setText("white");
                        button1.setTextColor(Color.WHITE);
                    } else if (button1.getText() == "white") {
                        button1.setBackgroundColor(Color.CYAN);
                        button1.setText("blue");
                        button1.setTextColor(Color.CYAN);
                    }
                    break;

                case R.id.choice2:

                    if (button2.getText() == "blue") {
                        button2.setBackgroundColor(Color.RED);
                        button2.setText("red");
                        button2.setTextColor(Color.RED);
                    } else if (button2.getText() == "red") {
                        button2.setBackgroundColor(Color.GREEN);
                        button2.setText("green");
                        button2.setTextColor(Color.GREEN);
                    } else if (button2.getText() == "green") {
                        button2.setBackgroundColor(Color.YELLOW);
                        button2.setText("yellow");
                        button2.setTextColor(Color.YELLOW);
                    } else if (button2.getText() == "yellow") {
                        button2.setBackgroundColor(Color.MAGENTA);
                        button2.setText("purple");
                        button2.setTextColor(Color.MAGENTA);
                    } else if (button2.getText() == "purple") {
                        button2.setBackgroundColor(Color.WHITE);
                        button2.setText("white");
                        button2.setTextColor(Color.WHITE);
                    } else if (button2.getText() == "white") {
                        button2.setBackgroundColor(Color.CYAN);
                        button2.setText("blue");
                        button2.setTextColor(Color.CYAN);
                    }
                    break;


                case R.id.choice3:

                    if (button3.getText() == "blue") {
                        button3.setBackgroundColor(Color.RED);
                        button3.setText("red");
                        button3.setTextColor(Color.RED);
                    } else if (button3.getText() == "red") {
                        button3.setBackgroundColor(Color.GREEN);
                        button3.setText("green");
                        button3.setTextColor(Color.GREEN);
                    } else if (button3.getText() == "green") {
                        button3.setBackgroundColor(Color.YELLOW);
                        button3.setText("yellow");
                        button3.setTextColor(Color.YELLOW);
                    } else if (button3.getText() == "yellow") {
                        button3.setBackgroundColor(Color.MAGENTA);
                        button3.setText("purple");
                        button3.setTextColor(Color.MAGENTA);
                    } else if (button3.getText() == "purple") {
                        button3.setBackgroundColor(Color.WHITE);
                        button3.setText("white");
                        button3.setTextColor(Color.WHITE);
                    } else if (button3.getText() == "white") {
                        button3.setBackgroundColor(Color.CYAN);
                        button3.setText("blue");
                        button3.setTextColor(Color.CYAN);
                    }
                    break;

                case R.id.choice4:

                    if (button4.getText() == "blue") {
                        button4.setBackgroundColor(Color.RED);
                        button4.setText("red");
                        button4.setTextColor(Color.RED);
                    } else if (button4.getText() == "red") {
                        button4.setBackgroundColor(Color.GREEN);
                        button4.setText("green");
                        button4.setTextColor(Color.GREEN);
                    } else if (button4.getText() == "green") {
                        button4.setBackgroundColor(Color.YELLOW);
                        button4.setText("yellow");
                        button4.setTextColor(Color.YELLOW);
                    } else if (button4.getText() == "yellow") {
                        button4.setBackgroundColor(Color.MAGENTA);
                        button4.setText("purple");
                        button4.setTextColor(Color.MAGENTA);
                    } else if (button4.getText() == "purple") {
                        button4.setBackgroundColor(Color.WHITE);
                        button4.setText("white");
                        button4.setTextColor(Color.WHITE);
                    } else if (button4.getText() == "white") {
                        button4.setBackgroundColor(Color.CYAN);
                        button4.setText("blue");
                        button4.setTextColor(Color.CYAN);
                    }
                    break;

                //runs comparison of user choice and random pegs
                case R.id.btnCompare:
                    turns = turns + 1;
                    saveChoice();
                    compare();
                    break;


            }
        }
    };
}