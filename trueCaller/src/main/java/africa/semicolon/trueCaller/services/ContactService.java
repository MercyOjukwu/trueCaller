package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

public interface ContactService {

    Contact save(Contact contact);
    int count();
    Contact findByFirstName(String firstName);
    Contact findByLastName(String lastName);
    Contact findById(int id);
    Contact updateContact(Contact contact, String firstName);
    void deleteContact(Contact contact);

    void addContact(String firstName, String lastName, String phoneNumber);
}
