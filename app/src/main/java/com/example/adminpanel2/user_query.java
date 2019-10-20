package com.example.adminpanel2;

public class user_query {

    private String Source;
    private String Destination;

    public user_query(){
    }

    public user_query(String source, String destination){
        Source = source;
        Destination = destination;
    }

    public String getSource(){
        return Source;
    }

    public String getDestination(){
        return Destination;
    }

    public void setSource(String source) {
        Source = source;
    }

    public void setDestination(String destination){
        Destination = destination;
    }

}
