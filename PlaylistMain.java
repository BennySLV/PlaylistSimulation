package Section6.LinkedListChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built lists, autoboxing
 * and unboxing
 *
 * This main class and program will build and run
 * the playlist application.
 *
 * @author Ben Silveston
 */
public class PlaylistMain {
    private Playlist playlist;
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructor
     *
     * @param playlist The new playlist object
     */
    private PlaylistMain(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     * Get the playlist data
     *
     * @return The current playlist object data
     */
    private Playlist getPlaylist() {
        return playlist;
    }

    /**
     * Functionality to allow
     * the user to continue with
     * a specific section of
     * the application.
     */
    private static boolean continueSection() {
        System.out.print("Do you wish to continue? (Y / N) ");
        String answer = SCANNER.next();
        if(answer.equalsIgnoreCase("Yes") || answer.equalsIgnoreCase("Y")) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Song section of the application
     *
     * This section of the application will
     * be used for creating, adding and removing
     * individual songs.
     *
     * Each newly created song will be added to the library
     * prior to being added to the playlist.
     */
    private void songSection() {
        boolean sectionRunning = true;
        while(sectionRunning) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Create a new song and add it to the library" +
                    "\n\t 2 - Modify an existing song" +
                    "\n\t 3 - Delete an existing song" +
                    "\n\t 4 - View all stored songs in the library");

            byte selection = SCANNER.nextByte();
            switch(selection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            if(!continueSection()) {
                sectionRunning = false;
                runApplication();
            }
        }
    }

    /**
     * Album section of the application
     *
     * This section of the application will be used
     * to create albums and add to and remove songs
     * from these.
     *
     * Each newly created album will be added to the library
     * prior to being added to the playlist.
     */
    private void albumSection() {
        boolean sectionRunning = true;
        while(sectionRunning) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Create a new album and add it to the library" +
                    "\n\t 2 - Delete an existing album" +
                    "\n\t 3 - Add song to an existing album" +
                    "\n\t 4 - Remove song from an album" +
                    "\n\t 5 - View all stored albums in the library" +
                    "\n\t 6 - View all stored songs in a particular album");

            byte selection = SCANNER.nextByte();
            switch(selection) {
                case 1:
                    this.getPlaylist().getLibrary().addAlbumToLibrary();
                    break;
                case 2:
                    this.getPlaylist().getLibrary().removeAlbumFromLibrary();
                    break;
                case 3:
                    this.getPlaylist().getLibrary().addSongToAlbum();
                    break;
                case 4:
                    this.getPlaylist().getLibrary().removeSongFromAlbum();
                    break;
                case 5:
                    this.getPlaylist().getLibrary().viewAlbumsInLibrary();
                    break;
                case 6:
                    this.getPlaylist().getLibrary().viewSongsInAlbum();
                    break;
            }
            if(!continueSection()) {
                sectionRunning = false;
                runApplication();
            }
        }
    }

    /**
     * Library selection of the application
     *
     * This section of the application will be used for adding or
     * removing songs and/or albums from the playlist.
     */
    private void librarySection() {
        boolean sectionRunning = true;
        while(sectionRunning) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Add a new song to the playlist" +
                    "\n\t 2 - Remove an existing song from the playlist" +
                    "\n\t 3 - Add a new album to the playlist" +
                    "\n\t 4 - Remove an existing album from the playlist");

            byte selection = SCANNER.nextByte();
            switch(selection) {
                case 1:
                    this.getPlaylist().addSongToPlaylist();
                    break;
                case 2:
                    this.getPlaylist().removeSongFromPlaylist();
                    break;
                case 3:
                    this.getPlaylist().addAlbumToPlaylist();
                    break;
                case 4:
                    this.getPlaylist().removeAlbumFromPlaylist();
                    break;
            }
            if(!continueSection()) {
                sectionRunning = false;
                runApplication();
            }
        }
    }

    /**
     * Playlist section of the application.
     *
     * This menu text will be for using the playlist
     * and access and manipulation for existing songs
     * and albums.
     */
    private void playlistSection() {
        boolean sectionRunning = true;
        while(sectionRunning) {
            System.out.println("Please select from the following options: " +
                    "\n\t 1 - Play a song" +
                    "\n\t 2 - Stop a song" +
                    "\n\t 3 - Repeat a song" +
                    "\n\t 4 - Skip forwards (>|)" +
                    "\n\t 5 - Skip backwards (|<)" +
                    "\n\t 6 - Shuffle" +
                    "\n\t 7 - Search for a song" +
                    "\n\t 8 - Search for an album" +
                    "\n\t 9 - Print the current playlist");

            byte selection = SCANNER.nextByte();
            switch(selection) {
                case 1:
                    this.getPlaylist().play();
                    break;
                case 2:
                    this.getPlaylist().stop();
                    break;
                case 3:
                    this.getPlaylist().repeat();
                    break;
                case 4:
                    this.getPlaylist().skipForwards();
                    break;
                case 5:
                    this.getPlaylist().skipBackwards();
                    break;
                case 6:
                    this.getPlaylist().shuffle();
                    break;
                case 7:
                    this.getPlaylist().searchForSong();
                    break;
                case 8:
                    this.getPlaylist().searchForAlbum();
                    break;
                case 9:
                    this.getPlaylist().showPlaylist();
                    break;
            }
            if(!continueSection()) {
                sectionRunning = false;
                runApplication();
            }
        }
    }

    /**
     * Run the application
     */
    private void runApplication() {
        System.out.println("Welcome to your playlist! Please select from the following options: " +
                "\n\t 1 - Create a new album" +
                "\n\t 2 - Add or remove songs and/or albums from the playlist" +
                "\n\t 3 - Access the playlist" +
                "\n\t 4 - Quit the application");
        byte menuSelection = SCANNER.nextByte();
        switch(menuSelection) {
            case 1:
                albumSection();
                break;
            case 2:
                librarySection();
                break;
            case 3:
                playlistSection();
                break;
            case 4:
                System.out.println("Playlist application closed.");
                System.exit(0);
                break;
                default:
                    playlistSection();
        }
    }

    /**
     * Main method
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        PlaylistMain playlistMain = new PlaylistMain(new Playlist
                (new Library(new ArrayList<>(), new ArrayList<>()), new LinkedList<>(), new LinkedList<>()));
        playlistMain.runApplication();
    }
} 