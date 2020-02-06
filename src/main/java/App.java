import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        Hero one = new Hero("a",0,"Superhuman","Fire");
        Hero two = new Hero("b",1,"Flying","asbestos");
        Hero three= new Hero("c",2,"Shapeshifting","The Muramasa Blade");
        Hero four= new Hero("d",3,"Super Speed","Yellow");
        Hero five= new Hero("e",4,"Super Senses"," Adamantium");
        Hero six = new Hero("f",5,"Mind Control","Noise Pollution");
        Hero seven = new Hero("g",6,"Telekinesis"," Kryptonite");
        Hero eight = new Hero("h",7,"Teleportation","Matches");
        Hero night = new Hero("i",8,"Power Absorbtion","Wanting To Get Caught");
        Hero ten = new Hero("j",9,"Regenerative Power","A Cigarette Lighter");

        get("/",(request, response) -> {
            Map<String ,Object> model = new HashMap<>();
            ArrayList<Hero> heroes= Hero.getInstance();

            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());


    }
}
