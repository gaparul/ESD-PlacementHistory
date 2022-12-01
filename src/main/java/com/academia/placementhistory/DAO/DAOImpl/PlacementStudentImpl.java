package com.academia.placementhistory.DAO.DAOImpl;

import com.academia.placementhistory.Bean.PlacementStudent;
import com.academia.placementhistory.DAO.PlacementStudentDAO;
import com.academia.placementhistory.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlacementStudentImpl implements PlacementStudentDAO {

    public void addPlacedStudent(PlacementStudent ps)
    {
        Session session = HibernateSessionUtil.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(ps);
            transaction.commit();
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());

        }
        finally
        {
            session.close();
        }
    }

    public List<String> getYear() {

        try(Session session = HibernateSessionUtil.getSession()){
            Query query = session.createQuery("select distinct Date from PlacementStudent", String.class);

            List<String> res = query.getResultList();
            return res;

        }catch (HibernateException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }
}
