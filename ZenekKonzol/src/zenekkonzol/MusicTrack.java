/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package zenekkonzol;

/**
 *
 * @author david
 */
public class MusicTrack {
    private int hour;
    private int minute;
    private int second;
    private String station; 


    public MusicTrack(int hour, int minute, int second, String station) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.station = station;
    }

    
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
