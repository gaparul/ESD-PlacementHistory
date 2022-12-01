package com.academia.placementhistory.DAO.DAOImpl;


import com.academia.placementhistory.Bean.PlacementFilter;
import com.academia.placementhistory.DAO.PlacementFilterDAO;
import com.academia.placementhistory.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlacementFilterDAOImpl implements PlacementFilterDAO {
    public void addPlacementFilterEntry(PlacementFilter pf)
    {
        Session session = HibernateSessionUtil.getSession();
        try
        {
            Transaction transaction = session.beginTransaction();
            session.save(pf);
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
}
