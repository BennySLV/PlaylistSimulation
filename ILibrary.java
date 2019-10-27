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
    void addSongToLibrary();
    void removeSongFromLibrary();
    void viewSongsInLibrary();
    void addAlbumToLibrary();
    void removeAlbumFromLibrary();
    void addSongToAlbum();
    void removeSongFromAlbum();
    void viewAlbumsInLibrary();
    void viewSongsInAlbum();
}
