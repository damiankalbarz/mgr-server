package com.example.mgr_server.service;



import com.example.mgr_server.dto.OsobaDTO;
import com.example.mgr_server.entity.Osoba;
import com.example.mgr_server.mapper.OsobaMapper;
import com.example.mgr_server.repository.OsobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsobaService {


    private final OsobaRepository osobaRepository;
    private final OsobaMapper osobaMapper;

    @Autowired
    public OsobaService(OsobaRepository osobaRepository, OsobaMapper osobaMapper) {
        this.osobaRepository = osobaRepository;
        this.osobaMapper = osobaMapper;
    }


    public List<OsobaDTO> findAll() {
        return osobaRepository.findAll().stream()
                .map(osobaMapper::toDto)
                .toList();
    }

    public Optional<OsobaDTO> findById(Long id) {
        return osobaRepository.findById(id)
                .map(osobaMapper::toDto);
    }

    public OsobaDTO save(OsobaDTO osobaDTO) {
        Osoba osoba = osobaMapper.toEntity(osobaDTO);
        return osobaMapper.toDto(osobaRepository.save(osoba));
    }

    public Optional<OsobaDTO> update(Long id, OsobaDTO osobaDTO) {

        Osoba osoba = osobaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Osoba not found with ID: " + id));

        if (osobaDTO.getImie() != null) {
            osoba.setImie(osobaDTO.getImie());
        }
        if (osobaDTO.getNazwisko() != null) {
            osoba.setNazwisko(osobaDTO.getNazwisko());
        }
        if (osobaDTO.getOpis() != null) {
            osoba.setOpis(osobaDTO.getOpis());
        }

        Osoba updatedOsoba = osobaRepository.save(osoba);

        return Optional.of(osobaMapper.toDto(updatedOsoba));

    }

    public void deleteById(Long id) {
        osobaRepository.deleteById(id);
    }
}