package whatsApp.dao.Impl;

import whatsApp.dao.ProfileServicedao;
import whatsApp.enums.Gender;
import whatsApp.enums.Status;
import whatsApp.exceptions.MyException;
import whatsApp.model.Group;
import whatsApp.model.User;

import java.util.*;

public class ProfileServiceImpldao implements ProfileServicedao {
    @Override
    public User installWhatsApp(Group group) {
        boolean isTrue = true;
        List<Map<String,String>>map=new ArrayList<>();
        List<User>userList=new ArrayList<>();
        User user = new User(map,userList);
        boolean istrue = true;

    System.out.print("Enter phone number: ");
    String number = new Scanner(System.in).nextLine();
    try {
        if (!number.startsWith("+996") && !number.startsWith("0")) {
            throw new MyException("Use country code or '0'");
        }else {
            if (!(number.length() == 10) && !(number.length() == 14)) {
                throw new MyException("Numbers length must be 10 or 14 charachters");
            }else {
                user.setphoneNumber(number);
                System.out.print("Enter user name: ");
                String name = new Scanner(System.in).nextLine();
                if (!group.getUsers().isEmpty()) {
                    for (User a : group.getUsers()) {
                        if (!a.getFirstName().equals(name)) {
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
                            System.out.println("Enter gender(male/female)");
                            String gender = new Scanner(System.in).nextLine().toUpperCase();
                            user.setGender(Gender.valueOf(gender));
                            user.setId(group.getUsers().size() + 1);
                            group.getUsers().add(user);
                            return user;
                        } else {
                            isTrue = false;
                            break;
                        }
                    }
                } else {
                    user.setFirstName(name);
                    System.out.print("Enter password: ");
                    String password = new Scanner(System.in).nextLine();
                    try {
                        if (password.length() < 7) {
                            throw new MyException("Password length must be 7 charachters");

                        }
                        user.setPassword(password);
                        System.out.println("Enter gender(male/female)");
                        String gender = new Scanner(System.in).nextLine().toUpperCase();
                        user.setGender(Gender.valueOf(gender));
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    user.setId(group.getUsers().size() + 1);
                    group.getUsers().add(user);
                    return user;
                }
                try {
                    if (!isTrue) {
                        throw new MyException("User name already has been taken!");

                    }
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }
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
        int counter = 0;
        for (Status a:Status.values()) {
            counter++;
            System.out.println(counter+"->"+a);
        }
    }

    @Override
    public String changeProfilePhoto(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    System.out.println("Put photo link here: ");
                    a.setImege(new Scanner(System.in).nextLine());
                    System.out.println(a);
                    return "Successfully changed!";
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Invalid user name!");
            }
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String changeWhatsappStatus(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    int counter = 0;
                    for (Status n:Status.values()) {
                        counter++;
                        System.out.println(counter+"->"+n);
                    }
                    int num = new Scanner(System.in).nextInt();
                    switch (num){
                        case 1:a.setStatus(Status.I_AM_USING_WHATSAPP) ;break;
                        case 2:a.setStatus(Status.TO_THE_CINEMA);break;
                        case 3:a.setStatus(Status.BUSY);break;
                        case 4:a.setStatus(Status.WORK);break;
                        case 5:a.setStatus(Status.WORkOUT);break;
                        default:
                            System.out.println("Error");break;
                    }
                    return "Saccessfully changed";
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Invalid user name!");
            }
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addNewContact(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        boolean isTrue2 = true;
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    System.out.println("Enter phone number: ");
                    String number  = new Scanner(System.in).nextLine();
                    try{
                        if (!number.startsWith("+996") && !number.startsWith("0")){
                            throw new MyException("Use country code or '0'");
                        }
                        if (!(number.length() ==10) && !(number.length() ==14)){
                            throw new MyException("Numbers length must be 10 or 14 charachters");
                        }
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    for (User x: group.getUsers()) {
                        if (x.getPhoneNumber().equals(number)){
                            isTrue2=true;
                            a.getList().add(x);
                            System.out.println("Successfully saved! ");
                            break;
                        }else {
                            isTrue2=false;
                        }
                    }
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Invalid user name!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        try{
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
            if (!isTrue2){
                throw new MyException("The number does not exist");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void sendMessage(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        List<Map<String,String>>list = new ArrayList<>();
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    System.out.println("Your contacts: ");
                    for (User c:a.getList()) {
                        System.out.println(c.getFirstName());
                    }
                    System.out.println("Choose one of them: ");
                    String userName = new  Scanner(System.in).nextLine();
                    for (User d:a.getList()) {
                        if (d.getFirstName().equals(userName)){
                           System.out.println(d.getMessages());
                            //System.out.println(list);
                        }
                    }
                    System.out.println("Enter the message: ");
                    String message = new Scanner(System.in).nextLine();
                    System.out.println("Do you want to send it(yes/no)?");
                    String answer = new Scanner(System.in).nextLine();
                    for (User d:a.getList()) {
                        Map<String,String>map=new HashMap<>();
                        if (d.getFirstName().equals(userName)){
                          //  System.out.println(d.getMessages());

                            if (answer.contains("yes")){
                                map.put(a.getFirstName(),message);
                                a.getMessages().add(map);

                              //  list=a.getMessages().entrySet().stream().toList();
                               // list.add(a.getMessages());
                            } else if (answer.contains("no")) {
                                System.out.println("Your message was not sent!");
                            }
                        }
                    }
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Invalid user name!");
            }
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
        } catch (MyException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteWhatsApp(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    group.getUsers().remove(a);
                    System.out.println("Successfully deleted!");
                    break;
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Invalid user name!");
            }
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
        } catch (MyException | ConcurrentModificationException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteContact(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        boolean isTrue2 = true;
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    System.out.println("Enter phone number: ");
                    String number  = new Scanner(System.in).nextLine();
                    try{
                        if (!number.startsWith("+996") && !number.startsWith("0")){
                            throw new MyException("Use country code or '0'");

                        }
                        if (!(number.length() ==10) && !(number.length() ==14)){
                            throw new MyException("Numbers length must be 10 or 14 charachters");

                        }
                        break;
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    for (User t:a.getList()) {
                        if (t.getPhoneNumber().equals(number)){
                            isTrue2=true;
                            a.getList().remove(t);
                            System.out.println("Successfully deleted!");
                        }else {
                            isTrue2=false;
                        }
                    }

                    break;
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Invalid user name!");
            }
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
            if (!isTrue2){
                throw new MyException("The contact number does not exist");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> getAllContacts(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    return a.getList();
                }else {
                    isTrue1 = false;
                }
            }else {
                isTrue = false;
            }
        }
        try{
            if (!isTrue){
                throw new MyException("Invalid user name!");
            }
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public User updatePhoneNumber(Group group) {
        boolean isTrue = true;
        boolean isTrue1 = true;
        System.out.println("Enter user name:");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter password");
        String password = new Scanner(System.in).nextLine();
        for (User a: group.getUsers()) {
            if (a.getFirstName().equals(name)){
                isTrue = true;
                if (a.getPassword().equals(password)){
                    isTrue1 = true;
                    System.out.println("Enter new phone number: ");
                    String number  = new Scanner(System.in).nextLine();
                    try{
                        if (!number.startsWith("+996") && !number.startsWith("0")){
                            throw new MyException("Use country code or '0'");
                        }
                        if (!(number.length() ==10) && !(number.length() ==14)){
                            throw new MyException("Numbers length must be 10 or 14 charachters");
                        }
                    } catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                    a.setphoneNumber(number);
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
                throw new MyException("Invalid user name!");
            }
            if (!isTrue1){
                throw new MyException("Invalid password!");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
