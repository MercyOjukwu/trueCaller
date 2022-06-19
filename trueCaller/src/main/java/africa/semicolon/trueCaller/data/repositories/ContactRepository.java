package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

public interface ContactRepository {
    Contact save(Contact contact);
    int count();
    Contact findByFirstName(String firstName);
    Contact findByLastName(String lastName);
    Contact findById(int id);
    Contact updateContact(Contact contact, String firstName);
    void deleteContact(Contact contact);
}
