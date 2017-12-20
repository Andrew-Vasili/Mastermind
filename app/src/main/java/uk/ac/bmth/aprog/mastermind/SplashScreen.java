package uk.ac.bmth.aprog.mastermind;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by Drew on 21-Feb-16.
 */
public class SplashScreen extends Activity {

    /**
     * this entire class allows me easy access to my main meny throughout the project
     * some of the code is here just to make sure it runs smoothly without crashing
     * there is a layout determined incase the screen is loaded on slow devices
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_layout);
        load();
    }

    private void load() {

        try {
            wait(3000);
        } catch (Exception e) {
        }

        //1000 milliseconds is one second.


        startActivity(new Intent("Mastermind.Menu"));
    }

}

