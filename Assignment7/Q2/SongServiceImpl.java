package Assignment7.Q2;

import java.util.ArrayList;
import java.util.List;

public class SongServiceImpl implements SongService {

    private List<Song> songs;

    public SongServiceImpl(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public Song searchById(Integer songID) {

        // wait to imitate high latency
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        for (Song song : songs) {
            if (song.getId()==songID) {
                return song;
            }
        }
        
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {

        // wait to imitate high latency
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> foundSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                foundSongs.add(song);
            }
        }
        return foundSongs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        
        // wait to imitate high latency
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> foundSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equals(album)) {
                foundSongs.add(song);
            }
        }
        return foundSongs;
    }

    public void displaySongs(){
        System.out.println("All Songs");
        for (Song song : songs) {
            System.out.println(song);
        }
    }

    @Override
    public List<Song> searchByArtist(String artist) {
        // wait to imitate high latency
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Song> foundSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getArtist().equals(artist)) {
                foundSongs.add(song);
            }
        }
        return foundSongs;
    }
    public static void printSongs(List<Song> songsList){
        for (Song song : songsList) {
            System.out.println(song);
        }
    }
}