package com.naza.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class BMIRecord {
    String date;
    int weight;
    int length;


    public BMIRecord(String date,int weight,int length){
        this.date = date;
        this.weight = weight;
        this.length = length;
    }

    public String getDate(){return date;}

    public void setDate(String date) {this.date=date;}


    public int getWeight(){return weight;}

    public void setDate(int weight) {this.weight=weight;}



    public int getLength(){return length;}

    public void setLength(int length) {this.length=length;}


    public double getBmi(){return 0;}

    public String getBmiMessage(){
        double bmi = this.getBmi();
        String msg ="Normal";

        return msg;
    }

    public double getBmiDifference(BMIRecord record){
        return this.getBmiDifference(record); }

    public String getBmiDifferenceMessage(BMIRecord record){
        double diff = this.getBmiDifference(record);
        String msg="Test";
        return msg;
    }
}
