package com.example.utils;

import com.example.dto.PlaylistDTO;
import com.example.dto.SongDTO;
import com.example.models.Playlist;
import com.example.models.Song;

import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static PlaylistDTO convertPlaylistToDTO(Playlist playlist) {
        PlaylistDTO dto = new PlaylistDTO();
        dto.setId(playlist.getId());
        dto.setName(playlist.getName());
        dto.setDescription(playlist.getDescription());
        if(playlist.getSongs() != null) {
            dto.setSongs(convertSongsToDTO(playlist.getSongs()));
        }
        return dto;
    }

    public static SongDTO convertSongToDTO(Song song) {
        SongDTO dto = new SongDTO();
        dto.setId(song.getId());
        dto.setTitle(song.getTitle());
        dto.setArtist(song.getPerformer());
        return dto;
    }

    public static List<PlaylistDTO> convertPlaylistsToDTO(List<Playlist> playlists) {
        return playlists.stream().map(Util::convertPlaylistToDTO).collect(Collectors.toList());
    }

    public static List<SongDTO> convertSongsToDTO(List<Song> songs) {
        return songs.stream().map(Util::convertSongToDTO).collect(Collectors.toList());
    }
}
