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
                    "\n\t 2 - Delete an existing song" +
                    "\n\t 3 - View all stored songs in the library" +
                    "\n\t 4 - Back to main menu");

            byte selection = SCANNER.nextByte();
            switch(selection) {
                case 1:
                    this.getPlaylist().getLibrary().addSongToLibrary();
                    break;
                case 2:
                    this.getPlaylist().getLibrary().removeSongFromLibrary();
                    break;
                case 3:
                    this.getPlaylist().getLibrary().viewSongsInLibrary();
                    break;
                case 4:
                    runApplication();
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
                    "\n\t 1 - Create and add a new album to the library" +
                    "\n\t 2 - Delete an existing album" +
                    "\n\t 3 - Add song to an existing album" +
                    "\n\t 4 - Remove song from an album" +
                    "\n\t 5 - View all stored albums in the library" +
                    "\n\t 6 - View all stored songs in a particular album" +
                    "\n\t 7 - Back to main menu");

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
                case 7:
                    runApplication();
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
                    "\n\t 4 - Remove an existing album from the playlist" +
                    "\n\t 5 - Back to main menu");

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
                case 5:
                    runApplication();
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
                    "\n\t 1 - Play complete playlist" +
                    "\n\t 2 - Search for a song" +
                    "\n\t 3 - Search for an album" +
                    "\n\t 4 - Print the current playlist of songs" +
                    "\n\t 5 - Print the current playlist of albums" +
                    "\n\t 6 - Back to main menu");

            byte selection = SCANNER.nextByte();
            switch(selection) {
                case 1:
                    this.getPlaylist().play();
                    playlistSection();
                    break;
                case 2:
                    this.getPlaylist().searchForSong();
                    if(!continueSection()) {
                        sectionRunning = false;
                        runApplication();
                    }
                    break;
                case 3:
                    this.getPlaylist().searchForAlbum();
                    if(!continueSection()) {
                        sectionRunning = false;
                        runApplication();
                    }
                    break;
                case 4:
                    this.getPlaylist().showPlaylistOfSongs();
                    if(!continueSection()) {
                        sectionRunning = false;
                        runApplication();
                    }
                    break;
                case 5:
                    this.getPlaylist().showPlaylistOfAlbums();
                    if(!continueSection()) {
                        sectionRunning = false;
                        runApplication();
                    }
                    break;
                case 6:
                    runApplication();
                    break;
            }
        }
    }

    /**
     * Run the application
     */
    private void runApplication() {
        System.out.println("Welcome to your playlist! Please select from the following options: " +
                "\n\t 1 - Create a new song" +
                "\n\t 2 - Create a new album" +
                "\n\t 3 - Add or remove songs and/or albums from the playlist" +
                "\n\t 4 - Access the playlist" +
                "\n\t 5 - Quit the application");

        byte menuSelection = SCANNER.nextByte();
        switch(menuSelection) {
            case 1:
                songSection();
                break;
            case 2:
                albumSection();
                break;
            case 3:
                librarySection();
                break;
            case 4:
                playlistSection();
                break;
            case 5:
                System.out.println("Playlist application closed.");
                System.exit(0);
                break;
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