package mel.springframework.sfpetclinic.bootstrap;

import mel.springframework.sfpetclinic.model.*;
import mel.springframework.sfpetclinic.services.OwnerService;
import mel.springframework.sfpetclinic.services.PetTypeService;
import mel.springframework.sfpetclinic.services.SpecialityService;
import mel.springframework.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        int count = petTypeService.findAll().size();
        if(count==0)
        {
            initializeData();
        }
    }

    private void initializeData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Elizabeth");
        owner1.setLastName("Gleanne");
        owner1.setAddress("6 Broadway");
        owner1.setCity("London");
        owner1.setTelephone("2222241");
        Pet elliesPet = new Pet();
        elliesPet.setType(savedDogPetType);
        elliesPet.setOwner(owner1);
        elliesPet.setBirthDate(LocalDate.now());
        elliesPet.setName("Buddy");
        owner1.getPets().add(elliesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Erwin");
        owner2.setLastName("Smith");
        owner2.setAddress("9501 Chester Road");
        owner2.setCity("London");
        owner2.setTelephone("2222242");

        Pet erwinsPet = new Pet();
        erwinsPet.setType(savedCatPetType);
        erwinsPet.setOwner(owner2);
        erwinsPet.setBirthDate(LocalDate.now());
        erwinsPet.setName("Kittie");
        owner2.getPets().add(erwinsPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mikasa");
        vet1.setLastName("Ackerman");
        vet1.getSpecialities().add(savedRadiology);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Armin");
        vet2.setLastName("Arlert");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
