package com.example.hello_geekbrains.bussines_logic;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.hello_geekbrains.R;

import java.io.Serializable;
import java.util.ArrayList;

public class ArithmeticLogic implements Parcelable {
  private String stringArithmeticParser;
  private String stringContainNumber;
  private ArrayList<String> contentNumberAndArithmeticSigns;
  private float result;

  public ArithmeticLogic(){
      this.stringArithmeticParser = "";
      this.contentNumberAndArithmeticSigns = new ArrayList<String>();
      this.stringContainNumber= "";
      this.result = 0;
  }

  protected ArithmeticLogic(Parcel in){
      stringArithmeticParser = in.readString();
      stringContainNumber = in.readString();
      contentNumberAndArithmeticSigns = in.createStringArrayList();
      result = in.readFloat();
  }

    public static final Creator<ArithmeticLogic> CREATOR = new Creator<ArithmeticLogic>() {
        @Override
        public ArithmeticLogic createFromParcel(Parcel in) {
            return new ArithmeticLogic(in);
        }

        @Override
        public ArithmeticLogic[] newArray(int size) {
            return new ArithmeticLogic[size];
        }
    };

    public String getStringParser() {
        return stringArithmeticParser;
    }
    //заполняем поле данными введенными пользователем в стороковом поле stringArithmeticParser
    public void setStringParser(String stringParser) {
        addToContentNumberAndArithmeticSigns(stringParser);
        this.stringArithmeticParser += stringParser;

    }
    //разделяет числа и арифметические знаки пользователя
    private void addToContentNumberAndArithmeticSigns(String stringParser) {

        if (stringParser.equals("+") || stringParser.equals("-") || stringParser.equals("*") || stringParser.equals("/")){
            //высчитывает 1 операцию с двумя числами
            calculateResult(contentNumberAndArithmeticSigns);
            contentNumberAndArithmeticSigns.add(stringParser);
            this.stringContainNumber = "";
        }
        else {
            this.stringContainNumber += stringParser;
        }
    }

    private void calculateResult(ArrayList<String> contentNumberAndArithmeticSigns) {
      contentNumberAndArithmeticSigns.add(stringContainNumber);
      if(contentNumberAndArithmeticSigns.contains("+") && contentNumberAndArithmeticSigns.size() == 3){
          result = Float.parseFloat(contentNumberAndArithmeticSigns.get(0)) + Float.parseFloat(contentNumberAndArithmeticSigns.get(2));
          contentNumberAndArithmeticSigns.clear();
          contentNumberAndArithmeticSigns.add(String.valueOf(result));
      }
      if(contentNumberAndArithmeticSigns.contains("-") && contentNumberAndArithmeticSigns.size() == 3){
          result = Float.parseFloat(contentNumberAndArithmeticSigns.get(0)) - Float.parseFloat(contentNumberAndArithmeticSigns.get(2));
          contentNumberAndArithmeticSigns.clear();
          contentNumberAndArithmeticSigns.add(String.valueOf(result));
      }

      if(contentNumberAndArithmeticSigns.contains("*") && contentNumberAndArithmeticSigns.size() == 3){
          result =   Float.parseFloat(contentNumberAndArithmeticSigns.get(0)) * Float.parseFloat(contentNumberAndArithmeticSigns.get(2));
          contentNumberAndArithmeticSigns.clear();
          contentNumberAndArithmeticSigns.add(String.valueOf(result));
      }

      if(contentNumberAndArithmeticSigns.contains("/") && contentNumberAndArithmeticSigns.size() == 3){
          result = Float.parseFloat(contentNumberAndArithmeticSigns.get(0)) / Float.parseFloat(contentNumberAndArithmeticSigns.get(2));
          contentNumberAndArithmeticSigns.clear();
          contentNumberAndArithmeticSigns.add(String.valueOf(result));
      }
    }

    public String getResult(){
      calculateResult(contentNumberAndArithmeticSigns);
      stringArithmeticParser = "";
      stringContainNumber = "";
      contentNumberAndArithmeticSigns.clear();
      return String.valueOf(result);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(stringArithmeticParser);
        parcel.writeString(stringContainNumber);
        parcel.writeStringList(contentNumberAndArithmeticSigns);
        parcel.writeFloat(result);
    }
}