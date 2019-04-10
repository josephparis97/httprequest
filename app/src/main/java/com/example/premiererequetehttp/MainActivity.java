package com.example.premiererequetehttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*
1.OUR LAUNCHER ACTIVITY
2.INITIALIZE SOME UI STUFF
3.WE START SENDER ON BUTTON CLICK
 */
public class MainActivity extends AppCompatActivity {

    String urlAddress="https://wad97.000webhostapp.com/cv/request.php";
    EditText nomTxt,prenomTxt,ageTxt;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //INITIALIZE UI FIELDS
        nomTxt= (EditText) findViewById(R.id.nom);
        prenomTxt= (EditText) findViewById(R.id.prenom);
        ageTxt= (EditText) findViewById(R.id.age);
        saveBtn= (Button) findViewById(R.id.envoyer);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //START ASYNC TASK
                Sender s=new Sender(MainActivity.this,urlAddress,nomTxt,prenomTxt,ageTxt);
                s.execute();
            }
        });

    }

}