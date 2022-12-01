package com.academia.placementhistory.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Placement_Filter")
public class PlacementFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pf_id;

    @ManyToOne
    @JoinColumn(name = "placement_id", referencedColumnName = "placement_id")
    private Placement placement_id;

    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private String domain;

    public PlacementFilter(int pf_id, Placement placement_id, String specialization, String domain) {
        this.pf_id = pf_id;
        this.placement_id = placement_id;
        this.specialization = specialization;
        this.domain = domain;
    }

    public PlacementFilter() {

    }

    public int getPf_id() {
        return pf_id;
    }

    public void setPf_id(int pf_id) {
        this.pf_id = pf_id;
    }

    public Placement getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Placement placement_id) {
        this.placement_id = placement_id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
