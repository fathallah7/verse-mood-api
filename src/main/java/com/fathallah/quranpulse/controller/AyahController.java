package com.fathallah.quranpulse.controller;

import com.fathallah.quranpulse.dto.ApiResponse;
import com.fathallah.quranpulse.dto.response.AyahResponse;
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
    public ApiResponse<List<AyahResponse>> getAyahsBySurahNumber(@PathVariable Integer surahNumber) {
        return ApiResponse.success("Ayahs retrieved successfully", ayahService.getAyahsBySurahNumber(surahNumber));
    }

    @GetMapping("/{surahNumber}/{ayahNumber}")
    public ApiResponse<AyahResponse> getAyahBySurahNumberAndAyahNumber(@PathVariable Integer surahNumber, @PathVariable Integer ayahNumber) {
        return ApiResponse.success("Ayah retrieved successfully", ayahService.getAyahBySurahNumberAndAyahNumber(surahNumber, ayahNumber));
    }
}
