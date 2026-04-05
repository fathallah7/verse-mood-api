package com.fathallah.quranpulse.service;

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

    public List<Ayah> getAyahsBySurahNumber(Integer surahNumber) {
        return ayahRepository.findBySurahNumber(surahNumber);
    }

    public Ayah getAyahBySurahNumberAndAyahNumber(Integer surahNumber, Integer ayahNumber) {
        return ayahRepository.findBySurahNumberAndAyahNumber(surahNumber, ayahNumber)
                .orElseThrow(() -> new RuntimeException("Ayah not found"));
    }
}
