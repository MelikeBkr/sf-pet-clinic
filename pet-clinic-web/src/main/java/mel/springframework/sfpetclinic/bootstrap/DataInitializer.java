package mel.springframework.sfpetclinic.bootstrap;

import mel.springframework.sfpetclinic.model.Owner;
import mel.springframework.sfpetclinic.model.Vet;
import mel.springframework.sfpetclinic.services.OwnerService;
import mel.springframework.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner
{
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Elizabeth");
        owner1.setLastName("Gleanne");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Erwin");
        owner2.setLastName("Smith");

        ownerService.save(owner1);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Mikasa");
        vet1.setLastName("Ackerman");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Armin");
        vet2.setLastName("Arlert");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
