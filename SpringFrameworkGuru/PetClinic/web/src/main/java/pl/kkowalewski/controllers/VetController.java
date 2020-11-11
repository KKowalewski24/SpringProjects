package pl.kkowalewski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kkowalewski.service.VetService;

@Controller
public class VetController {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String VETS = "/vets";
    public static final String VETS_HTML = "/vets.html";
    public static final String VETS_INDEX = "/vets/index";
    public static final String VETS_INDEX_HTML = "/vets/index.html";

    private final VetService vetService;

    /*------------------------ METHODS REGION ------------------------*/
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    //SUBSTRING() IS USED TO REMOVE SLASH(/) FROM MAPPING
    @RequestMapping({VETS, VETS_HTML, VETS_INDEX, VETS_INDEX_HTML})
    public String listVets(Model model) {
        model.addAttribute(VETS.substring(1), vetService.findAll());

        return VETS_INDEX.substring(1);
    }
}
