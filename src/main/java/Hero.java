import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String specialPowers;
    private String weakness;
    private static ArrayList< Hero > instance = new ArrayList< Hero >();

    public Hero(String name,int age,String specialPowers,String weakness){
        this.name = name;
        this.age = age;
        this.specialPowers = specialPowers;
        this.weakness = weakness;
        instance.add(this);
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

    public static ArrayList<Hero> getInstance() {
        return instance;
    }

    public static void setInstance(ArrayList<Hero> instance) {
        Hero.instance = instance;
    }

}
