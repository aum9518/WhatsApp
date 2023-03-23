package whatsApp.model;

import whatsApp.enums.Gender;
import whatsApp.enums.Status;

import java.util.List;
import java.util.Map;

public class User {
    private int id;
    private String firstName;
    private String phoneNumber;
    private String password;
    private Gender gender;
    private String imege = "'DEFAULT IMAGE'";
    private Status status = Status.I_AM_USING_WHATSAPP;
    private List<Map<String,String>> messages;
    private List<User>list;

    public User() {
    }

    public User(List<Map<String, String>> messages, List<User> list) {
        this.messages = messages;
        this.list = list;
    }

    public User(List<Map<String, String>> messages) {
        this.messages = messages;
    }

    public User(int id, String firstName, String phoneNumber, String password, String imege, Status status, List<Map<String, String>> messages, List<User> list) {
        this.id = id;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.imege = imege;
        this.status = status;
        this.messages = messages;
        this.list = list;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getphoneNumber(){
        return phoneNumber;
    }
    public void setphoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getImege(){
        return imege;
    }
    public void setImege(String image){
        this.imege=image;
    }
    public Status getStatus(){
        return status;
    }
    public void setStatus(Status status){
        this.status=status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Map<String, String>> getMessages() {
        return messages;
    }

    public void setMessages(List<Map<String, String>> messages) {
        this.messages = messages;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "" +
                "\nid=" + id +
                "\n firstName = '" + firstName + '\'' +
                "\n phoneNumber = '" + phoneNumber + '\'' +
                "\n password = '" + password + '\'' +
                "\n imege =' " + imege + '\'' +
                "\n status = " + status +
                "\n gender = " + gender +
                "\n messages = " + messages +
                ' ';
    }
}
