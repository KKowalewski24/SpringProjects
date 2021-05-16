package pl.kkowalewski.showroom.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kkowalewski.showroom.model.Showroom;
import pl.kkowalewski.showroom.service.showroom.ShowroomService;

import java.util.List;

import static pl.kkowalewski.showroom.constant.Constants.BASE_PATH_SHOWROOMS;

@RequestMapping(BASE_PATH_SHOWROOMS)
@RestController
public class ShowroomController implements BaseController<Showroom> {

    /*------------------------ FIELDS REGION ------------------------*/
    private final ShowroomService showroomService;

    /*------------------------ METHODS REGION ------------------------*/
    public ShowroomController(ShowroomService showroomService) {
        this.showroomService = showroomService;
    }

    @Override
    public List<Showroom> getAll() {
        return null;
    }

    @Override
    public Showroom getById(Long id) {
        return null;
    }

    @Override
    public Showroom post(Showroom object) {
        return null;
    }

    @Override
    public Showroom put(Long id, Showroom object) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
