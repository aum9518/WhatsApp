package whatsApp.service.impl;

import whatsApp.dao.Impl.ProfileServiceImpldao;
import whatsApp.model.Group;
import whatsApp.model.User;
import whatsApp.service.ProfileService;

import java.util.List;

public class ProfileServiceImpl implements ProfileService {
    ProfileServiceImpldao profileServiceImpldao = new ProfileServiceImpldao();
    @Override
    public User installWhatsApp(Group group) {
        return profileServiceImpldao.installWhatsApp(group);
    }

    @Override
    public User goToProfile(Group group) {
        return profileServiceImpldao.goToProfile(group);
    }

    @Override
    public void getAllWhatsAppStatus() {
        profileServiceImpldao.getAllWhatsAppStatus();
    }

    @Override
    public String changeProfilePhoto(Group group) {
        return profileServiceImpldao.changeProfilePhoto(group);
    }

    @Override
    public String changeWhatsappStatus(Group group) {
        return profileServiceImpldao.changeWhatsappStatus(group);
    }

    @Override
    public void addNewContact(Group group) {
        profileServiceImpldao.addNewContact(group);
    }

    @Override
    public void sendMessage(Group group) {
        profileServiceImpldao.sendMessage(group);
    }

    @Override
    public void deleteWhatsApp(Group group) {
        profileServiceImpldao.deleteWhatsApp(group);

    }

    @Override
    public void deleteContact(Group group) {
        profileServiceImpldao.deleteContact(group);
    }

    @Override
    public List<User> getAllContacts(Group group) {
        return profileServiceImpldao.getAllContacts(group);
    }

    @Override
    public User updatePhoneNumber(Group group) {
        return profileServiceImpldao.updatePhoneNumber(group);
    }
}
