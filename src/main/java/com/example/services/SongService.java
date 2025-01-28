package com.example.services;

import com.example.models.Song;
import com.example.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<Song> getAllSongs() { return songRepository.findAll(); }

    public Song createSong(Song song) { return songRepository.save(song); }
}
