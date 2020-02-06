import DAO.Sql2oHeroDao;
import models.Hero;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oHeroDao heroDao = new Sql2oHeroDao(sql2o);

     //get:show all heroes in all squads and show all squads
        get("/",(request, response) -> {
            Map<String ,Object> model = new HashMap<>();
            List<Hero> heroes = heroDao.getAll();
            model.put("heroes",heroes);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());


        //get:show a form to create new squad
        // /squad/new

        //post:process a form to create a new squad
        // /squad

        //get:delete all squads and all heroes
        //  /squad/delete

        //get delete all heroes
        get("/heroes/delete",(request, response) -> {
            Map<String ,Object> model = new HashMap<>();
            heroDao.clearAllHeroes();
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //get specific squad (and heroes it contains)
        // /squads/:squad_id

        //get: show a form to update a squad
        // /squads/:id/edit

        //post : process a form to update a squad
        // /squads/:id

        //get: delete a squad and heroes iit contains
        // /squads:id/delete

        //delete an individual squad
        get("/squads/:squad_id/heros/:hero_id/delete",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("hero_id"));
            heroDao.deleteById(idOfHeroToDelete);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //get: show new hero form
        get("/heroes/new",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model ,"hero-form.hbs");
        },new HandlebarsTemplateEngine());

        //hero:process new hero form
        post("/heroes",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String specialPower = req.queryParams("specialPowers");
            String weakness = req.queryParams("weakness");

            Hero newHero = new Hero(name,age,specialPower,weakness,1);
            heroDao.add(newHero);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //show an individual hero that is nested in squad
        get();







        //get: delete all heroes
        get("/heroes/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            heroDao.clearAllHeroes(); //change
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: delete an individual hero
        get("/heroes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params("id"));
            heroDao.deleteById(idOfHeroToDelete);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show all heroes
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Hero> heroes = heroDao.getAll();
            model.put("heroes", heroes);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new hero form
        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //hero: process new hero form
        post("/heroes", (req, res) -> { //URL to make new hero on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String specialPower = req.queryParams("specialPowers");
            String weakness = req.queryParams("weakness");

            Hero newHero = new Hero(name,age,specialPower,weakness); //change
            heroDao.add(newHero);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show an individual hero
        get("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(req.params("id"));
            Hero foundHero = heroDao.findById(idOfHeroToFind); //change
            model.put("hero", foundHero);
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show a form to update a hero
        get("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = heroDao.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //hero: process a form to update a hero
        post("/heroes/:id", (req, res) -> { //URL to update hero on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            int age = Integer.parseInt(req.queryParams("age"));
            String specialPower = req.queryParams("specialPowers");
            String weakness = req.queryParams("weakness");
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            heroDao.update(idOfHeroToEdit,name,age,specialPower,weakness);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}
