package Assignment7.Q2;

import java.util.ArrayList;
import java.util.List;

public class DriverProxy {

    public static void main(String[] args) {

        // Create some songs
        List<Song> songs = new ArrayList<>();
        Song song1 = new Song("Title 1", "Artist 1", "Album 1", 111, 1);
        Song song2 = new Song("Title 2", "Artist 1", "Album 1", 222, 2);
        Song song3 = new Song("Title 3", "Artist 2", "Album 2", 333, 3);
        Song song4 = new Song("Title 4", "Artist 3", "Album 3", 444, 4);
        Song song5 = new Song("Title 5", "Artist 3", "Album 4", 555, 5);
        Song song6 = new Song("Title 6", "Artist 4", "Album 5", 111, 6);
        Song song7 = new Song("Title 7", "Artist 5", "Album 5", 222, 7);
        Song song8 = new Song("Title 8", "Artist 5", "Album 6", 333, 8);
        Song song9 = new Song("Title 9", "Artist 5", "Album 7", 444, 9);
        Song song10 = new Song("Title 10", "Artist 5", "Album 8", 555, 10);
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song9);
        songs.add(song10);

        // Create a real song service
        SongServiceImpl songService = new SongServiceImpl(songs);

        songService.displaySongs();
        System.out.println();

        // Create a song service proxy
        CachingProxy cachingProxy = new CachingProxy(songService);
        System.out.println("-------------------------Searching by id :- 6-------------------------");
        System.out.println(songService.searchById(6));
        System.out.println("-------------------------Seaching by Title:- Title 4-------------------------");
        SongServiceImpl.printSongs(songService.searchByTitle("Title 4"));
        System.out.println("-------------------------Searching by Album :- Album 5-------------------------");
        SongServiceImpl.printSongs(songService.searchByAlbum("Album 5"));
        System.out.println("-------------------------Searching by Artist :- Artist 5-------------------------");
        SongServiceImpl.printSongs(songService.searchByArtist("Artist 5"));
        System.out.println();
        //
        // Part A:
        // Measure the time it takes to search for songs without the proxy
        //
        System.out.println("--------------------------------------------------------");
        System.out.println("Starting search without proxy");
        long startTime = System.currentTimeMillis();

        // Search for songs by ID, Title, Album, Artist
        songService.searchById(5);
        songService.searchByTitle("Title 2");
        songService.searchByAlbum("Album 2");
        songService.searchByArtist("Artist 3");

        long endTime = System.currentTimeMillis();
        System.out.println("Time without proxy: " + (endTime - startTime) + " ms");
        System.out.println("--------------------------------------------------------");
        //
        // Part B:
        // Measure the time it takes to search for songs with the caching proxy
        // BEFORE any songs have been cached
        //
        System.out.println("Starting search with caching but before cached");
        startTime = System.currentTimeMillis();

        // Search for songs by ID, Title, Album, Artist
        cachingProxy.searchById(5);
        cachingProxy.searchByTitle("Title 2");
        cachingProxy.searchByAlbum("Album 2");
        cachingProxy.searchByArtist("Artist 3");

        endTime = System.currentTimeMillis();
        System.out.println("Time with proxy before caching: " + (endTime - startTime) + " ms");
        System.out.println("-----------------------------------------------------------------");
        //
        // Part C:
        // Measure the time it takes to search for songs with the caching proxy
        // AFTER all songs have been cached
        //
        System.out.println("Starting search with caching after all songs cached");
        startTime = System.currentTimeMillis();

        // Search for songs by ID, Title, Album, Artist
        cachingProxy.searchById(5);
        cachingProxy.searchByTitle("Title 2");
        cachingProxy.searchByAlbum("Album 2");
        cachingProxy.searchByArtist("Artist 3");

        long endTimeProxy = System.currentTimeMillis();
        System.out.println("Time with proxy after caching: " + (endTimeProxy - startTime) + " ms");
    }
}
