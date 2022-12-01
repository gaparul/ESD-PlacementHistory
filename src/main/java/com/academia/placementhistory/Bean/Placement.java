package com.academia.placementhistory.Bean;

import jakarta.persistence.*;
@Entity
@Table(name = "Placement")
public class Placement {

    @Id
    @Column(name = "placement_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placementId;

    @Column(name = "profile", nullable = false)
    private String profile;

    @Column(name = "description")
    private String description;

    @Column(name = "intake", nullable = false)
    private int intake;

    @Column(name = "minimum_grade", nullable = false, columnDefinition = "Decimal(2,1) default '0.0'")
    private Double minCgpa;

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    private Organisation organisation;

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public Placement(int placementId, String profile, String description, int intake, Double minCgpa, Organisation organisation) {
        this.placementId = placementId;
        this.profile = profile;
        this.description = description;
        this.intake = intake;
        this.minCgpa = minCgpa;
        this.organisation = organisation;
    }

    public Placement() {

    }

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIntake() {
        return intake;
    }

    public void setIntake(int intake) {
        this.intake = intake;
    }

    public Double getMinGrade() {
        return minCgpa;
    }

    public void setMinGrade(Double minGrade) {
        this.minCgpa = minGrade;
    }


}
