package com.example.playtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numage;
    private Spinner spsex;
    private Button mbtnok;
    private TextView mtxtresult,mtxtage;
    private String strsex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxtage=(TextView)findViewById(R.id.txtage);
        mtxtage.setText("25");

        numage=(NumberPicker)findViewById((R.id.numage));
        numage.setMinValue(0);
        numage.setMaxValue(100);
        numage.setValue(25);
        numage.setOnValueChangedListener(numChange);

        mbtnok=(Button)findViewById(R.id.btn_ok);
        mbtnok.setOnClickListener(btnonClick);

        mtxtresult=(TextView)findViewById(R.id.txtresult);
        spsex=(Spinner)findViewById(R.id.spnsex);
        spsex.setOnItemSelectedListener(spsexOnItemSelected);
    }

    private View.OnClickListener btnonClick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int age=numage.getValue();
            String strresult=getString(R.string.result);

            if(age<25)
                strresult+=getString(R.string.not_hurry);
            else if(age>30)
                strresult+=getString(R.string.get_married);
            else
                strresult+=getString(R.string.find_couple);
            mtxtresult.setText(strresult);
        }
    };

    private AdapterView.OnItemSelectedListener spsexOnItemSelected=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            strsex=parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    private NumberPicker.OnValueChangeListener numChange=new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            mtxtage.setText(String.valueOf(newVal));
        }
    };
}
