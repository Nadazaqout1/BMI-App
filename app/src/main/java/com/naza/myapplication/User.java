package com.naza.myapplication;

import android.content.Intent;
import android.icu.util.LocaleData;

import java.time.Period;
import java.util.ArrayList;

public class User {
    private ArrayList<BMIRecord> records ;
    String name;
    String email;
    String password;
    String gender;
    String DOB;
    int age;
    float AgePercent;


    public User(){
        this.records = new ArrayList<BMIRecord>();

        records.add(new BMIRecord("20/2/2022",56,167));
        records.add(new BMIRecord("21/2/2022",60,168));
        records.add(new BMIRecord("22/2/2022",55,154));
        records.add(new BMIRecord("23/2/2022",58,169));
        records.add(new BMIRecord("24/2/2022",50,150));
        records.add(new BMIRecord("25/2/2022",54,155));
        records.add(new BMIRecord("26/2/2022",66,170));
        records.add(new BMIRecord("27/2/2022",49,150));

    }

    public ArrayList<BMIRecord> getRecords(){ return records; }

    public void calculateAge(){
        int dayOfBirth = Integer.parseInt(DOB.substring(0,2));
        int monthOfBirth = Integer.parseInt(DOB.substring(3,5));
        int yearOfBirth = Integer.parseInt(DOB.substring(6,10));

        LocaleData today=LocaleData.now();
        LocaleData birth_date = LocaleData.of(yearOfBirth,monthOfBirth,dayOfBirth);

        int age = Period.between(birth_date,today).getYears();
        this.setAge(age);

    }

    public void calculateAgePercent(){
        int age = this.getAge();
        if (age>=2 && age<=20)
            setAgePercent((float)0.7);
        else if (age>10 && age<=20){
            switch (gender){
                case "female":
                 setAgePercent((float)0.8);
                case "male":
                    setAgePercent((float)0.9);
            }
        }
        else setAgePercent((float)1);
    }

}
