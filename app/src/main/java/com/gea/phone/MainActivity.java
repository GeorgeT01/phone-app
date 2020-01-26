package com.gea.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnOne, btnTwo, backspaceBtn, dialBtn;
    EditText phoneNumber;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //final TextView textView = findViewById(R.id.phoneNumber);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);

        backspaceBtn = findViewById(R.id.backspaceBtn);
        dialBtn = findViewById(R.id.dialBtn);
        phoneNumber = findViewById(R.id.phoneNumber);
        btnOne.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "2");
                ;
            }
        });

        backspaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //clearCalcDisplay = DONT_CLEAR;
                String str = phoneNumber.getText().toString();
                if (str.length() > 1) {
                    str = str.substring(0, str.length() - 1);
                    phoneNumber.setText(str);
                } else if (str.length() <= 1) {
                    phoneNumber.setText("");
                }
            }
        });
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri number = Uri.parse("tel:"+phoneNumber.getText().toString());
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    Activity#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for Activity#requestPermissions for more details.
                        return;
                    }
                }
                startActivity(callIntent);
            }
        });

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(phoneNumber.getText().toString().isEmpty()){
                    backspaceBtn.setVisibility(View.INVISIBLE);
                }else{
                    backspaceBtn.setVisibility(View.VISIBLE);
                }
            }
        });


        phoneNumber.setOnTouchListener(otl);

        // backspace
        backspaceBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                phoneNumber.setText("");
                return false;
            }
        });
       // phoneNumber.addTextChangedListener();


    }
    private View.OnTouchListener otl = new View.OnTouchListener() {
        public boolean onTouch (View v, MotionEvent event) {
            return true; // the listener has consumed the event
        }
    };
}
