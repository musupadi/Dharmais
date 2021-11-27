package com.ascendant.dharmais.Model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {
    @SerializedName("id_news")
    @Expose
    @Nullable
    public String id_news;

    @SerializedName("title")
    @Expose
    @Nullable
    public String title;

    @SerializedName("title_eng")
    @Expose
    @Nullable
    public String title_eng;

    @SerializedName("permalink")
    @Expose
    @Nullable
    public String permalink;

    @SerializedName("category")
    @Expose
    @Nullable
    public String category;

    @SerializedName("description")
    @Expose
    @Nullable
    public String description;

    @SerializedName("description_eng")
    @Expose
    @Nullable
    public String description_eng;

    @SerializedName("date")
    @Expose
    @Nullable
    public String date;

    @SerializedName("image")
    @Expose
    @Nullable
    public String image;

    @SerializedName("author")
    @Expose
    @Nullable
    public String author;

    @SerializedName("tag")
    @Expose
    @Nullable
    public String tag;

    @SerializedName("hits")
    @Expose
    @Nullable
    public String hits;

    @SerializedName("status")
    @Expose
    @Nullable
    public String status;

    @SerializedName("id_testimonial")
    @Expose
    @Nullable
    public String id_testimonial;

    @SerializedName("nama")
    @Expose
    @Nullable
    public String nama;


    @SerializedName("pesan")
    @Expose
    @Nullable
    public String pesan;

    @SerializedName("id_jadwalspesialis")
    @Expose
    @Nullable
    public String id_jadwalspesialis;

    @SerializedName("spesialis")
    @Expose
    @Nullable
    public String spesialis;

    @SerializedName("id_jadwaldokter")
    @Expose
    @Nullable
    public String id_jadwaldokter;

    @SerializedName("namadokter")
    @Expose
    @Nullable
    public String namadokter;

    @SerializedName("gelar")
    @Expose
    @Nullable
    public String gelar;

    @SerializedName("urut")
    @Expose
    @Nullable
    public String urut;

    @SerializedName("datepublished")
    @Expose
    @Nullable
    public String datepublished;


    @SerializedName("isijadwal")
    @Nullable
    List<DataModel> isijadwal;

    //ISI JADWAL
    @SerializedName("id_isijadwal")
    @Expose
    @Nullable
    public String id_isijadwal;


    @SerializedName("lokasi")
    @Expose
    @Nullable
    public String lokasi;

    @SerializedName("jam")
    @Expose
    @Nullable
    public String jam;

    @SerializedName("hari")
    @Expose
    @Nullable
    public String hari;

    @Nullable
    public String getId_news() {
        return id_news;
    }

    public void setId_news(@Nullable String id_news) {
        this.id_news = id_news;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getTitle_eng() {
        return title_eng;
    }

    public void setTitle_eng(@Nullable String title_eng) {
        this.title_eng = title_eng;
    }

    @Nullable
    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(@Nullable String permalink) {
        this.permalink = permalink;
    }

    @Nullable
    public String getCategory() {
        return category;
    }

    public void setCategory(@Nullable String category) {
        this.category = category;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Nullable
    public String getDescription_eng() {
        return description_eng;
    }

    public void setDescription_eng(@Nullable String description_eng) {
        this.description_eng = description_eng;
    }

    @Nullable
    public String getDate() {
        return date;
    }

    public void setDate(@Nullable String date) {
        this.date = date;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage(@Nullable String image) {
        this.image = image;
    }

    @Nullable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@Nullable String author) {
        this.author = author;
    }

    @Nullable
    public String getTag() {
        return tag;
    }

    public void setTag(@Nullable String tag) {
        this.tag = tag;
    }

    @Nullable
    public String getHits() {
        return hits;
    }

    public void setHits(@Nullable String hits) {
        this.hits = hits;
    }

    @Nullable
    public String getStatus() {
        return status;
    }

    public void setStatus(@Nullable String status) {
        this.status = status;
    }

    @Nullable
    public String getId_testimonial() {
        return id_testimonial;
    }

    public void setId_testimonial(@Nullable String id_testimonial) {
        this.id_testimonial = id_testimonial;
    }

    @Nullable
    public String getNama() {
        return nama;
    }

    public void setNama(@Nullable String nama) {
        this.nama = nama;
    }

    @Nullable
    public String getPesan() {
        return pesan;
    }

    public void setPesan(@Nullable String pesan) {
        this.pesan = pesan;
    }

    @Nullable
    public String getId_jadwalspesialis() {
        return id_jadwalspesialis;
    }

    public void setId_jadwalspesialis(@Nullable String id_jadwalspesialis) {
        this.id_jadwalspesialis = id_jadwalspesialis;
    }

    @Nullable
    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(@Nullable String spesialis) {
        this.spesialis = spesialis;
    }

    @Nullable
    public String getId_jadwaldokter() {
        return id_jadwaldokter;
    }

    public void setId_jadwaldokter(@Nullable String id_jadwaldokter) {
        this.id_jadwaldokter = id_jadwaldokter;
    }

    @Nullable
    public String getNamadokter() {
        return namadokter;
    }

    public void setNamadokter(@Nullable String namadokter) {
        this.namadokter = namadokter;
    }

    @Nullable
    public String getGelar() {
        return gelar;
    }

    public void setGelar(@Nullable String gelar) {
        this.gelar = gelar;
    }

    @Nullable
    public String getUrut() {
        return urut;
    }

    public void setUrut(@Nullable String urut) {
        this.urut = urut;
    }

    @Nullable
    public String getDatepublished() {
        return datepublished;
    }

    public void setDatepublished(@Nullable String datepublished) {
        this.datepublished = datepublished;
    }

    @Nullable
    public List<DataModel> getIsijadwal() {
        return isijadwal;
    }

    public void setIsijadwal(@Nullable List<DataModel> isijadwal) {
        this.isijadwal = isijadwal;
    }

    @Nullable
    public String getId_isijadwal() {
        return id_isijadwal;
    }

    public void setId_isijadwal(@Nullable String id_isijadwal) {
        this.id_isijadwal = id_isijadwal;
    }

    @Nullable
    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(@Nullable String lokasi) {
        this.lokasi = lokasi;
    }

    @Nullable
    public String getJam() {
        return jam;
    }

    public void setJam(@Nullable String jam) {
        this.jam = jam;
    }

    @Nullable
    public String getHari() {
        return hari;
    }

    public void setHari(@Nullable String hari) {
        this.hari = hari;
    }
}
