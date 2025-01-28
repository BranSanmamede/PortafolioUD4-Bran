package com.example.controllers;

import com.example.dto.SongDTO;
import com.example.models.Song;
import com.example.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public List<SongDTO> getAllSongs() { return songService.getAllSongs(); }

    @PostMapping
    public SongDTO createSong(@RequestBody Song song) {
        return songService.createSong(song);
    }
}
