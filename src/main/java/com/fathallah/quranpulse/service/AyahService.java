package com.fathallah.quranpulse.service;

import com.fathallah.quranpulse.dto.response.AyahResponse;
import com.fathallah.quranpulse.entity.Ayah;
import com.fathallah.quranpulse.repository.AyahRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AyahService {
    private final AyahRepository ayahRepository;

    public AyahService(AyahRepository ayahRepository) {
        this.ayahRepository = ayahRepository;
    }

    public List<AyahResponse> getAyahsBySurahNumber(Integer surahNumber) {
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
                .orElseThrow(() -> new RuntimeException("Ayah not found"));
        return new AyahResponse(ayah.getIndex(), ayah.getSurahNumber(), ayah.getAyahNumber(), ayah.getArabicText(), ayah.getTafsir().getArabicText());
    }
}
