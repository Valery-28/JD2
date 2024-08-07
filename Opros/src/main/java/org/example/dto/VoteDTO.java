package org.example.dto;

import java.util.Arrays;
import java.util.Objects;

//DTO - Data Transfer Object
public class VoteDTO {
    private String artist;
    private String[] genre;
    private String about;

    public VoteDTO() {
    }

    public VoteDTO(String artist, String[] genre, String about) {
        this.artist = artist;
        this.genre = genre;
        this.about = about;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String[] getGenre() {
        return genre;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return Objects.equals(artist, voteDTO.artist) && Arrays.equals(genre, voteDTO.genre) && Objects.equals(about, voteDTO.about);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(artist, about);
        result = 31 * result + Arrays.hashCode(genre);
        return result;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "artist='" + artist + '\'' +
                ", genre=" + Arrays.toString(genre) +
                ", about='" + about + '\'' +
                '}';
    }
}
