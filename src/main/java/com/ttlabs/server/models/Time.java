package com.ttlabs.server.models;

import java.time.LocalTime;


public class Time {

	LocalTime time;
	String timezone;


    public Time() {
    }

    public LocalTime getTime() {
        return this.time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Time(LocalTime time, String timezone) {
        this.time = time;
        this.timezone = timezone;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    
 
    
}