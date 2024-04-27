package Assignment7.Q2;

public class Song {
    private String title;
    private String artist;
    private String album;
    private int duration;
    private int id;

    public Song(String title, String artist, String album, int duration, int id) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }


    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Song: [title='" + title + ", artist='" + artist + 
            ", album='" + album + ", duration=" + duration + ", id=" + id + ']';
    }
}