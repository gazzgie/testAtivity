package com.example.test.testativity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btm1,btm2,btm3;
        final MediaPlayer bts;

        btm1=(Button)findViewById(R.id.button2);
        btm2=(Button)findViewById(R.id.button3);
        btm3=(Button)findViewById(R.id.button5);
        bts=MediaPlayer.create(this,R.raw.effectsbutton);

        btm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent B1=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(B1);
                bts.stop();

            }
        });

        btm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent B2=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(B2);
                bts.stop();

            }
        });

        btm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent B3=new Intent(MainActivity.this,Main4Activity.class);
                startActivity(B3);
                bts.stop();

            }
        });

    }
}
