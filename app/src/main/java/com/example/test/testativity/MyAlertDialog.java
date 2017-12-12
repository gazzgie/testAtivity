package com.example.test.testativity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;

/**
 * Created by Gazzgie on 5/12/2560.
 */

public class MyAlertDialog {

    AlertDialog.Builder objAlertDialog;


    public void HavespaceDialog(Context context, final MediaPlayer mpp){
        objAlertDialog = new AlertDialog.Builder(context);
        objAlertDialog.setIcon(R.drawable.danger);
        objAlertDialog.setTitle("!!! Error !!!");
        objAlertDialog.setMessage("No amount found !"+"\n"+" Please enter your money !");
        objAlertDialog.setCancelable(false);
        objAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                mpp.start();
            }
        });objAlertDialog.show();
    }
    public void ShowAnswer(Context context, String strMoney, String strAnswer, String strUnit, final MediaPlayer mpp){
        objAlertDialog = new AlertDialog.Builder(context);
        objAlertDialog.setIcon(R.drawable.chart);
        objAlertDialog.setTitle("Exchange Money");
        objAlertDialog.setMessage("Your money = "+strMoney +" THB"+"\n"+"Exchange = " + strAnswer +" "+strUnit);
        objAlertDialog.setCancelable(false);
        objAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                mpp.start();
            }
        });objAlertDialog.show();
    }

}
