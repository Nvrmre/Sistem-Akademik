-- SQL Database: Sistem Akademik SMK

-- ==============================
-- Tabel guru
-- ==============================
CREATE TABLE guru (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(100) NOT NULL,
    nip BIGINT UNIQUE NOT NULL,
    jenis_kelamin ENUM('L', 'P'),
    email VARCHAR(100),
    alamat TEXT
);

-- ==============================
-- Tabel jurusan
-- ==============================
CREATE TABLE jurusan (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nama_jurusan VARCHAR(100) NOT NULL UNIQUE,
    smt_id BIGINT,
    FOREIGN KEY(smt_id) REFERENCES semester(id)
);

-- ==============================
-- Tabel kelas
-- ==============================
CREATE TABLE kelas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    guru_id BIGINT,
    jurusan_id BIGINT,
    tingkat ENUM('X', 'XI', 'XII'),
    tahun_ajaran VARCHAR(20),
    FOREIGN KEY (guru_id) REFERENCES guru(id),
    FOREIGN KEY (jurusan_id) REFERENCES jurusan(id)
);

-- ==============================
-- Tabel siswa
-- ==============================
CREATE TABLE siswa (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nis BIGINT UNIQUE NOT NULL,
    nama VARCHAR(100) NOT NULL,
    kelas_id BIGINT,
    jurusan_id BIGINT,
    alamat TEXT,
    tempat_lahir VARCHAR(100),
    tanggal_lahir DATE,
    tahun_masuk DATE,
    jenis_kelamin ENUM('L', 'P'),
    FOREIGN KEY (kelas_id) REFERENCES kelas(id),
    FOREIGN KEY (jurusan_id) REFERENCES jurusan(id)
);

-- ==============================
-- Tabel semester
-- ==============================
CREATE TABLE semester (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nama ENUM('GANJIL', 'GENAP') NOT NULL,
    tahun_ajaran VARCHAR(20) NOT NULL
);

-- ==============================
-- Tabel mapel (mata pelajaran)
-- ==============================
CREATE TABLE mapel (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nama_mapel VARCHAR(100) NOT NULL,
    jenis ENUM('Umum', 'Kejuruan') NOT NULL
);

-- ==============================
-- Tabel jadwal (pengajaran)
-- ==============================
CREATE TABLE jadwal (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    kelas_id BIGINT NOT NULL,
    mapel_id BIGINT NOT NULL,
    guru_id BIGINT NOT NULL,
    hari ENUM('Senin', 'Selasa', 'Rabu', 'Kamis', 'Jumat', 'Sabtu'),
    jam_mulai TIME,
    jam_selesai TIME,
    semester_id BIGINT NOT NULL,
    FOREIGN KEY (kelas_id) REFERENCES kelas(id),
    FOREIGN KEY (mapel_id) REFERENCES mapel(id),
    FOREIGN KEY (guru_id) REFERENCES guru(id),
    FOREIGN KEY (semester_id) REFERENCES semester(id)
);

-- ==============================
-- Tabel nilai
-- ==============================
CREATE TABLE nilai (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    siswa_id BIGINT NOT NULL,
    guru_id BIGINT NOT NULL,
    kelas_id BIGINT NOT NULL,
    mapel_id BIGINT NOT NULL,
    semester_id BIGINT NOT NULL,
    nilai_tugas DOUBLE,
    nilai_uts DOUBLE,
    nilai_uas DOUBLE,
    FOREIGN KEY (siswa_id) REFERENCES siswa(id),
    FOREIGN KEY (guru_id) REFERENCES guru(id),
    FOREIGN KEY (kelas_id) REFERENCES kelas(id),
    FOREIGN KEY (mapel_id) REFERENCES mapel(id),
    FOREIGN KEY (semester_id) REFERENCES semester(id)
);

-- ==============================
-- Tabel rapor
-- ==============================
CREATE TABLE rapor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    siswa_id BIGINT NOT NULL,
    semester_id BIGINT NOT NULL,
    tanggal_cetak DATE,
    catatan TEXT,
    FOREIGN KEY (siswa_id) REFERENCES siswa(id),
    FOREIGN KEY (semester_id) REFERENCES semester(id)
);

-- ==============================
-- Tabel absensi
-- ==============================
CREATE TABLE absensi (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    siswa_id BIGINT NOT NULL,
    kelas_id BIGINT NOT NULL,
    tanggal DATE,
    keterangan ENUM('Hadir', 'Izin', 'Sakit', 'Alpa'),
    FOREIGN KEY (siswa_id) REFERENCES siswa(id),
    FOREIGN KEY (kelas_id) REFERENCES kelas(id)
);

-- ==============================
-- Tabel pkl (Praktik Kerja Lapangan)
-- ==============================
CREATE TABLE pkl (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    siswa_id BIGINT NOT NULL,
    nama_instansi VARCHAR(100),
    alamat TEXT,
    mulai DATE,
    selesai DATE,
    pembimbing_instansi VARCHAR(100),
    FOREIGN KEY (siswa_id) REFERENCES siswa(id)
);

-- ==============================
-- Tabel user (akun login)
-- ==============================
CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin', 'guru', 'siswa') NOT NULL,
    ref_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ==============================
-- Tabel pengumuman
-- ==============================
CREATE TABLE pengumuman (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    judul VARCHAR(100) NOT NULL,
    isi TEXT,
    ditujukan_kepada ENUM('siswa', 'guru', 'semua'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
