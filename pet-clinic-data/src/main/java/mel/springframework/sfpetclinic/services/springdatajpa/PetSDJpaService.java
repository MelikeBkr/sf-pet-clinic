package mel.springframework.sfpetclinic.services.springdatajpa;

import mel.springframework.sfpetclinic.model.Pet;
import mel.springframework.sfpetclinic.repositories.PetRepository;
import mel.springframework.sfpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService
{
    private PetRepository petRepository;

    public PetSDJpaService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long aLong)
    {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Set<Pet> findAll()
    {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public void delete(Pet object)
    {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong)
    {
        petRepository.deleteById(aLong);
    }
}
