package com.academia.placementhistory.DAO.DAOImpl;

import com.academia.placementhistory.Bean.AlumniOrganisation;
import com.academia.placementhistory.DAO.AlumniOrganisationDAO;
import com.academia.placementhistory.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AlumniOrganisationImpl implements AlumniOrganisationDAO {
    @Override
    public void addAlumniOrganisation(AlumniOrganisation ao) {

        Session session = HibernateSessionUtil.getSession();
        try{
            Transaction transaction  = session.beginTransaction();
            session.save(ao);
            transaction.commit();
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
        }
        finally {
            session.close();
        }
    }
}
