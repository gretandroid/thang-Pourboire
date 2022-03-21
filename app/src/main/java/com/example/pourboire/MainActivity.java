package com.example.pourboire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText sumText;
    private RadioGroup choiceGroup;
    private Switch roundOffSwitch;
    private TextView tipTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // references to views
        sumText = findViewById(R.id.sumText);
        choiceGroup = findViewById(R.id.choiceGroup);
        roundOffSwitch = findViewById(R.id.roundOffSwitch);
        tipTextView = findViewById(R.id.tipTextView);
    }

    public void calculate(View view) {
        int choice = choiceGroup.getCheckedRadioButtonId();

        double ratioTip;
        switch (choice) {
            case R.id.supriseRadio:
                ratioTip = 0.2;
                break;
            case R.id.goodRadio:
                ratioTip = 0.18;
                break;
            case R.id.okRadio:
                ratioTip = 0.15;
                break;
            default:
                ratioTip = 0.2;
        }
        double sum = 0.0;
        sum = Double.parseDouble(sumText.getText().toString());
        double tip = sum * ratioTip;
        boolean roundOff = roundOffSwitch.isChecked();
        tipTextView.setText(Double.toString(roundOff? Math.ceil(tip) : Math.round(tip*100)/100));
    }
}