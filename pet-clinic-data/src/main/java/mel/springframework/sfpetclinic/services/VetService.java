package mel.springframework.sfpetclinic.services;
import mel.springframework.sfpetclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet,Long> {
    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
