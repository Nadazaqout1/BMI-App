package com.naza.myapplication;

import android.content.Intent;
import android.icu.util.LocaleData;
import android.os.Build;

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



    public User(String name,String email,String password,String gender,String DOB,ArrayList<BMIRecord>records){
        this.records = new ArrayList<BMIRecord>();
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.DOB = DOB;

        calculateAge();
        calculateAgePercent();
        calculateBmiValue(records.get(bmisLength()-1));
        BMIChange();

    }



    public void calculateBmiValue(BMIRecord record){
        float record_value;
        record_value = (float) ((record.getWeight()/Math.pow(record.getLength(),2))*this.getAgePercent());
        record.setrecord_value(record_value);
    }

    public ArrayList<BMIRecord> getRecords(){ return records; }

    public void calculateAge(){
        int dayOfBirth = Integer.parseInt(DOB.substring(0,2));
        int monthOfBirth = Integer.parseInt(DOB.substring(3,5));
        int yearOfBirth = Integer.parseInt(DOB.substring(6,10));

        LocaleData today=LocaleData.now();
        LocaleData DOB = LocaleData.of(yearOfBirth,monthOfBirth,dayOfBirth);

        int age = Period.between(DOB,today).getYears();
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return DOB;
    }

    public void setBirthday(String birthday) {
        this.DOB = birthday;
    }


    public ArrayList<BMIRecord> getBmis() {
        return records;
    }

    public int bmisLength() {
        return records.size();
    }

    public void setBmis(BMIRecord bmi_item) {
        records.add(bmi_item);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getAgePercent() {
        return agePercent;
    }

    public void setAgePercent(float agePercent) {
        this.agePercent = agePercent;
    }
}