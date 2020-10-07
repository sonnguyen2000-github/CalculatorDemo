package com.example.bvn309;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView, textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        //
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.dot).setOnClickListener(this);
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.multiply).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.C).setOnClickListener(this);
        findViewById(R.id.CE).setOnClickListener(this);
        //
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.zero:
                completingNumber("0");
                break;
            case R.id.one:
                completingNumber("1");
                break;
            case R.id.two:
                completingNumber("2");
                break;
            case R.id.three:
                completingNumber("3");
                break;
            case R.id.four:
                completingNumber("4");
                break;
            case R.id.five:
                completingNumber("5");
                break;
            case R.id.six:
                completingNumber("6");
                break;
            case R.id.seven:
                completingNumber("7");
                break;
            case R.id.eight:
                completingNumber("8");
                break;
            case R.id.nine:
                completingNumber("9");
                break;
            case R.id.dot:
                completingNumber(".");
                break;
            case R.id.plus:
                update(textView.getText() + "+");
                break;
            case R.id.minus:
                update(textView.getText() + "-");
                break;
            case R.id.multiply:
                update(textView.getText() + "*");
                break;
            case R.id.divide:
                update(textView.getText() + "/");
                break;
            case R.id.equal:
                textView.setText(String.format("%.4f", calculate(textView.getText().toString())));
                textView1.setText("");
                break;
            case R.id.C:
                textView.setText("0");
                textView1.setText("");
                break;
            case R.id.CE:
                textView.setText("0");
                break;

        }
    }

    public void update(String character) {
        textView1.append(character);
        textView.setText("0");
    }

    public void completingNumber(String typing) {
        if(Float.parseFloat(textView.getText().toString())==0&&!typing.equals("."))
            textView.setText("");
        textView.append(typing);
    }

    public float calculate(String input) {
        Stack<Float> number = new Stack<>();
        Stack<String> method = new Stack<>();
        float result = 0;

        textView.setText(result + "");

        return result;
    }
}