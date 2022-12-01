package com.academia.placementhistory.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Placement_Student")
public class PlacementStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PS_id;

    @ManyToOne
    @JoinColumn(name="placement_id", referencedColumnName = "placement_id")
    private Placement placement_id;

    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "student_id")
    private Student student_id;

    @Column(nullable = false)
    private String Status;


    @Column(name="date")
    private String Date;

    public PlacementStudent(Integer PS_id, Placement placement_id, Student student_id, String status, String date) {
        this.PS_id = PS_id;
        this.placement_id = placement_id;
        this.student_id = student_id;
        Status = status;
        Date = date;
    }

    public PlacementStudent() {

    }

    public Integer getPS_id() {
        return PS_id;
    }

    public void setPS_id(Integer PS_id) {
        this.PS_id = PS_id;
    }

    public Placement getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Placement placement_id) {
        this.placement_id = placement_id;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
