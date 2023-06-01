package jpadepth.entity.manytomany.songs;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Song {

    @EmbeddedId
    private SongId id;

    private int duration;
    private String genre;
    private LocalDateTime releaseDate;
    int rating;
    private String downloadURL;

    protected Song(){}

    public Song(SongId id, int duration, String genre, LocalDateTime releaseDate, int rating, String downloadURL) {
        this.id = id;
        this.duration = duration;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.downloadURL = downloadURL;
    }

    public SongId getId() {
        return id;
    }

    public void setId(SongId id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }
}
