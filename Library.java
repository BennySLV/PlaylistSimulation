package Section6.LinkedListChallenge;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built lists, autoboxing
 * and unboxing
 *
 * This class represents a music library
 * catalogue. Containing stored albums of songs
 * which have been added by the user.
 *
 * This library will simulate a standard music library database
 * and will be accessed by the playlist at run-time.
 *
 * @author Ben Silveston
 */
public class Library implements ILibrary {
    private Song song;
    private Album album;
    private ArrayList<Song> songs;
    private ArrayList<Album> albums;
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Constructor
     *
     * This constructor will create a library
     * containing all stored songs and albums.
     *
     * @param songs The list of stores songs in the library
     * @param albums The list of stored albums in the library
     */
    Library(ArrayList<Song> songs, ArrayList<Album> albums) {
        this.songs = songs;
        this.albums = albums;
    }

    /**
     * Get an existing song
     * and its data
     *
     * @return The specific song's data
     */
    private Song getSong() {
        return song;
    }

    /**
     * Get an existing album
     * and its data
     *
     * @return The specific album's data
     */
    Album getAlbum() {
        return album;
    }

    /**
     * Get the current list of all songs
     * stored in the library
     *
     * @return The current list of songs
     */
    private ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Get the current list of all albums
     * stored in the library
     *
     * @return The current list of albums
     */
    private ArrayList<Album> getAlbums() {
        return albums;
    }

    /**
     * Get a timestamp that represents the current date and time
     * (i.e. "now" date and time).
     *
     * @return The current date and time, represented as a timestamp
     */
    Timestamp getCurrentTime() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    /**
     * Add an individual song
     * to the library.
     *
     * Note that this method does not
     * allow songs from stored albums
     * to be added.
     */
    @Override
    public void addSongToLibrary() {
        System.out.println("Please add the following details: " +
            "\n\t a. Song title" +
            "\n\t b. Song artist");
        String songTitle = SCANNER.nextLine().trim();
        String songArtist = SCANNER.nextLine().trim();

        if(!songExistsInLibrary(songTitle)) {
            this.song = new Song(songTitle, songArtist, getCurrentTime());
            this.getSongs().add(this.song);
            System.out.println("The song: '" + songTitle + "' by '" + songArtist + "' has been added to the library successfully.");
        }
        else {
            System.out.println("Error - song already exists!");
        }
    }

    /**
     * Remove an individual song
     * from the library.
     *
     * Note that this does not
     * include songs that have been
     * stored in albums.
     */
    @Override
    public void removeSongFromLibrary() {
        System.out.print("Please type in the song that you want to remove, using its title: ");
        String songTitle = SCANNER.nextLine().trim();

        if(this.songExistsInLibrary(songTitle)) {
            for(int i = 0; i < this.getSongs().size(); i++) {
                if(songTitle.equalsIgnoreCase(this.getSongs().get(i).getTitle())) {
                    this.getSongs().remove(i);
                    System.out.println("Song has been removed from the library successfully.");
                }
            }
        }
        else {
            System.out.println("Error - song not found and therefore cannot be removed.");
        }
    }

    /**
     * Print all stored songs in the library
     */
    @Override
    public void viewSongsInLibrary() {
        System.out.println("Songs in library:");
        for(int i = 0; i < this.getSongs().size(); i++) {
            String songTitle = this.getSongs().get(i).getTitle();
            String songArtist = this.getSongs().get(i).getArtist();
            Timestamp timestamp = this.getSongs().get(i).getTimestamp();
            System.out.println(songTitle + " - " + songArtist + "\n\t Date Added: " + timestamp) ;
        }
    }

    /**
     * Add a new album to the library
     */
    @Override
    public void addAlbumToLibrary() {
        System.out.println("Please add the following details: " +
                "\n\t a. Album title" +
                "\n\t b. Album artist");
        String albumTitle = SCANNER.nextLine().trim();
        String albumArtist = SCANNER.nextLine().trim();

        if(!this.albumExistsInLibrary(albumTitle)) {
            this.album = new Album(albumTitle, albumArtist, getCurrentTime());
            this.getAlbums().add(this.album);
            System.out.println("The album: '" + albumTitle + "' by '"
                    + albumArtist + "' has been added successfully.");
        }
        else {
            System.out.println("Error - album already exists!");
        }
    }

    /**
     * Remove an existing album from the library
     */
    @Override
    public void removeAlbumFromLibrary() {
        System.out.print("Please type in the album that you want to remove, using its title: ");
        String albumTitle = SCANNER.nextLine().trim();

        if(this.albumExistsInLibrary(albumTitle)) {
            for(int i = 0; i < this.getAlbums().size(); i++) {
                if(albumTitle.equalsIgnoreCase(this.getAlbums().get(i).getTitle())) {
                    this.getAlbums().remove(i);
                    System.out.println("Album has been removed from the library successfully.");
                }
            }
        }
        else {
            System.out.println("Error - album not found and therefore cannot be removed.");
        }
    }

    /**
     * Check if an individual song exists
     * in the library.
     *
     * Note that this does not include any songs
     * that are stored in albums.
     *
     * @param songTitle The song to check, based on its title
     * @return The result
     */
    boolean songExistsInLibrary(String songTitle) {
        boolean songFound = false;
        for(int i = 0; i < this.getSongs().size(); i++) {
            String songTitleInLibrary = this.getSongs().get(i).getTitle();
            if(songTitle.equalsIgnoreCase(songTitleInLibrary)) {
                songFound = true;
                break;
            }
        }
        return songFound;
    }

    /**
     * Enter the album details:
     *  - album title
     *  - album artist
     *
     *  This method will be used whenever the
     *  user is required to either add or remove
     *  songs from an album, assuming that
     *  the latter indeed exists.
     */
    private static String enterAlbumDetails() {
        System.out.println("Please enter the following album details: ");
        System.out.println("\t Album title: ");
        System.out.println("\t Album artist: ");
        String albumTitle = SCANNER.nextLine().trim();
        String albumArtist = SCANNER.nextLine().trim();

        if(!albumTitle.isEmpty() && !albumArtist.isEmpty()) {
            return albumTitle;
        }
        return "Error - '" + albumTitle +  "' by '" + albumArtist + "' not found.";
    }

    /**
     * Check if an album exists, but has
     * not necessarily been added to the playlist.
     *
     * This method will also be used for whenever
     * the user wants to add or remove songs
     * from a particular album.
     *
     * @param albumTitle The album to check, based on its title
     * @return The result
     */
    boolean albumExistsInLibrary(String albumTitle) {
        boolean albumFound = false;
        for(int i = 0; i < this.getAlbums().size(); i++) {
            if(this.getAlbums().get(i).getTitle().equalsIgnoreCase(albumTitle)) {
                albumFound = true;
                break;
            }
        }
        return albumFound;
    }

    /**
     * Add a new song to a specific album
     */
    @Override
    public void addSongToAlbum() {
        System.out.println("Please add the following details: " +
                "\n\t a. Song title");
        String songTitle = SCANNER.nextLine().trim();

        if(!songExistsInAlbum(songTitle)) {
            for(int i = 0; i < this.getAlbums().size(); i++) {
                this.song = new Song(songTitle, getCurrentTime());
            }
            enterAlbumDetails();
            if(albumExistsInLibrary(this.getAlbum().getTitle())) {
                for(int i = 0; i < this.getAlbums().size(); i++) {
                    this.getAlbums().get(i).getSongs().add(this.song);
                    System.out.println("Song has been added successfully.");
                }
            }
        }
        else {
            System.out.println("Error - song already exists!");
        }
    }

    /**
     * Remove a specific song
     * from a given album
     */
    @Override
    public void removeSongFromAlbum() {
        if(this.albumExistsInLibrary(enterAlbumDetails())) {
            System.out.print("Please type in the song that you want to remove, using its title: ");
            String songTitle = SCANNER.nextLine().trim();
            if(songExistsInAlbum(songTitle)) {
                for(int i = 0; i < this.getAlbums().size(); i++) {
                    this.getAlbum().getSongs().remove(this.getSongs().get(i));
                }
            }
        }
    }

    /**
     * Check if a song exists
     * in a given album.
     *
     * This method will be used
     * as part of data validation throughout
     * the program.
     *
     * @param songTitle The song to check, based on its title
     * @return The result
     */
    private boolean songExistsInAlbum(String songTitle) {
        boolean songFound = false;
        for(int i = 0; i < this.getAlbum().getSongs().size(); i++) {
            if(songTitle.equalsIgnoreCase(this.getAlbum().getSongs().get(i).getTitle())) {
                songFound = true;
            }
        }
        return songFound;
    }


    /**
     * Print all stored albums
     * in the library.
     */
    @Override
    public void viewAlbumsInLibrary() {
        System.out.println("Albums in library:");
        System.out.println("**************************");
        for(int i = 0; i < this.getAlbums().size(); i++) {
            System.out.println(this.getAlbums().get(i).getTitle());
        }
        System.out.println("**************************");
    }

    /**
     * Print all the songs
     * from a specific album
     */
    @Override
    public void viewSongsInAlbum() {
        enterAlbumDetails();
        System.out.println("Songs in album:");
        System.out.println("**************************");
        for(int i = 0; i < this.getAlbums().size(); i++) {
            for(int j = 0; j < this.getAlbum().getSongs().size(); j++) {
                System.out.println(
                        this.getAlbums().get(i).getSongs().get(j).getTitle()
                + " (" + this.getAlbums().get(i).getSongs().get(j).formatSongDuration(
                        this.getSong().getDuration()) + ")");
            }
        }
        System.out.println("**************************");
    }
}