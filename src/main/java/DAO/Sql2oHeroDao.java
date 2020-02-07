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
    public void add (Hero hero){
        String sql = "INSERT INTO heroes (name,age,specialPowers,weakness) VALUES (:name,:age,:specialPowers,:weakness)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(hero)
                    .executeUpdate()
                    .getKey();
            hero.setId(id);

        }
        catch (Sql2oException ex) {
            System.out.println(ex); //oops we have an error!
        }
    }
    @Override
    public List<Hero> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM heroes")
                    .executeAndFetch(Hero.class);
        }

    }



    @Override
    public Hero findById(int id) {
        try (Connection con =sql2o.open()){
            return con.createQuery("SELECT * FROM heroes WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Hero.class);
        }
    }

    @Override
    public void update(int id, String name, int age, String specialPowers, String weakness,int newSquadId) {
        String sql = "UPDATE heroes SET name = :name,age = :age,specialPowers = :specialPowers,weakness = :weakness WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id)
                    .addParameter("name",name)
                    .addParameter("age",age)
                    .addParameter("specialPowers",specialPowers)
                    .addParameter("weakness",weakness)
                    .addParameter("squadId",newSquadId)
                    .executeUpdate();
        }
        catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from heroes WHERE id=:id";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }
        catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllHeroes() {
        String sql = "Delete from heroes";
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }
        catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


}
