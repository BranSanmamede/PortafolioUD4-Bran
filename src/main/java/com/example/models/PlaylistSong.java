package com.example.models;

import jakarta.persistence.*;

@Entity
@Table(name = "listacancion")
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "listaid", referencedColumnName = "id")
    private Playlist playlist;

    @ManyToOne
    @JoinColumn(name = "cancionid", referencedColumnName = "id")
    private Song song;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
