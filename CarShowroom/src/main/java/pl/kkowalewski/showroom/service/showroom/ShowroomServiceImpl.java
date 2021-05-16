package pl.kkowalewski.showroom.service.showroom;

import org.springframework.stereotype.Service;
import pl.kkowalewski.showroom.exception.service.RepositoryItemNotFoundException;
import pl.kkowalewski.showroom.exception.service.ShowroomNotFoundException;
import pl.kkowalewski.showroom.model.Showroom;
import pl.kkowalewski.showroom.repository.ShowroomRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShowroomServiceImpl implements ShowroomService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final ShowroomRepository showroomRepository;

    /*------------------------ METHODS REGION ------------------------*/
    public ShowroomServiceImpl(ShowroomRepository showroomRepository) {
        this.showroomRepository = showroomRepository;
    }

    @Override
    public Showroom findById(Long id) throws RepositoryItemNotFoundException {
        return showroomRepository
                .findById(id)
                .orElseThrow(ShowroomNotFoundException::new);
    }

    @Override
    public List<Showroom> findAll() {
        return StreamSupport
                .stream(showroomRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Showroom save(Showroom object) {
        return showroomRepository.save(object);
    }

    @Override
    public Showroom update(Showroom object) {
        return showroomRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        showroomRepository.deleteById(id);
    }

    @Override
    public void delete(Showroom object) {
        showroomRepository.delete(object);
    }

    @Override
    public void deleteAll() {
        showroomRepository.deleteAll();
    }
}
