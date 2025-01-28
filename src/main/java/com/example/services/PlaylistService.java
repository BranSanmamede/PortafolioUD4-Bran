package com.example.services;

import com.example.dto.PlaylistDTO;
import com.example.dto.SongDTO;
import com.example.models.Playlist;
import com.example.repositories.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> getAllPlaylists() { return playlistRepository.findAll(); }

    public Playlist getPlaylistById(Long id) { return playlistRepository.findById(id).orElse(null); }

    public Playlist createPlaylist(Playlist playlist) { return playlistRepository.save(playlist); }

    public Playlist updatePlaylist(Long id, Playlist playlist) {
        playlist.setId(id);
        return playlistRepository.save(playlist);
    }

    public void deletePlaylist(Long id) { playlistRepository.delete(getPlaylistById(id)); }

    public PlaylistDTO getPlaylistDetail(Long id) {
        PlaylistDTO dto = new PlaylistDTO();
        Playlist playlist = getPlaylistById(id);

        dto.setId(id);
        dto.setName(playlist.getName());
        dto.setDescription(playlist.getDescription());

        List<SongDTO> songDTOs = playlist.getSongs().stream().map(song ->
                        new SongDTO(song.getId(), song.getTitle(), song.getPerformer())).collect(Collectors.toList());

        dto.setSongs(songDTOs);

        return dto;
    }
}
