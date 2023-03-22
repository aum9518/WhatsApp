package whatsApp.dao.Impl;

import whatsApp.dao.ProfileServicedao;
import whatsApp.exceptions.MyException;
import whatsApp.model.Group;
import whatsApp.model.User;

import java.util.*;

public class ProfileServiceImpldao implements ProfileServicedao {
    @Override
    public User installWhatsApp(Group group) {
        boolean isTrue = true;
        Map<String,String>map=new HashMap<>();
        User user = new User(map);

        System.out.print("Enter phone number: ");
        String number  = new Scanner(System.in).nextLine();
        try{
            if (!number.startsWith("+996") && !number.startsWith("0")){
                throw new MyException("Use country code or '0'");
            }
            if (!(number.length() ==10) && !(number.length() ==14)){
                throw new MyException("Numbers length must be 10 or 14 charachters");
            }
            user.setphoneNumber(number);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Enter user name: ");
        String name = new Scanner(System.in).nextLine();
        if (!group.getUsers().isEmpty()){
            for (User a: group.getUsers()) {
                if (!a.getFirstName().equals(name)){
                    isTrue = true;
                    user.setFirstName(name);
                    System.out.print("Enter password: ");
                    String password = new Scanner(System.in).nextLine();
                    try {
                        if (password.length() < 7) {
                            throw new MyException("Password length must be 7 charachters");

                        }
                        user.setPassword(password);
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    user.setId(group.getUsers().size()+1);
                    group.getUsers().add(user);
                    return user;
                }else {
                    isTrue = false;
                    break;
                }
            }
        }else {
            user.setFirstName(name);
            System.out.print("Enter password: ");
            String password = new Scanner(System.in).nextLine();
            try {
                if (password.length() < 7) {
                    throw new MyException("Password length must be 7 charachters");

                }
                user.setPassword(password);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
            user.setId(group.getUsers().size()+1);
            group.getUsers().add(user);
            return user;
        }
        try{
            if (!isTrue){
                throw new MyException("Same user name");

            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }


        return null;
    }

    @Override
    public User goToProfile(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        System.out.println("Enter user name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    return a;
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Incorrect user name!");
            }
            if (!isTrue1){
                throw new MyException("Incorrect password");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void getAllWhatsAppStatus() {

    }

    @Override
    public String changeProfilePhoto(Group group) {
        return null;
    }

    @Override
    public String changeWhatsappStatus(Group group) {
        return null;
    }

    @Override
    public void addNewContact(Group group) {

    }

    @Override
    public void sendMessage(Group group) {

    }

    @Override
    public void deleteWhatsApp(Group group) {

    }
}
