package com.example.controllers;

import com.example.models.Playlist;
import com.example.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class PlaylistController {
    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping
    public List<Playlist> getAllPlaylist() {
        return playlistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) {
        playlist.setId(id);
        return playlistRepository.save(playlist);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) {
        playlistRepository.deleteById(id);
    }

    @GetMapping("/{id}/detalle")
    public Playlist getPlaylistDetail(@PathVariable Long id) {
        return getPlaylistById(id);
    }
}
