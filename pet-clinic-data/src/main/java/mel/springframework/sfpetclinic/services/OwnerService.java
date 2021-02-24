package mel.springframework.sfpetclinic.services;

import mel.springframework.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
