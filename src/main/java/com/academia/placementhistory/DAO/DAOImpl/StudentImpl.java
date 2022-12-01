package com.academia.placementhistory.DAO.DAOImpl;

import com.academia.placementhistory.Bean.Organisation;
import com.academia.placementhistory.Bean.PlacementStudent;
import com.academia.placementhistory.Bean.Student;
import com.academia.placementhistory.DAO.StudentDAO;
import com.academia.placementhistory.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements StudentDAO {

    @Override
    public void addStudent(Student s) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(s);
            transaction.commit();

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());

        }
    }

    @Override
    public List<Object> getStudentByOrganisation(Organisation org) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Query query = session.createQuery("select distinct student.rollNo, student.firstName, student.email, organisation.name from PlacementStudent ps inner join Student student on ps.student_id.studentId = student.studentId inner join Placement pl on ps.placement_id.placementId = pl.placementId inner join Organisation organisation on pl.organisation.org_id = organisation.org_id where organisation.name = '"+org.getName()+"' and ps.Status='Placed'");
            List<Object> list = query.list();
            return list;
        } catch (HibernateException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Object> getStudentByDate(PlacementStudent psObj) {

        try(Session session = HibernateSessionUtil.getSession()){
            Query query = session.createQuery("select st.rollNo, st.firstName, st.email, ps.Date from PlacementStudent ps inner join Student st on ps.student_id.studentId = st.studentId where ps.Date='"+psObj.getDate()+"'");
            List<Object> list = query.list();
            return list;
        }
        catch (HibernateException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Object> getStudentByDomain(Student st) {

        try(Session session = HibernateSessionUtil.getSession()){
            Query query = session.createQuery("select st.rollNo, st.firstName, st.email, st.domain   from PlacementStudent ps inner join Student st on ps.student_id.studentId = st.studentId where st.domain='"+st.getDomain()+"'");
            List<Object> list = query.list();
            return list;
        }
        catch (HibernateException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

    public List<Student> placedStudents(List<Integer> pstudentlist){
        Session session = HibernateSessionUtil.getSession();
        try{
            Query querynp = session.createQuery("from Student s where s.studentId  in :pstudentList ", Student.class);
            querynp.setParameter("pstudentList", pstudentlist);
            List<Student> npList = querynp.getResultList();
            return npList;
        }
        catch (HibernateException e){
            System.out.println(e);
        }
        finally {
            session.close();
        }
        return null;
    }
    public List<Student> unplacedStudents(List<Integer> pstudentlist){
        Session session = HibernateSessionUtil.getSession();
        try{
            Query querynp = session.createQuery("from Student s where s.studentId not in :pstudentList ", Student.class);
            querynp.setParameter("pstudentList", pstudentlist);
            List<Student> npList = querynp.getResultList();
            return npList;
        }
        catch (HibernateException e){
            System.out.println(e);
        }
        finally {
            session.close();
        }
        return null;
    }
    public List<List<Student>> listStudents(){
        Session session = HibernateSessionUtil.getSession();
        try{
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from PlacementStudent ps", PlacementStudent.class);
            List<PlacementStudent> psList = query.getResultList();
            List<Integer> pstudentlist = new ArrayList<>();
            for (PlacementStudent ps : psList) {
                pstudentlist.add(ps.getStudent_id().getStudentId());
            }
            List<List<Student>> list = new ArrayList<>();
            list.add(placedStudents(pstudentlist));
            list.add(unplacedStudents(pstudentlist));
            transaction.commit();
            return list;
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<String> getDomain() {
        try(Session session = HibernateSessionUtil.getSession()){
            Query query = session.createQuery("select distinct domain from Student", String.class);

            List<String> res = query.getResultList();
            return res;

        }catch (HibernateException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }


}
