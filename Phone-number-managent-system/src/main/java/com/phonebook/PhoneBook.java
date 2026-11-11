package com.phonebook;
import com.phonebook.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook extends Phone {
    private List<String> phoneList = new ArrayList<>();
    @Override

    // save type: `name : 0123456789`
    public void insertPhone(String name, String phone){
        for (int i = 0; i < phoneList.size(); i++){
            String[] parts = phoneList.get(i).split(" : ");
            String existingName = parts[0];

//            System.out.println(parts[1]);
            if (existingName.equalsIgnoreCase(name)){
                if (parts[1].equals(phone)){
                    System.out.println("Existed");
                    return;
                }

                phoneList.set(i, phoneList.get(i) + " : " + phone);
                System.out.println("Added");
                return;
            }
        }

        phoneList.add(name + " : " + phone);
        System.out.println("Added");
    }
    @Override
    public void removePhone(String name){
        for (int i=0 ; i< phoneList.size(); i ++){
            String[] parts = phoneList.get(i).split(" : ");
            String existingName = parts[0];

            if (existingName.equalsIgnoreCase(name)) {
                phoneList.remove(i);
                System.out.println("Removed");
                return;
            }
        }
        System.out.println("User name does not exist");
    }
    @Override
    public void updatePhone(String name, String newphone){
        for (int i = 0; i < phoneList.size(); i++){
            String[] parts = phoneList.get(i).split(" : ");
            String existingName = parts[0];

            if (existingName.equalsIgnoreCase(name)){
                phoneList.set(i, existingName + " : " + newphone);
                System.out.println("Updated");
                return;
            }
        }
        System.out.println("User name not matches");
    }

    @Override
    public void searchPhone(String name){
        for( int i= 0; i< phoneList.size(); i++){
            String[] parts = phoneList.get(i).split(" : ");
            String existingName = parts[0];

            if (existingName.equalsIgnoreCase(name)){
                System.out.println("Your phone number: " + parts[1]);
                return;
            }
        }
        System.out.println("User name does not exist.");
    }
    @Override
    public void sort(){
        phoneList.sort((a,b)->{
            String nameA = a.split(" : ")[0];
            String nameB = b.split(" : ")[0];

            // nameA.compareToIgnoreCase(nameB)
            // nameA >< nameB
            // < 0: nameA > nameB
            // = 0: nameA same as nameB
            // > 0: nameB > nameA
            return nameA.compareToIgnoreCase(nameB);
        });

        System.out.println("Sorted");
        displayPhoneList();
    }

    public void displayPhoneList(){
        if (phoneList.isEmpty()){
            System.out.println("Empty");
        }

        for (String contact: phoneList){
            System.out.println(contact);
        }
    }
}
