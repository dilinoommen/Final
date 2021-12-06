package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editCost;
    ConstraintLayout layout;
    private TextView textOutput;
    private double GroupTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initchooseButton();
        initEditCost();

        layout = findViewById(R.id.layout);
        textOutput = findViewById(R.id.textOutput);


    }

    private void initchooseButton() {
        Button choosebutton = findViewById(R.id.chooserbutton);
        choosebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TipChooser.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        });
    }

    private void initEditCost() {
        editCost = findViewById(R.id.editCost);
        editCost.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {


                }
                return false;
            }
        });
    }


    public void onResume() {
        super.onResume();
        SharedPreferences sharedPref = getSharedPreferences("choosetip", Context.MODE_PRIVATE);
        int GroupTip = sharedPref.getInt("tip", 5);
        int GroupTip2 = sharedPref.getInt("tip", 10);
        int GroupTip3 = sharedPref.getInt("tip", 15);

        if (GroupTip == (5)) {
            String input1 = editCost.getText().toString();
            if (!input1.equals("")) {
                double bill = Double.parseDouble(input1);
                bill = bill + GroupTip;
                textOutput.setText("$" + String.format("%.2f", bill));
            }
        }

             else if (GroupTip2 == (10)) {
            String input2 = editCost.getText().toString();
            if (!input2.equals("")) {
                double bill = Double.parseDouble(input2);
                bill = bill + GroupTip2;
                textOutput.setText("$" + String.format("%.2f", bill));
            }
        }


                 else if (GroupTip3 == (15)) {
            String input3 = editCost.getText().toString();
            if (!input3.equals("")) {
                double bill = Double.parseDouble(input3);
                bill = bill + GroupTip3;
                textOutput.setText("$" + String.format("%.2f", bill));
            }
        }
                 else {
                        String input4 = editCost.getText().toString();
                        if (!input4.equals("")) {
                            double bill = Double.parseDouble(input4);
                            bill = bill + 20;
                            textOutput.setText("$" + String.format("%.2f", bill));

                        }
                    }
                }
            }


