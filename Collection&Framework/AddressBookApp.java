import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class AddressBookApp {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final HashMap<String, Contact> contactByName = new HashMap<>();
    private static final HashSet<String> phoneNumbers = new HashSet<>();

    public static void addContact(String name, String phone, String email) {
        if (contactByName.containsKey(name.toLowerCase())) {
            System.out.println("Contact with this name already exists.");
            return;
        }
        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate phone number is not allowed.");
            return;
        }

        Contact contact = new Contact(name, phone, email);
        contacts.add(contact);
        contactByName.put(name.toLowerCase(), contact);
        phoneNumbers.add(phone);
        System.out.println("Contact added successfully.");
    }

    public static void searchContact(String name) {
        Contact contact = contactByName.get(name.toLowerCase());
        if (contact == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println(contact);
        }
    }

    public static void deleteContact(String name) {
        Contact contact = contactByName.remove(name.toLowerCase());
        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        contacts.remove(contact);
        phoneNumbers.remove(contact.phone);
        System.out.println("Contact deleted successfully.");
    }

    public static void displaySortedContacts() {
        ArrayList<Contact> sortedContacts = new ArrayList<>(contacts);
        Collections.sort(sortedContacts, Comparator.comparing(contact -> contact.name.toLowerCase()));

        if (sortedContacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        for (Contact contact : sortedContacts) {
            System.out.println(contact);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts Sorted By Name");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    addContact(name, phone, email);
                    break;
                case 2:
                    System.out.print("Enter name to search: ");
                    searchContact(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter name to delete: ");
                    deleteContact(scanner.nextLine());
                    break;
                case 4:
                    displaySortedContacts();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
