package implementation;

import dao.OracleBaseDao;
import dao.OvChipkaartDao;
import domain.OvChipkaart;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OvChipkaartDaoImpl extends OracleBaseDao implements OvChipkaartDao {
    public Integer addKaart(OvChipkaart ovChipkaart){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer kaartnummer = null;

        try{
            tx = session.beginTransaction();
            kaartnummer = (Integer) session.save(ovChipkaart);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kaartnummer;
    }

    public List<OvChipkaart> findAllKaarten() {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        List<OvChipkaart> kaarten = null;

        try {
            tx = session.beginTransaction();
            kaarten = session.createQuery("FROM OvChipkaart").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return kaarten;
    }

    public void deleteKaart(OvChipkaart ovChipkaart){

    }
}