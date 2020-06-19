package ru.pvolok.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SongTableModel {
    private String number;
    private String name;
    private String artist;
    private String album;
    private String year;
}
