package pc.springframework.spring5recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pc.springframework.spring5recipeapp.services.RecipeService;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        System.out.println("*** IndexController -> getIndexPage()");
        model.addAttribute("recipes",recipeService.getRecipes());
        return "recipeapp/index";
    }
}
