import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact newContact){
        if(findContact(newContact) < 0) {
            myContacts.add(newContact);
            return true;
        }
        return false;
    }

    public void modifyContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if(position >= 0)
            myContacts.set(position, newContact);

    }

    public void removeContact(Contact oldContact){
        if(findContact(oldContact) >= 0)
            myContacts.remove(oldContact);
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >=0)
            return myContacts.get(position);
        return null;
    }

    private int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    private int findContact(String data){
        for (int i = 0; i<myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            if(contact.getName().equals(data) || contact.getNumber().equals(data))
                return i;
        }
        return -1;
    }

    public boolean isRepeated(String data){
        int alreadyExist = findContact(data);
        return (alreadyExist >= 0);
    }

    public void printContact(){
        for (Contact myContact : myContacts)
            System.out.println("Nazwa: " + myContact.getName() + " numer: " + myContact.getNumber());
        /*
        for(int i = 0; i<myContact.size(); i++){
            System.out.println("Nazwa: " + myContacts.get(i).getName() + " numer: " + myContacts.get(i).getNumber());
        }
         */
    }
}

