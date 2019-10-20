package com.example.adminpanel2;

public class Event
{
    private String Date;
    private String Time;
    private String Eventn;
    private String Address;


    public Event(String date, String time, String eventn, String address) {
        Date = date;
        Time = time;
        Eventn = eventn;
        Address = address;
    }

    public Event() {
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getEventn() {
        return Eventn;
    }

    public void setEventn(String eventn) {
        Eventn = eventn;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
