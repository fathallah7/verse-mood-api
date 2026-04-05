package com.fathallah.quranpulse.controller;

import com.fathallah.quranpulse.dto.ApiResponse;
import com.fathallah.quranpulse.entity.Ayah;
import com.fathallah.quranpulse.service.AyahService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ayahs")
public class AyahController {
    private final AyahService ayahService;

    public AyahController(AyahService ayahService) {
        this.ayahService = ayahService;
    }

    @GetMapping("/{surahNumber}")
    public ApiResponse<List<Ayah>> getAyahsBySurahNumber(@PathVariable Integer surahNumber) {
        return ApiResponse.success("Ayahs retrieved successfully", ayahService.getAyahsBySurahNumber(surahNumber));
    }
}
