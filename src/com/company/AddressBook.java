package com.company;

import java.io.*;
import java.util.HashMap;

public class AddressBook {
    HashMap<String, String> contacts = new HashMap<>();
    String filename;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;

    public AddressBook(){
        this.filename = "";
        bufferedReader = null;
    }

    public void load(){
        this.filename = "files/contacts.txt";
        this.bufferedReader = null;
        this.bufferedWriter = null;

        try {
            this.bufferedReader = new BufferedReader(new FileReader(filename));
            String contact, name, phone;
            while ((contact = bufferedReader.readLine()) != null) {
                phone = contact.substring(0, contact.indexOf(','));
                name = contact.substring(contact.indexOf(',')+1);

                this.contacts.put(phone, name);
            }
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (this.bufferedReader != null) {
                    this.bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }

    }

    public void list(){
        System.out.println("Contacts:");
        contacts.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }

    public void create(String name, String tel){
        this.contacts.put(tel, name);
    }

    public void delete(String tel){
        this.contacts.remove(tel);
    }

    public void save(){

        try {
            this.bufferedWriter = new BufferedWriter(new FileWriter(filename));

            this.contacts.entrySet().forEach(entry->{
                String line;
                line = entry.getKey() + "," + entry.getValue();
                try {
                    bufferedWriter.write(line + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (this.bufferedWriter != null) {
                    this.bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

}
