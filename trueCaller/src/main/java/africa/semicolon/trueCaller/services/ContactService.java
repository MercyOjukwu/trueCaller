package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import java.util.List;
public interface ContactService {

    Contact findByFirstName(String firstName);
    Contact findByLastName(String lastName);
    Contact findById(String id);
    Contact updateContact(Contact contact, String firstName);
    void deleteContact(Contact contact);
    List<Contact> findByName(String name);
    void addContact(String firstName, String lastName, String phoneNumber);
}
