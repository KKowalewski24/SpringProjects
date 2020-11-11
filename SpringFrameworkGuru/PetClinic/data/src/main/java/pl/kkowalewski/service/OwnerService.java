package pl.kkowalewski.service;

import pl.kkowalewski.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
