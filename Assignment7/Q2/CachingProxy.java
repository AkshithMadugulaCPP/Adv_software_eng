package Assignment7.Q2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CachingProxy implements SongService {

    // Song Service
    private SongServiceImpl songService;

    // Caches for various song metadata
    private Map<Integer, Song> songCache;
    private Map<String, List<Song>> titleCache;
    private Map<String, List<Song>> albumCache;
    private Map<String, List<Song>> artistCache;

    public CachingProxy(SongServiceImpl songService) {
        this.songService = songService;
        this.songCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
        this.artistCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {

        Song song = songCache.get(songID);

        if (song == null) {

            //Query server 
            song = songService.searchById(songID);

            // Add to song cache
            songCache.put(songID, song);
        }
        return song;

    }

    @Override
    public List<Song> searchByTitle(String title) {

        List<Song> songs = titleCache.get(title);

        if (songs == null) {

            //Query server
            songs = songService.searchByTitle(title);

            // Add to song cache
            titleCache.put(title, songs);
        }
        return songs;

    }

    @Override
    public List<Song> searchByAlbum(String album) {

        List<Song> songs = albumCache.get(album);

        if (songs == null) {

            //Query server (imitate high latency)
            songs = songService.searchByAlbum(album);

            // Add to song cache
            albumCache.put(album, songs);
        }
        return songs;

    }

    @Override
    public List<Song> searchByArtist(String artist) {
        // wait to imitate high latency
        List<Song> songs = artistCache.get(artist);

        if (songs == null) {

            //Query server (imitate high latency)
            songs = songService.searchByArtist(artist);

            // Add to song cache
            artistCache.put(artist, songs);
        }
        return songs;
    }
}

