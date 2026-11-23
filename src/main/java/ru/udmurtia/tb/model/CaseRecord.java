package ru.udmurtia.tb.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "case_record")
public class CaseRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private AppUser doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @Column(name = "report_date", nullable = false)
    private LocalDate reportDate;

    // Общие
    private int totalOnDu;
    private int newCases;
    private int contactsCount;

    // Группы ГДУ
    @Column(name = "gdu_i")
    private int gduI;

    @Column(name = "gdu_iia")
    private int gduIIa;

    @Column(name = "gdu_iib")
    private int gduIIb;

    @Column(name = "gdu_iii")
    private int gduIII;

    // Лечение
    private int ambTotal;
    private int ambVideo;
    private int statTotal;
    private int dayTotal;
    private int interrupted;

    // Режимы ХТ (Амбулаторно)
    @Column(name = "amb_lch_long")
    private int ambLchLong;
    @Column(name = "amb_lch_short")
    private int ambLchShort;
    @Column(name = "amb_mlu_long")
    private int ambMluLong;
    @Column(name = "amb_mlu_short_6m")
    private int ambMluShort6m;
    @Column(name = "amb_mlu_short_9m")
    private int ambMluShort9m;
    @Column(name = "amb_preshlu_long")
    private int ambPreshluLong;
    @Column(name = "amb_preshlu_short_6m")
    private int ambPreshluShort6m;
    @Column(name = "amb_preshlu_short_9m")
    private int ambPreshluShort9m;
    @Column(name = "amb_shlu")
    private int ambShlu;

    // Режимы ХТ (Стационар)
    @Column(name = "stat_lch_long")
    private int statLchLong;
    @Column(name = "stat_lch_short")
    private int statLchShort;
    @Column(name = "stat_mlu_long")
    private int statMluLong;
    @Column(name = "stat_mlu_short_6m")
    private int statMluShort6m;
    @Column(name = "stat_mlu_short_9m")
    private int statMluShort9m;
    @Column(name = "stat_preshlu_long")
    private int statPreshluLong;
    @Column(name = "stat_preshlu_short_6m")
    private int statPreshluShort6m;
    @Column(name = "stat_preshlu_short_9m")
    private int statPreshluShort9m;
    @Column(name = "stat_shlu")
    private int statShlu;

    // Режимы ХТ (Дневной стационар)
    @Column(name = "day_lch_long")
    private int dayLchLong;
    @Column(name = "day_lch_short")
    private int dayLchShort;
    @Column(name = "day_mlu_long")
    private int dayMluLong;
    @Column(name = "day_mlu_short_6m")
    private int dayMluShort6m;
    @Column(name = "day_mlu_short_9m")
    private int dayMluShort9m;
    @Column(name = "day_preshlu_long")
    private int dayPreshluLong;
    @Column(name = "day_preshlu_short_6m")
    private int dayPreshluShort6m;
    @Column(name = "day_preshlu_short_9m")
    private int dayPreshluShort9m;
    @Column(name = "day_shlu")
    private int dayShlu;

    // Режимы ХТ (Видеоконтроль)
    @Column(name = "video_lch_long")
    private int videoLchLong;
    @Column(name = "video_lch_short")
    private int videoLchShort;
    @Column(name = "video_mlu_long")
    private int videoMluLong;
    @Column(name = "video_mlu_short_6m")
    private int videoMluShort6m;
    @Column(name = "video_mlu_short_9m")
    private int videoMluShort9m;
    @Column(name = "video_preshlu_long")
    private int videoPreshluLong;
    @Column(name = "video_preshlu_short_6m")
    private int videoPreshluShort6m;
    @Column(name = "video_preshlu_short_9m")
    private int videoPreshluShort9m;
    @Column(name = "video_shlu")
    private int videoShlu;

    // Пустой конструктор для JPA
    public CaseRecord() {}

    public Long getId() {
        return id;
    }

    public AppUser getDoctor() {
        return doctor;
    }

    public void setDoctor(AppUser doctor) {
        this.doctor = doctor;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public int getTotalOnDu() {
        return totalOnDu;
    }

    public void setTotalOnDu(int totalOnDu) {
        this.totalOnDu = totalOnDu;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public int getContactsCount() {
        return contactsCount;
    }

    public void setContactsCount(int contactsCount) {
        this.contactsCount = contactsCount;
    }

    public int getGduI() {
        return gduI;
    }

    public void setGduI(int gduI) {
        this.gduI = gduI;
    }

    public int getGduIIa() {
        return gduIIa;
    }

    public void setGduIIa(int gduIIa) {
        this.gduIIa = gduIIa;
    }

    public int getGduIIb() {
        return gduIIb;
    }

    public void setGduIIb(int gduIIb) {
        this.gduIIb = gduIIb;
    }

    public int getGduIII() {
        return gduIII;
    }

    public void setGduIII(int gduIII) {
        this.gduIII = gduIII;
    }

    public int getAmbTotal() {
        return ambTotal;
    }

    public void setAmbTotal(int ambTotal) {
        this.ambTotal = ambTotal;
    }

    public int getAmbVideo() {
        return ambVideo;
    }

    public void setAmbVideo(int ambVideo) {
        this.ambVideo = ambVideo;
    }

    public int getStatTotal() {
        return statTotal;
    }

    public void setStatTotal(int statTotal) {
        this.statTotal = statTotal;
    }

    public int getDayTotal() {
        return dayTotal;
    }

    public void setDayTotal(int dayTotal) {
        this.dayTotal = dayTotal;
    }

    public int getInterrupted() {
        return interrupted;
    }

    public void setInterrupted(int interrupted) {
        this.interrupted = interrupted;
    }

    public int getAmbLchLong() {
        return ambLchLong;
    }

    public void setAmbLchLong(int ambLchLong) {
        this.ambLchLong = ambLchLong;
    }

    public int getAmbLchShort() {
        return ambLchShort;
    }

    public void setAmbLchShort(int ambLchShort) {
        this.ambLchShort = ambLchShort;
    }

    public int getAmbMluLong() {
        return ambMluLong;
    }

    public void setAmbMluLong(int ambMluLong) {
        this.ambMluLong = ambMluLong;
    }

    public int getAmbMluShort6m() {
        return ambMluShort6m;
    }

    public void setAmbMluShort6m(int ambMluShort6m) {
        this.ambMluShort6m = ambMluShort6m;
    }

    public int getAmbMluShort9m() {
        return ambMluShort9m;
    }

    public void setAmbMluShort9m(int ambMluShort9m) {
        this.ambMluShort9m = ambMluShort9m;
    }

    public int getAmbPreshluLong() {
        return ambPreshluLong;
    }

    public void setAmbPreshluLong(int ambPreshluLong) {
        this.ambPreshluLong = ambPreshluLong;
    }

    public int getAmbPreshluShort6m() {
        return ambPreshluShort6m;
    }

    public void setAmbPreshluShort6m(int ambPreshluShort6m) {
        this.ambPreshluShort6m = ambPreshluShort6m;
    }

    public int getAmbPreshluShort9m() {
        return ambPreshluShort9m;
    }

    public void setAmbPreshluShort9m(int ambPreshluShort9m) {
        this.ambPreshluShort9m = ambPreshluShort9m;
    }

    public int getAmbShlu() {
        return ambShlu;
    }

    public void setAmbShlu(int ambShlu) {
        this.ambShlu = ambShlu;
    }

    public int getStatLchLong() {
        return statLchLong;
    }

    public void setStatLchLong(int statLchLong) {
        this.statLchLong = statLchLong;
    }

    public int getStatLchShort() {
        return statLchShort;
    }

    public void setStatLchShort(int statLchShort) {
        this.statLchShort = statLchShort;
    }

    public int getStatMluLong() {
        return statMluLong;
    }

    public void setStatMluLong(int statMluLong) {
        this.statMluLong = statMluLong;
    }

    public int getStatMluShort6m() {
        return statMluShort6m;
    }

    public void setStatMluShort6m(int statMluShort6m) {
        this.statMluShort6m = statMluShort6m;
    }

    public int getStatMluShort9m() {
        return statMluShort9m;
    }

    public void setStatMluShort9m(int statMluShort9m) {
        this.statMluShort9m = statMluShort9m;
    }

    public int getStatPreshluLong() {
        return statPreshluLong;
    }

    public void setStatPreshluLong(int statPreshluLong) {
        this.statPreshluLong = statPreshluLong;
    }

    public int getStatPreshluShort6m() {
        return statPreshluShort6m;
    }

    public void setStatPreshluShort6m(int statPreshluShort6m) {
        this.statPreshluShort6m = statPreshluShort6m;
    }

    public int getStatPreshluShort9m() {
        return statPreshluShort9m;
    }

    public void setStatPreshluShort9m(int statPreshluShort9m) {
        this.statPreshluShort9m = statPreshluShort9m;
    }

    public int getStatShlu() {
        return statShlu;
    }

    public void setStatShlu(int statShlu) {
        this.statShlu = statShlu;
    }

    public int getDayLchLong() {
        return dayLchLong;
    }

    public void setDayLchLong(int dayLchLong) {
        this.dayLchLong = dayLchLong;
    }

    public int getDayLchShort() {
        return dayLchShort;
    }

    public void setDayLchShort(int dayLchShort) {
        this.dayLchShort = dayLchShort;
    }

    public int getDayMluLong() {
        return dayMluLong;
    }

    public void setDayMluLong(int dayMluLong) {
        this.dayMluLong = dayMluLong;
    }

    public int getDayMluShort6m() {
        return dayMluShort6m;
    }

    public void setDayMluShort6m(int dayMluShort6m) {
        this.dayMluShort6m = dayMluShort6m;
    }

    public int getDayMluShort9m() {
        return dayMluShort9m;
    }

    public void setDayMluShort9m(int dayMluShort9m) {
        this.dayMluShort9m = dayMluShort9m;
    }

    public int getDayPreshluLong() {
        return dayPreshluLong;
    }

    public void setDayPreshluLong(int dayPreshluLong) {
        this.dayPreshluLong = dayPreshluLong;
    }

    public int getDayPreshluShort6m() {
        return dayPreshluShort6m;
    }

    public void setDayPreshluShort6m(int dayPreshluShort6m) {
        this.dayPreshluShort6m = dayPreshluShort6m;
    }

    public int getDayPreshluShort9m() {
        return dayPreshluShort9m;
    }

    public void setDayPreshluShort9m(int dayPreshluShort9m) {
        this.dayPreshluShort9m = dayPreshluShort9m;
    }

    public int getDayShlu() {
        return dayShlu;
    }

    public void setDayShlu(int dayShlu) {
        this.dayShlu = dayShlu;
    }

    public int getVideoLchLong() {
        return videoLchLong;
    }

    public void setVideoLchLong(int videoLchLong) {
        this.videoLchLong = videoLchLong;
    }

    public int getVideoLchShort() {
        return videoLchShort;
    }

    public void setVideoLchShort(int videoLchShort) {
        this.videoLchShort = videoLchShort;
    }

    public int getVideoMluLong() {
        return videoMluLong;
    }

    public void setVideoMluLong(int videoMluLong) {
        this.videoMluLong = videoMluLong;
    }

    public int getVideoMluShort6m() {
        return videoMluShort6m;
    }

    public void setVideoMluShort6m(int videoMluShort6m) {
        this.videoMluShort6m = videoMluShort6m;
    }

    public int getVideoMluShort9m() {
        return videoMluShort9m;
    }

    public void setVideoMluShort9m(int videoMluShort9m) {
        this.videoMluShort9m = videoMluShort9m;
    }

    public int getVideoPreshluLong() {
        return videoPreshluLong;
    }

    public void setVideoPreshluLong(int videoPreshluLong) {
        this.videoPreshluLong = videoPreshluLong;
    }

    public int getVideoPreshluShort6m() {
        return videoPreshluShort6m;
    }

    public void setVideoPreshluShort6m(int videoPreshluShort6m) {
        this.videoPreshluShort6m = videoPreshluShort6m;
    }

    public int getVideoPreshluShort9m() {
        return videoPreshluShort9m;
    }

    public void setVideoPreshluShort9m(int videoPreshluShort9m) {
        this.videoPreshluShort9m = videoPreshluShort9m;
    }

    public int getVideoShlu() {
        return videoShlu;
    }

    public void setVideoShlu(int videoShlu) {
        this.videoShlu = videoShlu;
    }
}