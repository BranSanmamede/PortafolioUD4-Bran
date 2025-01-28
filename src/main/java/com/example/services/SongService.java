package com.example.services;

import com.example.dto.SongDTO;
import com.example.models.Song;
import com.example.repositories.SongRepository;
import com.example.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    public List<SongDTO> getAllSongs() { return Util.convertSongsToDTO(songRepository.findAll()); }

    public SongDTO createSong(Song song) { return Util.convertSongToDTO(songRepository.save(song)); }
}
