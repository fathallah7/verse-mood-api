package com.fathallah.quranpulse.service;

import com.fathallah.quranpulse.dto.request.RecommendRequest;
import com.fathallah.quranpulse.dto.response.AyahResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendService {

    public List<AyahResponse> recommend(RecommendRequest request) {
        return List.of();
    }
}
