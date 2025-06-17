package com.sistem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "siswa")
@Data
public class SiswaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nis")
    private Long nis;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "jurusan")
    private String jurusan;

    @Column(name = "tempat_lahir")
    private String tempatLahir;

    @Column(name = "tanggal_lahir")
    private LocalDate tanggalLahir;

    @Column (name = "tahun_masuk")
    private LocalDate tahunMasuk;

    @Column (name = "jenis_kelamin")
    @Enumerated(EnumType.STRING)
    private JenisKelamin jenisKelamin;

    public enum JenisKelamin {
        L, P
    }
}
