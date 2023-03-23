import whatsApp.model.Group;
import whatsApp.model.User;
import whatsApp.service.impl.ProfileServiceImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<User>userList=new HashSet<>();
        Group group = new Group(userList);
        ProfileServiceImpl profileService = new ProfileServiceImpl();

        while (true) {
            System.out.println("""
                    >>>>>Choose comand<<<<<
                    1.Install WhatsApp
                    2.Go to profile
                    3.Get all WatsApp status
                    4.Change profile photo
                    5.Change WhatsApp status
                    6.Add contact
                    7.Send message
                    8.Delete WhatsApp
                    9.Delete contact
                    10.Get all contacts
                    """);
            int comand = new Scanner(System.in).nextInt();
            switch (comand){
                case 1-> System.out.println(profileService.installWhatsApp(group));
                case 2-> System.out.println(profileService.goToProfile(group));
                case 3-> profileService.getAllWhatsAppStatus();
                case 4-> System.out.println(profileService.changeProfilePhoto(group));
                case 5-> System.out.println(profileService.changeWhatsappStatus(group));
                case 6-> profileService.addNewContact(group);
                case 7-> profileService.sendMessage(group);
                case 8-> profileService.deleteWhatsApp(group);
                case 9-> profileService.deleteContact(group);
                case 10-> System.out.println(profileService.getAllContacts(group));
                default->System.out.println("Error");
            }

        }

    }
}