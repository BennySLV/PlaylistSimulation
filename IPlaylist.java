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
    void addInChronologicalOrder(Song song);

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
    void addInChronologicalOrder(Album album);

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
     * Play the playlist
     * from start to finish.
     *
     * The first song in the
     * playlist will therefore be played
     * first.
     */
    void play();

    /**
     * Repeat the specific song
     * that is already playing
     * in the playlist.
     *
     * In other words the song
     * will play at least twice
     * consecutively.
     */
    void repeat();

    /**
     * Skip to the next song
     * in the playlist.
     */
    void skipForwards();

    /**
     * Skip to the previous song
     * in the playlist.
     */
    void skipBackwards();

    /**
     * Search for an individual song
     * in the playlist.
     */
    void searchForSong();

    /**
     * Search for an individual album
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