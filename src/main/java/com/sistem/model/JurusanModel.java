package com.sistem.model;

import jakarta.persistence.*;


@Entity
@Table(name = "jurusan")
public class JurusanModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;

    @ManyToOne
    @JoinColumn(name = "semester",referencedColumnName = "id")
    private SemesterModel semester;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public SemesterModel getSemester() {
        return semester;
    }

    public void setSemester(SemesterModel semester) {
        this.semester = semester;
    }

}
