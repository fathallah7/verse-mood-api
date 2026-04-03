package com.fathallah.quranpulse.repository;

import com.fathallah.quranpulse.entity.Ayah;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AyahRepository extends JpaRepository<Ayah, Long> {
    List<Ayah> findBySurahNumber(Integer surahNumber);

    Optional<Ayah> findBySurahNumberAndAyahNumber(Integer surahNumber, Integer ayahNumber);
}
