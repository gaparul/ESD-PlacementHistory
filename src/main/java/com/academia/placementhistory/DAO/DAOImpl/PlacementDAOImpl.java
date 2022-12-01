package com.academia.placementhistory.DAO.DAOImpl;

import com.academia.placementhistory.Bean.Placement;
import com.academia.placementhistory.DAO.PlacementDAO;
import com.academia.placementhistory.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class PlacementDAOImpl implements PlacementDAO {
    @Override
    public void addCompany(Placement p)
    {
        Session session = HibernateSessionUtil.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
            // System.out.println("Added Employee to DB successfully");
            //return true;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
            //  System.err.println("Unable to add employee to DB");
            //return false;
        }
        finally
        {
            session.close();
        }
    }
}
