package mel.springframework.sfpetclinic.repositories;

import mel.springframework.sfpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long>
{

}
