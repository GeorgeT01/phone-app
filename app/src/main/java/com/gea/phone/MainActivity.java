package com.gea.phone;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnAsterisk, btnHashtag, backspaceBtn, dialBtn;
    private TextView phoneNumber;
    private Intent callIntent;
    String phoneNumberString;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnZero = findViewById(R.id.btnZero);
        btnAsterisk = findViewById(R.id.btnAsterisk);
        btnHashtag = findViewById(R.id.btnHashtag);
        backspaceBtn = findViewById(R.id.backspaceBtn);
        dialBtn = findViewById(R.id.dialBtn);
        phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher()); // phone number formatting

        btnOne.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "1");
                //phoneNumber.append("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "7");
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "9");
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "0");
            }
        });
        btnZero.setOnLongClickListener(new View.OnLongClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onLongClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "+");
                return true;
            }
        });
        btnHashtag.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "#");
            }
        });
        btnAsterisk.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                phoneNumber.setText(phoneNumber.getText().toString() + "*");
            }
        });
        backspaceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearDisplay = DONT_CLEAR;
                String str = phoneNumber.getText().toString();
                if (str.length() > 1) {
                    str = str.substring(0, str.length() - 1);
                    phoneNumber.setText(str);
                } else {
                    phoneNumber.setText("");
                }
            }
        });
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                //Uri number = Uri.parse("tel:"+phoneNumber.getText().toString());
                callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            1);
                    return;
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {// If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(callIntent);
            } else {
                // permission denied
                Toast.makeText(MainActivity.this, "Permission denied to make a phone call", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private View.OnTouchListener otl = new View.OnTouchListener() {
        public boolean onTouch (View v, MotionEvent event) {
            return true; // the listener has consumed the event
        }
    };
}
