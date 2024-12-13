package com.example.mgr_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OsobaDTO {
    private long id;
    private String imie;
    private String nazwisko;
    private String opis;
}