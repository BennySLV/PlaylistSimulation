package Section6.LinkedListChallenge;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built lists, autoboxing
 * and unboxing
 *
 * This interface will implement all the standard and required
 * functionality for the library class
 * within the playlist application.
 *
 * @author Ben Silveston
 */
public interface ILibrary {
    /**
     * Add an individual song
     * to the library.
     *
     * Note that this method does not
     * allow songs from stored albums
     * to be added.
     */
    void addSongToLibrary();

    /**
     * Remove an individual song
     * from the library.
     *
     * Note that this does not
     * include songs that have been
     * stored in albums.
     */
    void removeSongFromLibrary();

    /**
     * Print all stored songs in the library
     */
    void viewSongsInLibrary();

    /**
     * Add a new album to the library
     */
    void addAlbumToLibrary();

    /**
     * Remove an existing album from the library
     */
    void removeAlbumFromLibrary();

    /**
     * Add a new song to a specific album
     */
    void addSongToAlbum();

    /**
     * Remove a specific song
     * from a given album
     */
    void removeSongFromAlbum();

    /**
     * Print all stored albums
     * in the library.
     */
    void viewAlbumsInLibrary();

    /**
     * Print all the songs
     * from a specific album
     */
    void viewSongsInAlbum();
}