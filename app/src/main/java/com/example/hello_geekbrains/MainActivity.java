package com.example.hello_geekbrains;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hello_geekbrains.bussines_logic.ArithmeticLogic;

import static com.example.hello_geekbrains.R.id.button1;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ArithmeticLogic arithmeticLogic = new ArithmeticLogic();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.calculatorEditText);
    }

    public void putToEditTextNumber(View view) {
        determineView(view);
        editText.setText(arithmeticLogic.getStringParser());
    }

    public void getResult(View view) {
        editText.setText(arithmeticLogic.getResult());
    }

    private void determineView(View view) {
        switch (view.getId()){
                case button1:
                    arithmeticLogic.setStringParser("1");
                    break;
                case R.id.button2:
                    arithmeticLogic.setStringParser("2");
                    break;
                case R.id.button3:
                    arithmeticLogic.setStringParser("3");
                    break;
                case R.id.button4:
                    arithmeticLogic.setStringParser("4");
                    break;
                case R.id.button5:
                    arithmeticLogic.setStringParser("5");
                    break;
                case R.id.button6:
                    arithmeticLogic.setStringParser("6");
                    break;
                case R.id.button7:
                    arithmeticLogic.setStringParser("7");
                    break;
                case R.id.button8:
                    arithmeticLogic.setStringParser("8");
                    break;
                case R.id.button9:
                    arithmeticLogic.setStringParser("9");
                    break;
                case R.id.buttonPlus:
                    arithmeticLogic.setStringParser("+");
                    break;
                case R.id.buttonMinus:
                    arithmeticLogic.setStringParser("-");
                    break;
                case R.id.buttonMultiply:
                    arithmeticLogic.setStringParser("*");
                    break;
                case R.id.buttonPoint:
                    arithmeticLogic.setStringParser(".");
                    break;
                    case R.id.buttonDivide:
                    arithmeticLogic.setStringParser("/");
                    break;
                    case R.id.button0:
                    arithmeticLogic.setStringParser("0");
                    break;
        }
    }

}