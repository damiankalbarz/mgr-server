package com.example.mgr_server.mapper;


import com.example.mgr_server.dto.OsobaDTO;
import com.example.mgr_server.entity.Osoba;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OsobaMapper {
    OsobaDTO toDto(Osoba osoba);
    Osoba toEntity(OsobaDTO osobaDTO);
}
