package com.sistem.model;

import jakarta.persistence.*;


@Entity
@Table(name = "semester")
public class SemesterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private jenisSemester semester;
    
    private String tahun_ajaran;
    public enum jenisSemester{
        GANJIL,
        GENAP
    }

     public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public jenisSemester getSemester() {
        return semester;
    }
    public void setSemester(jenisSemester semester) {
        this.semester = semester;
    }
    public String getTahun_ajaran() {
        return tahun_ajaran;
    }
    public void setTahun_ajaran(String tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }
}
