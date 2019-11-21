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
    boolean addInChronologicalOrder(Song song);

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
    boolean addInChronologicalOrder(Album album);

    /**
     * Add an individual song to the playlist
     *
     * This methods gives the user the option
     * to either add specific songs from an album
     * or directly from the library.
     */
    void addSongToPlaylist();

    /**
     * Remove an individual song from the playlist
     */
    void removeSongFromPlaylist();

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
    void addAlbumToPlaylist();

    /**
     * Remove an individual song from the playlist
     */
    void removeAlbumFromPlaylist();

    /**
     * Play a specific song
     * from the playlist
     */
    void play();

    /**
     * Stop the current song that
     * is being played
     */
    void stop();

    /**
     * Skip to the next song
     * in the playlist
     */
    void skipForwards();

    /**
     * Skip to the previous song
     * in the playlist
     */
    void skipBackwards();

    /**
     * Check to see if the particular
     * song in the playlist is currently playing.
     *
     * This method will determine
     * the implementation for other relevant playlist
     * methods (i.e. stopping, repeating or
     * skipping forwards/backwards between songs).
     *
     * @return The result
     */
    boolean isPlaying();

    /**
     * Search for a given song
     * in the playlist
     */
    void searchForSong();

    /**
     * Search for a given album
     * in the playlist.
     */
    void searchForAlbum();

    /**
     * Print the playlist containing
     * all stored songs.
     */
    void showPlaylistOfSongs();

    /**
     * Print the playlist containing
     * all stored albums.
     */
    void showPlaylistOfAlbums();
}