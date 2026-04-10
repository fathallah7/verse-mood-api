package com.fathallah.quranpulse.exception;

public class SurahNotFoundException extends RuntimeException{
    public SurahNotFoundException(Integer surahNumber) {
        super("Surah not found — Surah " + surahNumber);
    }
}
