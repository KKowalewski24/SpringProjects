package pl.kkowalewski.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kkowalewski.service.OwnerService;

@Controller
public class OwnerController {

    /*------------------------ FIELDS REGION ------------------------*/
    public static final String OWNER = "owner";
    public static final String OWNERS = "/owners";
    public static final String OWNERS_INDEX = "/owners/index";
    public static final String OWNERS_INDEX_HTML = "/owners/index.html";
    public static final String OWNERS_FIND = "/owners/find";
    public static final String OWNERS_OWNER_ID = "/owners/{ownerId}";
    public static final String OWNERS_DETAILS = "owners/ownerDetails";

    private final OwnerService ownerService;

    /*------------------------ METHODS REGION ------------------------*/
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //SUBSTRING() IS USED TO REMOVE SLASH(/) FROM MAPPING
    @RequestMapping({OWNERS, OWNERS_INDEX, OWNERS_INDEX_HTML})
    public String listOwners(Model model) {
        model.addAttribute(OWNERS.substring(1), ownerService.findAll());

        return OWNERS_INDEX.substring(1);
    }

    @RequestMapping(OWNERS_FIND)
    public String findOwners() {
        return "notImplemented";
    }

    @GetMapping(OWNERS_OWNER_ID)
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView modelAndView = new ModelAndView(OWNERS_DETAILS);
        modelAndView.addObject(ownerService.findById(ownerId));

        return modelAndView;
    }
}
