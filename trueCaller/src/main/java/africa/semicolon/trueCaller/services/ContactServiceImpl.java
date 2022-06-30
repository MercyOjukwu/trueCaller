package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;

    List<Contact> contacts = new ArrayList<Contact>();

    public ContactServiceImpl() {

    }


//    @Override
//    public Contact save(Contact contact) {
////        contact.setId(contacts.size() + 1);
//        contacts.add(contact);
//        return contact;
//    }


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



    public Contact findById(String id){
        Optional<Contact> found = contactRepository.findById(id);
        if(found.isEmpty())throw new NullPointerException("Contact not found");
        return found.get();
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

    @Override
    public List<Contact> findByName(String name) {
        List<Contact> result = new ArrayList<>();
        result.addAll(contactRepository.findContactByFirstName(name));
        result.addAll(contactRepository.findContactByLastName(name));
        return result;
    }

    @Override
    public void addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName, lastName,phoneNumber);
//        contact.setId(contacts.size() + 1);
        contactRepository.save(contact);
    }

}
