package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    List<Contact> contacts = new ArrayList<Contact>();


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
    public Contact findById(int id){
        return contacts.get(id - 1);
    }

    @Override
    public Contact updateContact(Contact contact, String firstName) {
        contacts.remove(contact);
        contacts.add(contact);
        contact.setFirstName(firstName);
        return contact;
    }

    @Override
    public void deleteContact(Contact contact) {
        contacts.remove(contact);
    }
}
