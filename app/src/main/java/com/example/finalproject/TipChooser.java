package com.example.finalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.view.View;

public class TipChooser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosetip);

        initTipChooser();
        initRadioGroupTip();

}

private void initTipChooser(){
    SharedPreferences sharedPref = getSharedPreferences("choosetip", Context.MODE_PRIVATE);
    int GroupTip = sharedPref.getInt("tip", 5);
    int GroupTip2 = sharedPref.getInt("tip", 10);
    int GroupTip3 = sharedPref.getInt("tip", 15);

    RadioButton rb$5 = findViewById(R.id.radioFive);
    RadioButton rb$10 = findViewById(R.id.radioTen);
    RadioButton rb$15 = findViewById(R.id.radioFifteen);
    RadioButton rb$20 = findViewById(R.id.radioTwenty);

    if(GroupTip==(5)) {
        rb$5.setChecked(true);
    }else if(GroupTip2==(10)) {
        rb$10.setChecked(true);
    }else if(GroupTip3==(15)) {
        rb$15.setChecked(true);
    }else{
        rb$20.setChecked(true);
    }


}

private void initRadioGroupTip() {
        RadioGroup rg = findViewById(R.id.radioGroupTip);
        RadioButton rb$5 = findViewById(R.id.radioFive);
        RadioButton rb$10 = findViewById(R.id.radioTen);
        RadioButton rb$15 = findViewById(R.id.radioFifteen);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rb$5.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("choosetip", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("tip", 5);
                    editor.apply();
                }else if(rb$10.isChecked()) {
                    SharedPreferences sp = getSharedPreferences("choosetip", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("tip", 10);
                    editor.apply();
                }else if(rb$15.isChecked()){
                    SharedPreferences sp = getSharedPreferences("choosetip", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("tip", 15);
                    editor.apply();
                }else{
                    SharedPreferences sp = getSharedPreferences("choosetip", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("tip", 20);
                    editor.apply();
                }
            }
        });
    }
}


