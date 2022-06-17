package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{

    List<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        contact.setId(contacts.size() + 1);
        contacts.add(contact);
        return contact;
    }

    @Override
    public int count() {
        return contacts.size();
    }

    @Override
    public Contact findByFirstName(String firstName) {
        for(Contact contact: contacts){
            if(firstName.equals(contact.getFirstName())){
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findByLastName(String lastName) {
        for(Contact contact: contacts){
            if(lastName.equals(contact.getLastName())){
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }
}
