package com.fathallah.quranpulse.exception;

public class AyahNotFoundException extends RuntimeException{
    public AyahNotFoundException(Integer surahNumber, Integer ayahNumber) {
        super("Ayah not found — Surah " + surahNumber + ", Ayah " + ayahNumber);
    }
}
