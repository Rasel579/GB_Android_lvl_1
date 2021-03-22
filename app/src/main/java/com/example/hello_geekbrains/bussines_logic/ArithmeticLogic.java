package com.example.hello_geekbrains.bussines_logic;

import android.widget.Button;
import android.widget.FrameLayout;

import com.example.hello_geekbrains.R;

import java.util.ArrayList;

public class ArithmeticLogic {
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

    public String getStringParser() {
        return stringArithmeticParser;
    }

    public void setStringParser(String stringParser) {
        addToContentNumberAndArithmeticSigns(stringParser);
        this.stringArithmeticParser += stringParser;

    }

    private void addToContentNumberAndArithmeticSigns(String stringParser) {

        if (stringParser.equals("+") || stringParser.equals("-") || stringParser.equals("*") || stringParser.equals("/")){
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
}