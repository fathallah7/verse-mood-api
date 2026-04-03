package com.fathallah.quranpulse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quran_text")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ayah {
    @Id
    @Column(name = "`index`")
    private Long index;

    @Column(name = "sura")
    private Integer surahNumber;

    @Column(name = "aya")
    private Integer ayahNumber;

    @Column(name = "text")
    private String arabicText;

    @OneToOne
    @JoinColumn(name = "`index`", referencedColumnName = "`index`",
            insertable = false, updatable = false)
    private Tafsir tafsir;
}
