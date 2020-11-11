package pl.kkowalewski.service.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.kkowalewski.model.Owner;
import pl.kkowalewski.service.OwnerService;
import pl.kkowalewski.service.PetService;
import pl.kkowalewski.service.PetTypeService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final PetTypeService petTypeService;
    private final PetService petService;

    /*------------------------ METHODS REGION ------------------------*/
    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    public PetTypeService getPetTypeService() {
        return petTypeService;
    }

    public PetService getPetService() {
        return petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll().stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst().orElse(null);
    }
}
