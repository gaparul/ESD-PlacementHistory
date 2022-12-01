package com.academia.placementhistory.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumni_Organisation")
public class AlumniOrganisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alumniorg_id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "org_id")
    private Organisation organisation;

    @ManyToOne
    @JoinColumn(referencedColumnName = "alumni_id")
    private Alumni alumni_id;

    private String Position;

    @Column(name = "joining_date",nullable = false)
    private String joining_date;

    @Column(name = "leaving_date", nullable = false)
    private String leaving_date;

    public AlumniOrganisation(int alumniorg_id, Organisation organisation, Alumni alumni_id, String position, String joining_date, String leaving_date) {
        this.alumniorg_id = alumniorg_id;
        this.organisation = organisation;
        this.alumni_id = alumni_id;
        Position = position;
        this.joining_date = joining_date;
        this.leaving_date = leaving_date;
    }

    public AlumniOrganisation() {

    }

    public int getAlumniorg_id() {
        return alumniorg_id;
    }

    public void setAlumniorg_id(int alumniorg_id) {
        this.alumniorg_id = alumniorg_id;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Alumni getAlumni_id() {
        return alumni_id;
    }

    public void setAlumni_id(Alumni alumni_id) {
        this.alumni_id = alumni_id;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getJoining_date() {
        return joining_date;
    }

    public void setJoining_date(String joining_date) {
        this.joining_date = joining_date;
    }

    public String getLeaving_date() {
        return leaving_date;
    }

    public void setLeaving_date(String leaving_date) {
        this.leaving_date = leaving_date;
    }
}
