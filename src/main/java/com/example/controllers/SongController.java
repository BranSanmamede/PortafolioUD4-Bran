package com.example.controllers;

import com.example.models.Song;
import com.example.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class SongController {
    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songRepository.save(song);
    }
}
