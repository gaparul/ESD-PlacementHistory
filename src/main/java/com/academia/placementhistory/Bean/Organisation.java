package com.academia.placementhistory.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Organisations")
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int org_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    public Organisation(int org_id, String name, String address) {
        this.org_id = org_id;
        this.name = name;
        this.address = address;
    }

    public Organisation() {

    }

    public int getOrg_id() {
        return org_id;
    }

    public void setOrg_id(int org_id) {
        this.org_id = org_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
