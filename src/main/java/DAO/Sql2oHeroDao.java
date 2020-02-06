package DAO;

import models.Hero;
import org.sql2o.*;
import org.sql2o.Sql2o;

import java.util.List;

public class Sql2oHeroDao implements HeroDao{
    private final Sql2o sql2o;

    public Sql2oHeroDao(Sql2o sql2o){

        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it

    }
    @Override
    public List<Hero> getAll() {
        return null;
    }

    @Override
    public void add(Hero hero) {
        String sql = "INSERT INTO heroes (name,age,specialPowers,weakness) VALUES (:name,:age,:specialPowers,:weakness)";
        try(Connection con = sql2o.open()) {

        }
    }

    @Override
    public Hero findById(int id) {
        return null;
    }
}
