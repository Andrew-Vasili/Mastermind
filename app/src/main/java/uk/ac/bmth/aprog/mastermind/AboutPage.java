package uk.ac.bmth.aprog.mastermind;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutPage extends Activity implements View.OnClickListener {

    Button buttonMenu;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_layout);
        buttonMenu = (Button) findViewById(R.id.btnMenu);
        buttonMenu.setOnClickListener(this);

    }

    //Return to main menu
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMenu:
                btnMenu();
                break;

        }

    }

    public Void btnMenu() {
        startActivity(new Intent("Mastermind.Menu"));
        return null;
    }

}
