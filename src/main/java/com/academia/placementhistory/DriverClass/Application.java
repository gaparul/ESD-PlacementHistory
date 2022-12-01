package com.academia.placementhistory.DriverClass;

import com.academia.placementhistory.Bean.*;
import com.academia.placementhistory.DAO.DAOImpl.OrganisationImpl;
import com.academia.placementhistory.DAO.DAOImpl.PlacementDAOImpl;
import com.academia.placementhistory.DAO.DAOImpl.PlacementStudentImpl;
import com.academia.placementhistory.DAO.DAOImpl.StudentImpl;
import com.academia.placementhistory.DAO.OrganisationDAO;
import com.academia.placementhistory.DAO.PlacementDAO;
import com.academia.placementhistory.DAO.PlacementStudentDAO;
import com.academia.placementhistory.DAO.StudentDAO;

public class Application {

    public static void main(String[] args) {

        runApplication();
    }
    public static void runApplication(){
        Student st = new Student();
        st.setFirstName("Parul");
        st.setCgpa(3.14);
        st.setEmail("parul@iiit.com");
        st.setDomain("CSE");
        st.setRollNo("101");
        st.setSpecialization("ML");
        StudentDAO studentDAO = new StudentImpl();
        studentDAO.addStudent(st);

        Student st2 = new Student();
        st2.setFirstName("Sakshi");
        st2.setCgpa(3.16);
        st2.setEmail("sakshi@iiit.com");
        st2.setDomain("CSE");
        st2.setRollNo("102");
        st2.setSpecialization("ML");
        studentDAO.addStudent(st2);

        Student st3 = new Student();
        st3.setFirstName("Yasha");
        st3.setCgpa(3.19);
        st3.setEmail("yasha@iiit.com");
        st3.setDomain("CSE");
        st3.setRollNo("103");
        st3.setSpecialization("ML");
        studentDAO.addStudent(st3);

        Organisation o = new Organisation();
        o.setName("TCS");
        o.setAddress("Pune");
        OrganisationDAO organisationDAO = new OrganisationImpl();
        organisationDAO.addOrganisation(o);

        Placement pc = new Placement();
        pc.setProfile("Developer");
        pc.setIntake(150);
        pc.setMinGrade(2.4);
        pc.setOrganisation(o);

        PlacementDAO placementDAO = new PlacementDAOImpl();
        placementDAO.addCompany(pc);

        PlacementStudent ps = new PlacementStudent();
        ps.setStatus("Placed");
        ps.setStudent_id(st);
        ps.setDate("2019");
        ps.setPlacement_id(pc);

        PlacementStudentDAO placementStudentDAO = new PlacementStudentImpl();
        placementStudentDAO.addPlacedStudent(ps);


    }
}
