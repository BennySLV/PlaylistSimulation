package Section6.LinkedListChallenge;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built lists, autoboxing
 * and unboxing
 *
 * This class will represent the playlist, containing the
 * list of stored songs and/or albums that the user can access and
 * add or remove from the playlist.
 *
 * Based on the above, the user will have the ability
 * to add or remove either individual songs or entire albums
 * at their preference.
 *
 * @author Ben Silveston
 */
public class Playlist implements IPlaylist {
    private Song song;
    private Album album;
    private Library library;
    private LinkedList<Song> storedSongs;
    private LinkedList<Album> storedAlbums;
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructor
     *
     * This constructor will automatically create
     * a default library for the user to simply
     * add songs and/or albums to it.
     *
     * @param library The library containing all songs and albums to be added to the playlist
     * @param storedAlbums The list of stored albums
     * @param storedSongs The list of stored songs
     */
    Playlist(Library library, LinkedList<Album> storedAlbums, LinkedList<Song> storedSongs) {
        this.library = library;
        this.storedAlbums = storedAlbums;
        this.storedSongs = storedSongs;
    }

    /**
     * Get a specific song's data
     * from the playlist
     *
     * @return The current song data
     */
    private Song getSong() {
        return song;
    }

    /**
     * Get a specific album's data
     * from the playlist.
     *
     * @return The current album data
     */
    private Album getAlbum() {
        return album;
    }

    /**
     * Get the library object data
     *
     * @return The library object data
     */
    Library getLibrary() {
        return library;
    }

    /**
     * Get the list of stored albums
     *
     * @return The current list
     */
    private LinkedList<Album> getStoredAlbums() {
        return storedAlbums;
    }

    /**
     * Get the list of individually stored songs
     *
     * @return The current list
     */
    private LinkedList<Song> getStoredSongs() {
        return storedSongs;
    }

    /**
     * Enter the song details
     * for use in all playlist methods.
     *
     * This method prevents repeated
     * Scanner messaging code in other methods that would
     * otherwise be present.
     *
     * @return The song title that will be used in other playlist methods
     */
    private String enterSongTitle() {
        System.out.print("Please enter the song's title: ");
        String songTitle = SCANNER.nextLine().trim();
        if(!songTitle.isEmpty()) {
            if(this.getLibrary().songExistsInLibrary(songTitle)) {
                return songTitle;
            }
            else {
                return "Error - song title not found.";
            }
        }
        return "Error - song title not entered.";
    }

    /**
     * Enter the album details
     *
     * This method will be used for all playlist
     * methods associated with albums
     *
     * @return The album title that will be used in other playlist methods
     */
    private String enterAlbumTitle() {
        System.out.print("Please enter the album's title: ");
        String albumTitle = SCANNER.nextLine().trim();
        if(!albumTitle.isEmpty()) {
            if(this.getLibrary().albumExistsInLibrary(albumTitle)) {
                return albumTitle;
            }
        }
        else {
            return "Error - album title not entered.";
        }
        return "Error - album title not entered.";
    }

    /**
     * Add all new songs to the playlist
     * in (descending) chronological order.
     *
     * Ensuring that the most recently added
     * song therefore appears at the top of the
     * list.
     *
     * If there is no suitable place to add the new
     * song then add it at the end of the list.
     *
     * @param song The song to be added to the playlist
     */
    @Override
    public boolean addInChronologicalOrder(Song song) {
        ListIterator<Song> songListIterator = this.getStoredSongs().listIterator();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        while(songListIterator.hasNext()) {
            int comparison = songListIterator.next().getTimestamp().compareTo(timestamp);
            if(comparison == 0) {
                System.out.println("Error - song has already been added to the playlist.");
                return false;
            }
            else if(comparison > 0) {
                songListIterator.next();
                songListIterator.add(song);
                return true;
            }
            else {
                songListIterator.previous();
                songListIterator.add(song);
                return true;
            }
        }
        songListIterator.add(song);
        return true;
    }

    /**
     * Add all new albums to the playlist
     * in (descending) chronological order.
     *
     * Ensuring that the most recently added
     * album therefore appears at the top of the
     * list.
     *
     * If there is no suitable place to add the new
     * album then add it at the end of the list.
     *
     * @param album The song to be added to the playlist
     */
    @Override
    public boolean addInChronologicalOrder(Album album) {
        ListIterator<Album> albumListIterator = this.getStoredAlbums().listIterator();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        while(albumListIterator.hasNext()) {
            int comparison = albumListIterator.next().getTimestamp().compareTo(timestamp);
            if(comparison == 0) {
                System.out.println("Error - album has already been added to the playlist.");
                return false;
            }
            else if(comparison > 0) {
                albumListIterator.next();
                albumListIterator.add(album);
                return true;
            }
            else {
                albumListIterator.previous();
                albumListIterator.add(album);
                return true;
            }
        }
        albumListIterator.add(album);
        return true;
    }

    /**
     * Add an individual song to the playlist
     *
     * This methods gives the user the option
     * to add specific songs from the album
     * rather than the entire album.
     */
    @Override
    public void addSongToPlaylist() {
        System.out.println("Please add the following details: " +
                "\n\t a. Song duration" +
                "\n\t b. Song title" +
                "\n\t c. Song artist");
        int songDuration = SCANNER.nextInt();
        SCANNER.nextLine(); // Eliminates the "\n" returned before the next nextLine() method call
        String songTitle = SCANNER.nextLine().trim();
        String songArtist = SCANNER.nextLine().trim();

        if(this.getLibrary().songExistsInLibrary(songTitle)) {
            if(!songIsInPlaylist(songTitle)) {
                this.song = new Song(songTitle, songDuration, songArtist, this.getLibrary().getCurrentTime());
                this.addInChronologicalOrder(this.song);
                if(this.getStoredSongs().contains(this.song)) {
                    System.out.println("Song has been added to the playlist successfully.");
                }
                else {
                    System.out.println("Error - song could not be added.");
                }
            }
            else {
                System.out.println("Error - song is already in the playlist.");
            }
        }
        else {
            System.out.println("Error - song does not exist.");
        }
    }

    /**
     * Remove an individual song from the playlist
     */
    @Override
    public void removeSongFromPlaylist() {
        System.out.print("Please type in the song that you want to remove, using its title: ");
        String songTitle = SCANNER.nextLine().trim();

        for(int i = 0; i < this.getStoredSongs().size(); i++) {
            if(songTitle.equalsIgnoreCase(this.getStoredSongs().get(i).getTitle())) {
                this.getStoredSongs().remove(this.getStoredSongs().get(i));
                System.out.println("Song has been removed from the playlist successfully.");
            }
            else {
                System.out.println("Error - song not found.");
            }
        }
    }

    /**
     * Check if a given song is
     * in the playlist, using the
     * song's title.
     *
     * This method will ensure that
     * a specific song cannot be added
     * twice to the playlist.
     *
     * @param songTitle The title of the song
     * @return The result
     */
    private boolean songIsInPlaylist(String songTitle) {
        ListIterator<Song> songListIterator = this.getStoredSongs().listIterator();
        boolean songInPlaylist = false;
        if(!this.getStoredSongs().isEmpty()) {
            while(songListIterator.hasNext()) {
                if(songListIterator.next().getTitle().equalsIgnoreCase(songTitle)) {
                    songInPlaylist = true;
                    break;
                }
            }
        }
        return songInPlaylist;
    }

    /**
     * Add an entire stored album
     * to the playlist.
     *
     * All albums in this method will also
     * be sorted in chronological order,
     * based on the time in which each
     * one was added to the playlist.
     *
     * This method will not allow the user
     * to add individual songs from each stored album.
     */
    @Override
    public void addAlbumToPlaylist() {
        System.out.println("Please add the following details: " +
                "\n\t a. Album title" +
                "\n\t b. Album artist");
        String albumTitle = SCANNER.nextLine().trim();
        String albumArtist = SCANNER.nextLine().trim();

        if(this.getLibrary().albumExistsInLibrary(albumTitle)) {
            if(!albumIsInPlaylist(albumTitle)) {
                this.album = new Album(albumTitle, albumArtist, this.getLibrary().getCurrentTime());
                this.addInChronologicalOrder(this.album);
                if(this.getStoredAlbums().contains(this.album)) {
                    System.out.println("Album has been added to the playlist successfully.");
                }
            }
            else {
                System.out.println("Error - album is already in the playlist!");
            }
        }
        else {
            System.out.println("Error - album does not exist!");
        }
    }

    /**
     * Remove a stored album from the playlist.
     */
    @Override
    public void removeAlbumFromPlaylist() {
        System.out.print("Please type in the album that you want to remove, using its title: ");
        String albumTitle = SCANNER.nextLine().trim();
        if(albumIsInPlaylist(albumTitle)) {
            this.getStoredAlbums().remove(this.getLibrary().getAlbum());
        }
    }

    /**
     * Check if a given album is in the playlist.
     *
     * This method will determine whether a specific
     * album has already been added to the playlist
     * so that it cannot be added twice.
     *
     * @param albumTitle The title of the album
     * @return The result
     */
    private boolean albumIsInPlaylist(String albumTitle) {
        ListIterator<Album> albumListIterator = this.getStoredAlbums().listIterator();
        boolean albumInPlaylist = false;
        if(!this.getStoredAlbums().isEmpty()) {
            while(albumListIterator.hasNext()) {
                if(albumListIterator.next().getTitle().equalsIgnoreCase(albumTitle)) {
                    albumInPlaylist = true;
                    break;
                }
            }
        }
        return albumInPlaylist;
    }

    /**
     * Play a specific song
     * from the playlist
     */
    @Override
    public void play() {
        ListIterator<Song> songListIterator = this.getStoredSongs().listIterator();
        if(songIsInPlaylist(enterSongTitle())) {
            System.out.println("Now playing: " + "\n\t Song: " + songListIterator.next().getTitle());
            boolean hasNotSelected = true;
            while(hasNotSelected) {
                System.out.println("Press 1 to Skip forwards (>|)");
                System.out.println("Press 2 to Skip backwards (|<)");

                byte selection = SCANNER.nextByte();
                switch(selection) {
                    case 1:
                        skipForwards();
                        hasNotSelected = false;
                        break;
                    case 2:
                        skipBackwards();
                        hasNotSelected = false;
                        break;
                }
            }
        }
        else {
            System.out.println("Error - song not currently playing.");
        }
    }

    /**
     * Skip to the next song
     * in the playlist
     */
    @Override
    public void skipForwards() {
        ListIterator<Song> songListIterator = this.getStoredSongs().listIterator();
        while(songListIterator.hasNext()) {
            if(songListIterator.hasNext()) {
                songListIterator.next();
                System.out.println("Now playing: " + songListIterator.next().getTitle());
            }
            else {
                System.out.println("Reached the end of the playlist...");
            }
        }
    }

    /**
     * Skip to the previous song
     * in the playlist
     */
    @Override
    public void skipBackwards() {
        ListIterator<Song> songListIterator = this.getStoredSongs().listIterator();
        while(songListIterator.hasPrevious()) {
            if(songListIterator.hasPrevious()) {
                songListIterator.previous();
                System.out.println("Now playing: " + songListIterator.previous().getTitle());
            }
            else {
                System.out.println("Reached the start of the playlist...");
            }
        }
    }

    /**
     * Search for a given song
     * in the playlist
     */
    @Override
    public void searchForSong() {
        Iterator<Song> songIterator = this.getStoredSongs().iterator();
        String songTitle = songIterator.next().getTitle();
        Timestamp timestamp = songIterator.next().getTimestamp();
        while(songIterator.hasNext()) {
            if(enterSongTitle().equalsIgnoreCase(songTitle)) {
                System.out.println("\t Song title: " + songTitle);
                System.out.println("\t Date added: " + timestamp);
            }
            else {
                System.out.println("Error - song not found.");
            }
        }
    }

    /**
     * Search for a given album
     * in the playlist.
     */
    @Override
    public void searchForAlbum() {
        ListIterator<Album> albumListIterator = this.getStoredAlbums().listIterator();
        while(albumListIterator.hasNext()) {
            String albumTitle = albumListIterator.next().getTitle();
            if(enterAlbumTitle().equalsIgnoreCase(albumTitle)) {
                System.out.println("Album title: " + albumTitle);
            }
            else {
                System.out.println("Error - album not found.");
            }
        }
    }

    /**
     * Print the playlist
     * of songs.
     */
    @Override
    public void showPlaylistOfSongs() {
        ListIterator<Song> songListIterator = this.getStoredSongs().listIterator();
        System.out.println("Songs currently in the playlist: ");
        System.out.println("************************");
        while(songListIterator.hasNext()) {
            System.out.println("Title: " + songListIterator.next().getTitle());
        }
        System.out.println("************************");
    }

    /**
     * Print the playlist containing
     * all stored albums.
     */
    @Override
    public void showPlaylistOfAlbums() {
        ListIterator<Album> albumListIterator = this.getStoredAlbums().listIterator();
        System.out.println("Albums currently in the playlist: ");
        System.out.println("************************");
        while(albumListIterator.hasNext()) {
            System.out.println("Title: " + albumListIterator.next().getTitle());
        }
        System.out.println("************************");
    }
}