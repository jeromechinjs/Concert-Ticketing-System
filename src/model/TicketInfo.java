/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class TicketInfo {
    private String artist;
    private String date;
    private String venue;

    public TicketInfo() {
    }

    public TicketInfo( String artist, String date, String venue) {
        this.artist = artist;
        this.date = date;
        this.venue = venue;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    
    
    @Override
    public String toString() {
        return String.format("%-13s %-13s %-5s", artist, date, venue);
    }
    
    
}
