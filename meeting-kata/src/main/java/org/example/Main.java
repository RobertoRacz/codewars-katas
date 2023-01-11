package org.example;

public class Main {
    public static void main(String[] args) {
       GuestLister guestLister = new GuestLister();

       guestLister.listGuests("Alexis:Wahl;John:Bell;");
    }
}