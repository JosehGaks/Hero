package models;

import java.util.ArrayList;
import java.util.Objects;

public class Hero {


    private String description;
    private String name;
    private String imageurl;
    private int age;
    private String specialPowers;
    private String weakness;
    private int id;



    public Hero(String name, int age, String specialPowers, String weakness, String imageurl){
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weakness = weakness;
        this.imageurl =imageurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age &&
                id == hero.id &&
                description.equals(hero.description) &&
                name.equals(hero.name) &&
                imageurl.equals(hero.imageurl) &&
                specialPowers.equals(hero.specialPowers) &&
                weakness.equals(hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, name, imageurl, age, specialPowers, weakness, id);
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
    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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

    public void update (String name,int age,String specialPowers,String weakness){
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weakness = weakness;
    }

}
