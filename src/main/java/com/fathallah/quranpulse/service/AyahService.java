package com.fathallah.quranpulse.service;

import com.fathallah.quranpulse.dto.response.AyahResponse;
import com.fathallah.quranpulse.entity.Ayah;
import com.fathallah.quranpulse.exception.AyahNotFoundException;
import com.fathallah.quranpulse.exception.SurahNotFoundException;
import com.fathallah.quranpulse.repository.AyahRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AyahService {
    private final AyahRepository ayahRepository;

    public AyahService(AyahRepository ayahRepository) {
        this.ayahRepository = ayahRepository;
    }

    public List<AyahResponse> getAyahsBySurahNumber(Integer surahNumber) {

        if (surahNumber < 1 || surahNumber > 114) {
            throw new SurahNotFoundException(surahNumber);
        }

        return ayahRepository.findBySurahNumber(surahNumber)
                .stream()
                .map(ayah -> new AyahResponse(
                        ayah.getIndex(),
                        ayah.getSurahNumber(),
                        ayah.getAyahNumber(),
                        ayah.getArabicText(),
                        ayah.getTafsir() != null ? ayah.getTafsir().getArabicText() : null
                ))
                .toList();
    }

    public AyahResponse getAyahBySurahNumberAndAyahNumber(Integer surahNumber, Integer ayahNumber) {
        Ayah ayah = ayahRepository.findBySurahNumberAndAyahNumber(surahNumber, ayahNumber)
                .orElseThrow(() -> new AyahNotFoundException(surahNumber, ayahNumber));
        return new AyahResponse(ayah.getIndex(), ayah.getSurahNumber(), ayah.getAyahNumber(), ayah.getArabicText(), ayah.getTafsir().getArabicText());
    }
}
