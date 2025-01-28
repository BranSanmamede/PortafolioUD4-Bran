package com.example.controllers;

import com.example.dto.PlaylistDTO;
import com.example.models.Playlist;
import com.example.services.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listas")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<Playlist> getAllPlaylist() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable Long id) {
        return playlistService.getPlaylistById(id);
    }

    @PostMapping
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    @PutMapping("/{id}")
    public Playlist updatePlaylist(@PathVariable Long id, @RequestBody Playlist playlist) { return playlistService.updatePlaylist(id, playlist); }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable Long id) { playlistService.deletePlaylist(id); }

    @GetMapping("/{id}/detalle")
    public PlaylistDTO getPlaylistDetail(@PathVariable Long id) {
        return playlistService.getPlaylistDetail(id);
    }
}
