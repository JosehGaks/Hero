package DAO;

import models.Hero;
import models.Squad;

import java.util.List;
public interface SquadDao {

    //LIST
    List<Squad> getAll();



    //CREATE
    void add (Squad squad);

    List<Hero> getAllHeroesBySquad(int squadId);
    //READ
    Squad findById(int id);

    //UPDATE
    void update(int id, String name);

    //DELETE
    void deleteById(int id);
    void clearAllSquads();
}
