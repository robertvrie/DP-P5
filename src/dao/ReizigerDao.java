package dao;

import domain.Reiziger;

import java.util.List;

public interface ReizigerDao {
    List<Reiziger> findAll();
    Integer addReiziger(Reiziger reiziger);
    void deleteReiziger(Reiziger reiziger);
    boolean updateReiziger(Reiziger r1);
}
