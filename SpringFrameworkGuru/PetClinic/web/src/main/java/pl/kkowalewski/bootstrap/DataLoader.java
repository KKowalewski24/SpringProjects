package pl.kkowalewski.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kkowalewski.model.*;
import pl.kkowalewski.service.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    /*------------------------ FIELDS REGION ------------------------*/
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;
    private final PetService petService;
    private LocalDate today = LocalDate.now();

    /*------------------------ METHODS REGION ------------------------*/
    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService, SpecialityService specialityService,
                      VisitService visitService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
        this.petService = petService;
    }

    private Owner prepareOwner(String firstName, String lastName, String address, String city,
                               String telephoneNumber) {
        Owner owner = new Owner(firstName, lastName, address, city, telephoneNumber);
        ownerService.save(owner);

        return owner;
    }

    private Vet prepareVet(String firstName, String lastName, Set<Speciality> specialities) {
        Vet vet = new Vet(firstName, lastName, specialities);
        vetService.save(vet);

        return vet;
    }

    private PetType preparePetType(String type) {
        PetType petType = new PetType(type);
        petTypeService.save(petType);

        return petType;
    }

    private Pet preparePet(String name, PetType type, Owner owner, LocalDate localDate) {
        Pet pet = new Pet(name, type, owner, localDate);
        petService.save(pet);
        owner.getPets().add(pet);

        return pet;
    }

    private Visit prepareVisit(LocalDate date, String description, Pet pet) {
        Visit visit = new Visit(date, description, pet);
        visitService.save(visit);

        return visit;
    }

    private Speciality prepareSpeciality(String type) {
        Speciality speciality = new Speciality(type);
        specialityService.save(speciality);

        return speciality;
    }

    private Set<Speciality> prepareSpecialitySet(String... types) {
        Set<Speciality> specialities = new HashSet<>();

        for (String it : types) {
            specialities.add(prepareSpeciality(it));
        }

        return specialities;
    }

    private void loadData() {
        PetType dog = preparePetType("dog");
        PetType cat = preparePetType("cat");

        Owner kamil = prepareOwner("Kamil", "Kowalewski", "rrr", "ttt", "yyy");
        Owner jan = prepareOwner("Jan", "Kowalski", "eee", "rrrr", "bgbgfbgf");

        Vet lord = prepareVet("Lord", "Vader", prepareSpecialitySet("Surgery"));
        Vet winnie = prepareVet("Winnie", "Pooh", prepareSpecialitySet("Radiology", "gbgbg"));

        Pet kamilPet = preparePet("kamilPet", dog, kamil, today.minusMonths(5));
        Pet janPet = preparePet("janPet", cat, jan, today.minusMonths(8));

        Visit catVisit = prepareVisit(today, "Heart attack", janPet);
    }

    @Override
    public void run(String... args) throws Exception {
        int counter = petTypeService.findAll().size();

        if (counter == 0) {
            loadData();
        }
    }

}
