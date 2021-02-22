package mel.springframework.sfpetclinic.repositories;

import mel.springframework.sfpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository <PetType,Long> {
}
