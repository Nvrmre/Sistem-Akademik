package com.sistem.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kelas")
public class KelasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="guru_id")
    private Long guru_id;

    @Column(name = "jurusan")
    private String jurusan;

    @Column (name ="tingkat")

    @Enumerated(EnumType.STRING)
    private tingkat tingkat;

    public enum tingkat{
        X,
        XI,
        XII
    }
//=========GETTER AND SETTER==============
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGuru_id() {
        return guru_id;
    }

    public void setGuru_id(Long guru_id) {
        this.guru_id = guru_id;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public tingkat getTingkat() {
        return tingkat;
    }

    public void setTingkat(tingkat tingkat) {
        this.tingkat = tingkat;
    }


    

}
