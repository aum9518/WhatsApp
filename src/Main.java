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
                    """);
            int comand = new Scanner(System.in).nextInt();
            switch (comand){
                case 1:
                    System.out.println(profileService.installWhatsApp(group));break;
                case 2:
                    System.out.println(profileService.goToProfile(group));break;
                case 3: profileService.getAllWhatsAppStatus();break;
                case 4:
                    System.out.println(profileService.changeProfilePhoto(group));break;
                case 5:
                    System.out.println(profileService.changeWhatsappStatus(group));break;
                case 6: profileService.addNewContact(group);break;
                case 7: profileService.sendMessage(group);break;
                case 8: profileService.deleteWhatsApp(group);break;
                default:
                    System.out.println("Error");break;
            }

        }

    }
}