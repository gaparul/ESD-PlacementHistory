package com.academia.placementhistory.Bean;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "roll_number", nullable = false, unique = true)
    private String rollNo;

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = true)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false,columnDefinition="Decimal(2,1) default '0.0'")
    private Double cgpa;    //to check eligibility for placements

    private Integer gradYear;  //to check eligibility for placements

    @Column(nullable = false)
    private String domain;

    @Column(nullable = false)
    private String Specialization;

    public Student(Integer studentId, String rollNo, String firstName, String lastName, String email, Double cgpa, Integer gradYear, String domain, String specialization) {
        this.studentId = studentId;
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cgpa = cgpa;
        this.gradYear = gradYear;
        this.domain = domain;
        Specialization = specialization;
    }

    public Student() {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getGradYear() {
        return gradYear;
    }

    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }
}
