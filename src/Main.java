import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import dao.OvChipkaartDao;
import dao.ReizigerDao;
import domain.OvChipkaart;
import domain.Reiziger;
import implementation.OvChipkaartDaoImpl;
import implementation.ReizigerDaoImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) throws SQLException, ParseException {

        OvChipkaartDao ovChipkaartDao = new OvChipkaartDaoImpl();
        ReizigerDao reizigerDao = new ReizigerDaoImpl();

        OvChipkaart o1 = new OvChipkaart(57839, Date.valueOf("2020-10-10"), 2, 69.69, 2);

        //System.out.println(ovChipkaartDao.addKaart(o1));

        System.out.println(ovChipkaartDao.findAllKaarten());

        System.out.println(reizigerDao.findAll());

        Reiziger r1 = new Reiziger(10, "M", "van", "Oostveen", Date.valueOf("1997-09-09"));

        //System.out.println(reizigerDao.addReiziger(r1));


        //Update kaart in de database en zet deze weer terug naar standaard waarden
        OvChipkaart o2 = new OvChipkaart(35283, Date.valueOf("2020-05-05"), 1, 20.0, 1);
        OvChipkaart o3 = new OvChipkaart(35283, Date.valueOf("2018-05-31"), 2, 25.5, 2);

        ovChipkaartDao.updateKaart(o2);
        System.out.println(ovChipkaartDao.findAllKaarten());
        ovChipkaartDao.updateKaart(o3);
        System.out.println(ovChipkaartDao.findAllKaarten());

        //Verwijderd kaart en zet deze weer terug in de database
        ovChipkaartDao.deleteKaart(o3);
        System.out.println(ovChipkaartDao.findAllKaarten());
        ovChipkaartDao.addKaart(o3);
        System.out.println(ovChipkaartDao.findAllKaarten());

        //Update reiziger en zet deze weer terug naar standaard waarden
        Reiziger r2 = new Reiziger(10, "R-J", "", "Vrieling", Date.valueOf("1997-07-30"));
        reizigerDao.updateReiziger(r2);
        System.out.println(reizigerDao.findAll());
        reizigerDao.updateReiziger(r1);
        System.out.println(reizigerDao.findAll());

        reizigerDao.deleteReiziger(r1);
        System.out.println(reizigerDao.findAll());
        reizigerDao.addReiziger(r1);
        System.out.println(reizigerDao.findAll());
    }
}
