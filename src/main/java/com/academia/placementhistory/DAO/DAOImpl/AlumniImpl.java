package com.academia.placementhistory.DAO.DAOImpl;

import com.academia.placementhistory.Bean.Alumni;
import com.academia.placementhistory.Bean.Organisation;
import com.academia.placementhistory.DAO.AlumniDAO;
import com.academia.placementhistory.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AlumniImpl implements AlumniDAO {
    @Override
    public void addAlumni(Alumni a) {
        Session session = HibernateSessionUtil.getSession();
        try{
            Transaction transaction = session.beginTransaction();
            session.save(a);
            transaction.commit();
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
        }
        finally {
            session.close();
        }
    }

    public List<Object> getAlumniDetails(Organisation o){
        try(Session session =  HibernateSessionUtil.getSession()){
            Query query = session.createQuery("select al.email, al.contact_number, alo.joining_date, alo.leaving_date, alo.Position, org.name from Alumni al inner join AlumniOrganisation alo on al.alumni_id = alo.alumni_id.alumni_id inner join Organisation org on org.org_id=alo.organisation.org_id where org.name='"+o.getName()+"'");

            List<Object> listAlumni = query.list();

            return listAlumni;
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}
