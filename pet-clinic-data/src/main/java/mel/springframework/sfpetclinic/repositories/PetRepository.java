package mel.springframework.sfpetclinic.repositories;

import mel.springframework.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
