package Section6.LinkedListChallenge;

import java.sql.Timestamp;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built lists, autoboxing
 * and unboxing
 *
 * This class will represent a song that will be stored
 * in the playlist application.
 *
 * @author Ben Silveston
 */
class Song {
    private String title;
    private String artist;
    private int duration;
    private Timestamp timestamp;

    /**
     * Constructor I
     *
     * This constructor will be used
     * for when a song is to be created
     * and added to an album.
     *
     * This means that no artist name is required,
     * as this has already been defined when
     * the album was created previously.
     *
     * @param title The title of the song
     * @param duration The duration of the song
     * @param timestamp The current timestamp when the song is added to the playlist
     */
    Song(String title, int duration, Timestamp timestamp) {
        this.title = title;
        this.duration = duration;
        this.timestamp = timestamp;
    }

    /**
     * Constructor II
     *
     * This constructor will be used to add
     * songs directly to the playlist.
     *
     * In this case, the artist details
     * need to be added to ensure clarity
     * for all songs stored in the playlist.
     *
     * @param title The title of the song
     * @param artist The artist of the song
     * @param timestamp The current timestamp when the song is added to an album
     */
    Song(String title, int duration, String artist, Timestamp timestamp) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
        this.timestamp = timestamp;
    }

    /**
     * Get the current title of the song.
     *
     * @return The current title
     */
    String getTitle() {
        return title;
    }

    /**
     * Get the current name of the artist
     * for the song.
     *
     * @return The current name of the artist
     */
    String getArtist() {
        return artist;
    }

    /**
     * Get the current duration of the song.
     *
     * @return The current duration
     */
    int getDuration() {
        return duration;
    }

    /**
     * Get the timestamp representing
     * the current time for the song.
     *
     * This method will be used for ordering
     * all songs in chronological order for
     * the playlist.
     *
     * @return The current time, represented as a timestamp
     */
    Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * Format a given song duration (in seconds) from
     * an integer to a String in the
     * format of "mm:ss".
     *
     * @param duration The duration of the song, (in seconds)
     * @return The time in the above String format
     */
    String formatSongDuration(int duration) {
        int minutes = duration / 60;
        int seconds = duration % 60;
        String formattedMinutes = String.format("%02d", minutes);
        String formattedSeconds = String.format("%02d", seconds);
        return formattedMinutes + ":" + formattedSeconds;
    }
}