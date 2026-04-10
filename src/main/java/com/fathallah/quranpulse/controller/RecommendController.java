package com.fathallah.quranpulse.controller;

import com.fathallah.quranpulse.dto.ApiResponse;
import com.fathallah.quranpulse.dto.request.RecommendRequest;
import com.fathallah.quranpulse.dto.response.AyahResponse;
import com.fathallah.quranpulse.service.RecommendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/recommend")
@RequiredArgsConstructor
public class RecommendController {

    private final RecommendService recommendService;

    @PostMapping
    public ApiResponse<List<AyahResponse>> recommend(@Valid @RequestBody RecommendRequest recommendRequest) {
        return ApiResponse.success("Recommendations retrieved successfully", recommendService.recommend(recommendRequest));
    }
}
