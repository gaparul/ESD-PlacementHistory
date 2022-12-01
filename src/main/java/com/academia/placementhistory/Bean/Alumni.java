package com.academia.placementhistory.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumni")
public class Alumni {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int alumni_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String contact_number;

    // TODO check for the relation
    @OneToOne
    @JoinColumn(referencedColumnName = "student_id")
    private Student student_id;

    public Alumni(int alumni_id, String email, String contact_number, Student student_id) {
        this.alumni_id = alumni_id;
        this.email = email;
        this.contact_number = contact_number;
        this.student_id = student_id;
    }

    public Alumni() {

    }

    public int getAlumni_id() {
        return alumni_id;
    }

    public void setAlumni_id(int alumni_id) {
        this.alumni_id = alumni_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }
}
