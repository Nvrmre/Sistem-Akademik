package com.sistem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mapel")
public class MapelModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama_mapel;
    public Jenis jenis;
    
    public enum Jenis{
       UMUM,
       KEJURUAN
    }

  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama_mapel() {
        return nama_mapel;
    }

    public void setNama_mapel(String nama_mapel) {
        this.nama_mapel = nama_mapel;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }


}
