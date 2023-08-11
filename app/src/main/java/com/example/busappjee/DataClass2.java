package com.example.busappjee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DataClass2 {
    public String rollNum,phoneNum,sec,route,duration,genDate,expireDate,username;

      public DataClass2(){}

    public DataClass2(String rollNum, String phoneNum, String sec, String route, String duration, String genDate, String expireDate, String username) {
        this.rollNum = rollNum;
        this.phoneNum = phoneNum;
        this.sec = sec;
        this.route = route;
        this.duration = duration;
        this.genDate = genDate;
        this.expireDate = expireDate;
        this.username = username;
    }

    public String getRollNum() {
        return rollNum;
    }

    public void setRollNum(String rollNum) {
        this.rollNum = rollNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenDate() {
        return genDate;
    }

    public void setGenDate(String genDate) {
        this.genDate = genDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
