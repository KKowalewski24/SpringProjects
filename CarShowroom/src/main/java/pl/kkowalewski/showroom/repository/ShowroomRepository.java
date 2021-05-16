package pl.kkowalewski.showroom.repository;

import pl.kkowalewski.showroom.model.Showroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowroomRepository extends CrudRepository<Showroom, Long> {

}
