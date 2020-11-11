package pl.kkowalewski.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kkowalewski.model.Speciality;
import pl.kkowalewski.service.SpecialityService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }
}
