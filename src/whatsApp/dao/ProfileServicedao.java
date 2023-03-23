package whatsApp.dao;

import whatsApp.model.Group;
import whatsApp.model.User;

import java.util.List;

public interface ProfileServicedao {
    User installWhatsApp(Group group);
    User goToProfile(Group group);
    void getAllWhatsAppStatus();
    String changeProfilePhoto(Group group);
    String changeWhatsappStatus(Group group);
    void addNewContact(Group group);
    void sendMessage(Group group);
    void deleteWhatsApp(Group group);
    void deleteContact(Group group);
    List<User> getAllContacts(Group group);

}
