package com.example.services;

import com.example.dto.PlaylistDTO;
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

    public Playlist getPlaylistById(Long id) { return playlistRepository.findById(id).orElse(null); }

    public PlaylistDTO createPlaylist(Playlist playlist) { return Util.convertPlaylistToDTO(playlistRepository.save(playlist)); }

    public PlaylistDTO updatePlaylist(Long id, Playlist playlist) {
        playlist.setId(id);
        return Util.convertPlaylistToDTO(playlistRepository.save(playlist));
    }

    public void deletePlaylist(Long id) { playlistRepository.delete(getPlaylistById(id)); }

    public PlaylistDTO getPlaylistDetail(Long id) { return Util.convertPlaylistToDTO(getPlaylistById(id)); }
}
