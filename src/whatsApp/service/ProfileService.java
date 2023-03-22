package whatsApp.service;

import whatsApp.model.Group;
import whatsApp.model.User;

public interface ProfileService {
        User installWhatsApp(Group group);
        User goToProfile(Group group);
        void getAllWhatsAppStatus();
        String changeProfilePhoto(Group group);
        String changeWhatsappStatus(Group group);
        void addNewContact(Group group);
        void sendMessage(Group group);
        void deleteWhatsApp(Group group);
}
