package com.example.alertdialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        dialog =  new Dialog( MainActivity.this );
        dialog.setContentView( R.layout.custom );
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            dialog.getWindow().setBackgroundDrawable( getDrawable( R.drawable.custom_background ) );
        }
        dialog.getWindow().setLayout( ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT );
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        Button okay = dialog.findViewById( R.id.btn_okay );
        Button cancel = dialog.findViewById( R.id.btn_cancel );

        okay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( getApplicationContext(),"Okay",Toast.LENGTH_SHORT ).show();
                dialog.dismiss();
            }
        } );

        cancel.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this,"cancel",Toast.LENGTH_SHORT ).show();
                dialog.dismiss();
            }
        } );






        button = (Button) findViewById( R.id.dialog_btn );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();

            }
        } );
    }
}