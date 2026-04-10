package com.fathallah.quranpulse.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class RecommendRequest {
    @NotBlank(message = "Mood is required")
    @Size(max = 255, message = "Mood must be less than 255 characters")
    private String mood;
}
