package com.sistem.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "kelas")
public class KelasModel {

   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="guru_id", referencedColumnName = "id")
    private GuruModel guru;

    @Column(name = "jurusan")
    private String jurusan;

    @Column (name ="tingkat")

    @Enumerated(EnumType.STRING)
    private Tingkat tingkat;

    public enum Tingkat{
        X,
        XI,
        XII
    }
    @Column(name="tahun_ajaran")
    private String tahun_ajaran;


    //=========GETTER AND SETTER==============
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Tingkat getTingkat() {
        return tingkat;
    }

    public void setTingkat(Tingkat tingkat) {
        this.tingkat = tingkat;
    }
    public String getTahun_ajaran() {
        return tahun_ajaran;
    }

    public void setTahun_ajaran(String tahun_ajaran) {
        this.tahun_ajaran = tahun_ajaran;
    }

    public GuruModel getGuru(){
        return guru;
    }
    
    public void setGuru(GuruModel guru){
        this.guru = guru;
    }

}
