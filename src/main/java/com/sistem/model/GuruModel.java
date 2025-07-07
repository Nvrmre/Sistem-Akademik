package com.sistem.model;

// import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "guru")
public class GuruModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    private String nama;
    private Long nip;
    private String jenis_kelamin;
   
    private String email;
    private String alamat;
    private String mata_pelajaran;
    // private String username;
    // private String password;
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
    public Long getNip() {
        return nip;
    }
    public void setNip(Long nip) {
        this.nip = nip;
    }
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getMata_pelajaran() {
        return mata_pelajaran;
    }
    public void setMata_pelajaran(String mata_pelajaran) {
        this.mata_pelajaran = mata_pelajaran;
    }

    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt; 
    

    

}
