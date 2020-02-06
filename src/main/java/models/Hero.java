package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {


    private String description;
    private String name;
    private int age;
    private String specialPowers;
    private String weakness;
    private int id;
    private int squadId;



    public Hero(String name, int age, String specialPowers, String weakness,int squadId){
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weakness = weakness;
        this.squadId = squadId;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                squadId == hero.squadId &&
                description.equals(hero.description) &&
                name.equals(hero.name) &&
                specialPowers.equals(hero.specialPowers) &&
                weakness.equals(hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, age, specialPowers, weakness, id, squadId);
    }

    public void setDescription(String description) {
        this.description = description;
    }



    private String getDescription() {
        return description;
    }


    public String getName(){

        return name;
    }

    public int getAge(){

        return age;
    }

    public String getSpecialPowers(){

        return specialPowers;
    }

    public String getWeakness(){

        return weakness;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setAge(int age) {

        this.age = age;
    }


    public void setSpecialPowers(String specialPowers) {

        this.specialPowers = specialPowers;
    }

    public void setName(String name) {

        this.name = name;
    }
    public void setWeakness(String weakness){

        this.weakness = weakness;

    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public void update (String name, int age, String specialPowers, String weakness){
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weakness = weakness;
    }

}
