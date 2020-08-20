package dao;

import domain.OvChipkaart;

import java.util.List;

public interface OvChipkaartDao {
    Integer addKaart(OvChipkaart ovChipkaart);
    List<OvChipkaart> findAllKaarten();
    boolean updateKaart(OvChipkaart o1);
    void deleteKaart(OvChipkaart ovChipkaart);
}
