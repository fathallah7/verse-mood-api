package com.fathallah.quranpulse.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AyahResponse {
    private Long index;
    private Integer surahNumber;
    private Integer ayahNumber;
    private String arabicText;
    private String tafsirText;
}
