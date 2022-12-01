package com.academia.placementhistory.DAO.DAOImpl;

import com.academia.placementhistory.Bean.Organisation;
import com.academia.placementhistory.DAO.OrganisationDAO;
import com.academia.placementhistory.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrganisationImpl implements OrganisationDAO {

    @Override
    public void addOrganisation(Organisation o) {
        Session session = HibernateSessionUtil.getSession();
        try {
            Transaction transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();
        }
        catch (HibernateException e){
            System.out.println(e.getLocalizedMessage());
        }
        finally {
            session.close();
        }
    }

    @Override
    public List<String> getOrganisation() {
        try(Session session = HibernateSessionUtil.getSession()){
            Query query = session.createQuery("select distinct name from Organisation ", String.class);
            List<String> org = query.getResultList();
            return org;
        }
        catch (HibernateException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return null;
    }

}
