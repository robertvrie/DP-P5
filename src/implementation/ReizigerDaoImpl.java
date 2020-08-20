package implementation;

import dao.OracleBaseDao;
import dao.ReizigerDao;
import domain.OvChipkaart;
import domain.Reiziger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ReizigerDaoImpl extends OracleBaseDao implements ReizigerDao {

    public Integer addReiziger(Reiziger reiziger){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer reizigerId = null;

        try{
            tx = session.beginTransaction();
            reizigerId = (Integer) session.save(reiziger);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reizigerId;
    }

    public List<Reiziger> findAll() {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        List<Reiziger> reizigers = null;

        try {
            tx = session.beginTransaction();
            reizigers = session.createQuery("FROM Reiziger").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reizigers;
    }

    public boolean updateReiziger(Reiziger r1){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        boolean success = false;

        try {
            tx = session.beginTransaction();
            Reiziger r2 = (Reiziger) session.get(Reiziger.class, r1.getReizigerId());
            r2.setVoorletters(r1.getVoorletters());
            r2.setTussenvoegsel(r1.getTussenvoegsel());
            r2.setAchternaam(r1.getAchternaam());
            r2.setGbdatum(r1.getGbdatum());
            session.update(r2);
            success = true;
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return success;
    }

    public void deleteReiziger(Reiziger reiziger){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(reiziger);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
