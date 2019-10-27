package Section6.LinkedListChallenge;

/**
 * Java Programming Masterclass for Software Developers
 *
 * Section 6: Arrays, Java in-built lists, autoboxing
 * and unboxing
 *
 * This interface will provide the required
 * functionality for the playlist.
 *
 * @author Ben Silveston
 */
public interface IPlaylist {
    void addSongToPlaylist();
    void removeSongFromPlaylist();
    void addAlbumToPlaylist();
    void removeAlbumFromPlaylist();
    void play();
    void stop();
    void skipForwards();
    void skipBackwards();
    boolean isPlaying(String songTitle);
    void searchForSong();
    void searchForAlbum();
    void showPlaylist();
}