package delicious.delicious.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import delicious.delicious.repositories.RecipeRepo;

@RestController
@RequestMapping(path = {"/api/v1/RecipeController"})
public class RecipeController {
    @Autowired
    RecipeRepo  eRecipeRepo;
}
