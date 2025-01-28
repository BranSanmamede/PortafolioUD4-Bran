package com.example.services;

import com.example.dto.PlaylistDTO;
import com.example.exceptions.ResourceNotFoundException;
import com.example.models.Playlist;
import com.example.repositories.PlaylistRepository;
import com.example.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<PlaylistDTO> getAllPlaylists() { return Util.convertPlaylistsToDTO(playlistRepository.findAll()); }

    public PlaylistDTO getPlaylistById(Long id) { return Util.convertPlaylistToDTO(playlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Playlist no encontrada", id))); }

    public PlaylistDTO createPlaylist(Playlist playlist) { return Util.convertPlaylistToDTO(playlistRepository.save(playlist)); }

    public PlaylistDTO updatePlaylist(Long id, Playlist playlist) {
        if(!playlistRepository.existsById(id)) {
            throw new ResourceNotFoundException("Playlist no encontrada", id);
        }
        playlist.setId(id);
        return Util.convertPlaylistToDTO(playlistRepository.save(playlist));
    }

    public void deletePlaylist(Long id) { playlistRepository.delete(playlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Playlist no encontrada", id))); }

    public PlaylistDTO getPlaylistDetail(Long id) { return getPlaylistById(id); }
}
