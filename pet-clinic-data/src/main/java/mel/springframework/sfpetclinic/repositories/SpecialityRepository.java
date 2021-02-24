package mel.springframework.sfpetclinic.repositories;

import mel.springframework.sfpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
