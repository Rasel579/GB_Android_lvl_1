package com.example.hello_geekbrains;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.hello_geekbrains.bussines_logic.ArithmeticLogic;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button goToSettings;


    private final static String KeyArithmeticLogic = "ArithmeticLogic";
    private ArithmeticLogic arithmeticLogic;
    private final static String AppTheme = "Theme.Hello_GeekBrains";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getExtras() != null){
            int themeStyle = getIntent().getExtras().getInt(AppTheme);
            setTheme(themeStyle);
        }
        setContentView(R.layout.activity_main);
        arithmeticLogic = new ArithmeticLogic();
        editText = findViewById(R.id.calculatorEditText);

    }




    //Добавляем на экран через determineView в editText введенные пользователем данные
    public void putToEditTextNumber(View view) {
        determineView(view);
        editText.setText(arithmeticLogic.getStringParser());
    }

    public void getResult(View view) {
        editText.setText(arithmeticLogic.getResult());
    }
    //Определяем тип нажатой кнопки
    private void determineView(View view) {
        switch (view.getId()){
                case R.id.button1:
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

   //сохраняем состояние
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KeyArithmeticLogic, arithmeticLogic);

    }
    //восстонавливаем объект arithmeticLogic через Parcelable
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        arithmeticLogic = savedInstanceState.getParcelable(KeyArithmeticLogic);
    }

    public void goToSettings(View view){
        Intent runSettings = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(runSettings);
    }

}