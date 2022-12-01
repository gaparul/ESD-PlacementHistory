package com.academia.placementhistory.DAO;

import com.academia.placementhistory.Bean.Organisation;
import com.academia.placementhistory.Bean.PlacementStudent;
import com.academia.placementhistory.Bean.Student;

import java.util.List;

public interface StudentDAO {

    void addStudent(Student s);

    List<Object> getStudentByOrganisation(Organisation org);

    List<Object> getStudentByDate(PlacementStudent ps);

    List<Object> getStudentByDomain(Student st);

    List<List<Student>> listStudents();

    List<String> getDomain();

}
