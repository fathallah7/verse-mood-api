package com.fathallah.quranpulse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quran-tafsit-muyassar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tafsir {
    @Id
    @Column(name = "`index`")
    private Long index;

    @Column(name = "sura")
    private Integer surahNumber;

    @Column(name = "aya")
    private Integer ayahNumber;

    @Column(name = "text")
    private String arabicText;

    @OneToOne(mappedBy = "tafsir")
    private Ayah ayah;
}
