package mel.springframework.sfpetclinic.services.springdatajpa;

import mel.springframework.sfpetclinic.model.Owner;
import mel.springframework.sfpetclinic.repositories.OwnerRepository;
import mel.springframework.sfpetclinic.repositories.PetRepository;
import mel.springframework.sfpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest
{
    public static final String LAST_NAME = "Jaeger";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService service;
    Owner buildedOwner;
    @BeforeEach
    void setUp()
    {
        buildedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName()
    {
        Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(buildedOwner);
        Owner jaeger = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,jaeger.getLastName());
        Mockito.verify(ownerRepository).findByLastName(Mockito.any());
    }

    @Test
    void findAll()
    {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());
        Mockito.when(ownerRepository.findAll()).thenReturn(ownerSet);
        Set<Owner> owners = service.findAll();
        assertNotNull(owners);
        assertEquals(2,owners.size());
    }

    @Test
    void findById()
    {
        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(buildedOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }
    @Test
    void findByIdNotFound()
    {
        Mockito.when(ownerRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(1L);
        assertNull(owner);
    }
    @Test
    void save()
    {
        Owner owner = Owner.builder().id(1L).build();
        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(owner);
        Owner savedOwner = service.save(owner);
        assertNotNull(savedOwner);
        Mockito.verify(ownerRepository).save(Mockito.any());
    }

    @Test
    void delete()
    {
        service.delete(buildedOwner);
        Mockito.verify(ownerRepository,Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById()
    {
        service.deleteById(1L);
        Mockito.verify(ownerRepository).deleteById(Mockito.anyLong());
    }
}