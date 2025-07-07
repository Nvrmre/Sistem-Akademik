package com.sistem.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;


@Entity
@Table(name = "nilai")
public class NilaiModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "siswa_id", referencedColumnName="id")
    private SiswaModel siswa;

    @ManyToOne
    @JoinColumn(name = "guru_id", referencedColumnName="id")
    private GuruModel guru;

    @ManyToOne
    @JoinColumn(name = "kelas_id", referencedColumnName="id")
    private KelasModel kelas;

    @Column(name = "mapel")
    private String mapel;

    @Column(name = "nilai_tugas")
    private Double nilai_tugas;

    @Column(name ="nilai_uts")
    private Double nilai_uts;

    @Column(name = "nilai_uas")
    private Double nilai_uas;

   @ManyToOne
   @JoinColumn(name = "semester", referencedColumnName = "id")
    private SemesterModel semester;

    
}
