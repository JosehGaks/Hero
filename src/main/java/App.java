import DAO.Sql2oHeroDao;
import DAO.Sql2oSquadDao;
import models.Hero;
import models.Squad;
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
        Sql2oSquadDao squadDao = new Sql2oSquadDao(sql2o);

     //get:show all heroes in all squads and show all squads
        get("/",(request, response) -> {
            Map<String ,Object> model = new HashMap<>();
            List<Squad> allSquads = squadDao.getAll();
            model.put("squads",allSquads);
            List<Hero> heroes = heroDao.getAll();
            model.put("heroes",heroes);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());


        //get:show a form to create new squad
        // /squads/new
        get("/squads/new",(request, response) -> {
            Map<String ,Object> model = new HashMap<>();
            List<Squad> allSquads = squadDao.getAll();
            model.put("squads",allSquads);
            return new ModelAndView(model,"squad-form.hbs");
        },new HandlebarsTemplateEngine());

        //post:process a form to create a new squad
        // /squad
        post("/squads",(request, response) -> {
            Map<String ,Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Squad newSquad = new Squad(name);
            squadDao.add(newSquad);

            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

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
        get("/squads/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(request.params("id"));
            Squad foundSquad = squadDao.findById(idOfSquadToFind);
            model.put("squad",foundSquad);
            List<Hero> allHeroesBySquad = squadDao.getAllHeroesBySquad(idOfSquadToFind);
            model.put("heroes",allHeroesBySquad);
            model.put("squads",squadDao.getAll());
            return new ModelAndView(model,"squad-detail.hbs");
        },new HandlebarsTemplateEngine());

        //get: show a form to update a squad
        // /squads/:id/edit
        get("/squads/:id/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("editSquad", true);
            Squad squad = squadDao.findById(Integer.parseInt(request.params("id")));
            model.put("squad",squad);
            model.put("squads",squadDao.getAll());
            return new ModelAndView(model,"squad-form.hbs");
        },new HandlebarsTemplateEngine());

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
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("specialPowers");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(name,age,specialPower,weakness,1);
            heroDao.add(newHero);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        //show an individual hero that is nested in squad
        get("/squads/:squad_id/heroes/:hero_id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params("hero_id"));
            Hero foundHero = heroDao.findById(idOfHeroToFind);
            model.put("hero",foundHero);
            return new ModelAndView(model,"hero-detail.hbs");
        },new HandlebarsTemplateEngine());

        //get: show a form to update task
        get("/hero/:id/edit",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            Hero editHero = heroDao.findById(idOfHeroToEdit);
            model.put("editHero",editHero);
            return  new ModelAndView(model,"hero-form.hbs");
        },new HandlebarsTemplateEngine());


        //hero: process form to update a hero
        post("/heroes/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("specialPowers");
            String weakness = request.queryParams("weakness");
            int idOfHeroToEdit = Integer.parseInt(request.params("id"));
            heroDao.update(idOfHeroToEdit,name,age,specialPower,weakness,1);

            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());


    }
}
