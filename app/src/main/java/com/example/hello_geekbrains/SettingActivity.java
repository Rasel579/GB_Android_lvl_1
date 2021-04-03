package com.example.hello_geekbrains;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Switch;

import com.example.hello_geekbrains.bussines_logic.Theme;

public class SettingActivity extends AppCompatActivity {
    private Switch switcherTheme;
    private Theme chosenTheme;
    private  final static String KeyChosenTheme = "KeyChosenTheme";
    private final static String NameSharedPreference = "Login";
    private final static String AppTheme = "Theme.Hello_GeekBrains";
    private final static int Hello_GeekBrainsStyle = 0;
    private final static int DarkTheme = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getTheme(R.style.Theme_Hello_GeekBrains));
        setContentView(R.layout.activity_setting);
        switcherTheme = findViewById(R.id.switchTheme);
        chosenTheme = new Theme(R.style.Theme_Hello_GeekBrains);

    }

    private int getTheme(int themeStyle) {
        return switchStileThemeById(getStyleTheme(themeStyle));
    }



    private int switchStileThemeById(int styleTheme) {
        switch (styleTheme){
            case  DarkTheme:
                return R.style.DarkTheme;
            default:
                return R.style.Theme_Hello_GeekBrains;
        }
    }

    private int getStyleTheme(int themeStyle) {
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPreferences.getInt(AppTheme, themeStyle);
    }

    public void switchTheme(View view) {
        if (switcherTheme.isChecked()){
            setAppTheme(DarkTheme);
            chosenTheme.setChosenTheme(R.style.DarkTheme);
        } else{
            setAppTheme(Hello_GeekBrainsStyle);
            chosenTheme.setChosenTheme(R.style.Theme_Hello_GeekBrains);
        }
        recreate();
    }

    private void setAppTheme(int darkTheme) {
        SharedPreferences sharedPreferences = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(AppTheme, darkTheme);
        editor.apply();

    }

    public void getBackBtn(View view){
        Intent themeIntent = new Intent(SettingActivity.this, MainActivity.class);
        themeIntent.putExtra(AppTheme, chosenTheme.getChosenTheme());
        System.out.println(chosenTheme.getChosenTheme());
        startActivity(themeIntent);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KeyChosenTheme, chosenTheme);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        chosenTheme = savedInstanceState.getParcelable(KeyChosenTheme);
    }
}