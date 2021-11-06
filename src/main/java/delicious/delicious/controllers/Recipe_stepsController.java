package delicious.delicious.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import delicious.delicious.models.Recipe_StepsModel;
import delicious.delicious.repositories.RecipeRepo;
import delicious.delicious.repositories.Recipe_StepsRepo;
import delicious.delicious.services.RecipeService;

@RestController
@RequestMapping(path = { "/api/v1/Recipe_stepsController" })
public class Recipe_stepsController {
    @Autowired
    Recipe_StepsRepo recipe_steps;

    @Autowired
    RecipeService recipeService;
}
