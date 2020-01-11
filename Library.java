package Section6.LinkedListChallenge;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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
    private List<Song> songs;
    private List<Album> albums;
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
    Library(List<Song> songs, List<Album> albums) {
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
    private List<Song> getSongs() {
        return songs;
    }

    /**
     * Get the current list of all albums
     * stored in the library
     *
     * @return The current list of albums
     */
    private List<Album> getAlbums() {
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
                "\n\t a. Song duration (in seconds)" +
                "\n\t b. Song title" +
                "\n\t c. Song artist");
        int songDuration = SCANNER.nextInt();
        SCANNER.nextLine(); // Eliminates the "\n" returned before the next nextLine() method call
        String songTitle = SCANNER.nextLine().trim();
        String songArtist = SCANNER.nextLine().trim();

        if(!songExistsInLibrary(songTitle)) {
            this.song = new Song(songTitle, songDuration, songArtist, getCurrentTime());
            this.getSongs().add(this.song);
            if(this.getSongs().contains(this.getSong())) {
                System.out.println("The song: '" + songTitle + "' by '" + songArtist +
                        "' has been added to the library successfully.");
            }
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
            String duration = this.getSongs().get(i).formatSongDuration(this.getSongs().get(i).getDuration());
            Timestamp timestamp = this.getSongs().get(i).getTimestamp();
            System.out.println(songTitle + "\n\t Artist: " + songArtist +
                    "\n\t Duration: "  + duration +
                    "\n\t Date Added: " + timestamp + "\n") ;
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
            if(this.getAlbums().contains(this.album)) {
                System.out.println("The album: '" + albumTitle + "' by '"
                        + albumArtist + "' has been added successfully.");
            }
            else {
                System.out.println("Error - album could not be added.");
            }
        }
        else {
            System.out.println("Error - album already exists.");
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
                "\n\t a. Song duration (in seconds)" +
                "\n\t b. Song title");
        int songDuration = SCANNER.nextInt();
        SCANNER.nextLine(); // Eliminates the "\n" returned before the next nextLine() method call
        String songTitle = SCANNER.nextLine().trim();

        if(!songExistsInAlbum(songTitle)) {
            this.song = new Song(songTitle, songDuration, getCurrentTime());
            if(albumExistsInLibrary(enterAlbumDetails())) {
                this.getAlbum().getSongs().add(this.song);
                if(this.getAlbum().getSongs().contains(this.song)) {
                    System.out.println("Song has been added successfully to the album.");
                }
                else {
                    System.out.println("Error - song could not be added to the album.");
                }
            }
            else {
                System.out.println("Error - album already exists.");
            }
        }
        else {
            System.out.println("Error - song already exists.");
        }
    }

    /**
     * Remove a specific song
     * from a given album
     */
    @Override
    public void removeSongFromAlbum() {
        if(albumExistsInLibrary(enterAlbumDetails())) {
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
                break;
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
            System.out.println(this.getAlbums().get(i).getTitle() +
                    " (" + this.getAlbums().get(i).formatAlbumDuration(
                            this.getAlbums().get(i).calculateAlbumDuration()) + ")");
        }
        System.out.println("**************************");
    }

    /**
     * Print all the songs
     * from a specific album
     */
    @Override
    public void viewSongsInAlbum() {
        if(albumExistsInLibrary(enterAlbumDetails())) {
            System.out.println("Songs in album:");
            System.out.println("**************************");
            for(int i = 0; i < this.getAlbum().getSongs().size(); i++) {
                System.out.println(this.getAlbum().getSongs().get(i).getTitle());
            }
            System.out.println("**************************");
        }
    }
}