package Section6.LinkedListChallenge;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built lists, autoboxing
 * and unboxing
 *
 * This class will represent an album that will be
 * stored in the playlist application.
 *
 * Each album stored will contain a list of songs
 * and will be grouped based on the given day and time.
 *
 * With the most recent being displayed first.
 *
 * @author Ben Silveston
 */
public class Album {
    private String title;
    private String artist;
    private int duration;
    private Timestamp timestamp;
    private ArrayList<Song> songs;

    /**
     * Constructor
     *
     * @param title The title of the album
     * @param artist The artist of the album
     * @param timestamp The current time represented as a timestamp
     */
    Album(String title, String artist, Timestamp timestamp) {
        this.title = title;
        this.artist = artist;
        this.duration = 0;
        this.timestamp = timestamp;
        this.songs = new ArrayList<>();
    }

    /**
     * Get the current title of the album
     *
     * @return The current title
     */
    String getTitle() {
        return title;
    }

    /**
     * Get the current name
     * of the artist of the album.
     *
     * @return The current name of the artist
     */
    String getArtist() {
        return artist;
    }

    /**
     * Get the current duration
     * of the album.
     *
     * @return The current duration of the album
     */
    int getDuration() {
        return duration;
    }

    /**
     * Get the timestamp representing
     * the current time for the album.
     *
     * This method will be used for ordering
     * all albums in chronological order for
     * the playlist.
     *
     * @return The current time, represented as a timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Get the current song list
     * for the album.
     *
     * @return The current song list
     */
    ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Calculate the total duration
     * for a given album, based on
     * the number of songs and their
     * respective durations.
     *
     * @return The total album duration
     */
    private int calculateAlbumDuration() {
        int totalDuration = 0;
        for(int i = 0; i < this.getSongs().size(); i++) {
            totalDuration += this.getSongs().get(i).getDuration();
        }
        return totalDuration;
    }

    /**
     * Format the total duration
     * of a song (in seconds) in the time
     * format string of : "hh:mm:ss".
     *
     * @param duration The duration of the album (in seconds)
     * @return The formatted time as described above
     */
    public String formatAlbumDuration(int duration) {
        duration = calculateAlbumDuration();
        int hours = duration / 60 / 60;
        int minutes = duration / 60;
        int seconds = duration % 60;
        String formattedHours = String.format("%02d", hours);
        String formattedMinutes = String.format("%02d", minutes);
        String formattedSeconds = String.format("%02d", seconds);
        return formattedHours + ":" + formattedMinutes + ":" + formattedSeconds;
    }
}