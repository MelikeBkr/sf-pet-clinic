package mel.springframework.sfpetclinic.repositories;

import mel.springframework.sfpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
