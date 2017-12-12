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

import java.net.Inet4Address;

public class Main2Activity extends AppCompatActivity {

    private MediaPlayer mpp,them;
    private EditText edt1;
    private RadioGroup radg1;
    private Button btcon,btm3;

    private String strMoney,strUnit="USD",strAnser;
    private double douFactor=0.030,douAnswer;
    private MyAlertDialog objMyAlertDialog;


    private void calculateAnswer()
    {
        douAnswer=Double.parseDouble(strMoney)*douFactor;
        strAnser=Double.toString(douAnswer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mpp=MediaPlayer.create(this,R.raw.effectsbutton);
        edt1=(EditText)findViewById(R.id.editText);
        btcon=(Button)findViewById(R.id.button);
        radg1=(RadioGroup)findViewById(R.id.radioGroup);
        them=MediaPlayer.create(this,R.raw.thatsenoughinternetfortoday);
        btm3=(Button)findViewById(R.id.button4);

        them.start();
        them.setLooping(true);

        btm3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent B3=new Intent(Main2Activity.this,MainActivity.class);
                mpp.start();
                them.stop();
                startActivity(B3);
            }
        });

        radg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                switch (i)
                {
                    case R.id.radioButton1:
                        strUnit = "USD";
                        douFactor = 0.03;
                        break;
                    case R.id.radioButton2:
                        strUnit = "CNY";
                        douFactor = 0.2;
                        break;
                    case R.id.radioButton3:
                        strUnit = "KRW";
                        douFactor = 33;
                        break;
                }
            }
        });

        btcon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                mpp.start();
                try
                {
                    strMoney = edt1.getText().toString().trim();
                    if (strMoney.equals(""))
                    {
                        objMyAlertDialog = new MyAlertDialog();
                        objMyAlertDialog.HavespaceDialog(Main2Activity.this,mpp);
                    }
                    else
                    {
                        calculateAnswer();
                        Log.d("your","money" + strMoney);
                        Log.d("your","unit"+strUnit);
                        Log.d("your","answer" + strAnser);
                        objMyAlertDialog = new MyAlertDialog();
                        objMyAlertDialog.ShowAnswer(Main2Activity.this,strMoney,strAnser,strUnit,mpp);
                    }
                }
                catch (Exception e)
                {

                }
            }
        });



    }
}
