package oops.Generic;

import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private final String title;
    private final int minimumExperience;

    JobRole(String title, int minimumExperience) {
        this.title = title;
        this.minimumExperience = minimumExperience;
    }

    public String getTitle() {
        return title;
    }

    public int getMinimumExperience() {
        return minimumExperience;
    }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer() {
        super("Software Engineer", 2);
    }
}

class DataScientist extends JobRole {
    DataScientist() {
        super("Data Scientist", 3);
    }
}

class ProductManager extends JobRole {
    ProductManager() {
        super("Product Manager", 4);
    }
}

class Resume<T extends JobRole> {
    private final String candidateName;
    private final int experience;
    private final T role;

    Resume(String candidateName, int experience, T role) {
        this.candidateName = candidateName;
        this.experience = experience;
        this.role = role;
    }

    public boolean isShortlisted() {
        return experience >= role.getMinimumExperience();
    }

    public T getRole() {
        return role;
    }

    @Override
    public String toString() {
        return candidateName + " applied for " + role.getTitle()
                + " | Experience: " + experience + " years"
                + " | Status: " + (isShortlisted() ? "Shortlisted" : "Rejected");
    }
}

public class ResumeScreeningSystem {
    public static <T extends JobRole> void processResume(Resume<T> resume) {
        System.out.println(resume);
    }

    public static void displayRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println(role.getTitle() + " needs " + role.getMinimumExperience() + "+ years");
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareResume = new Resume<>("Riya", 3, new SoftwareEngineer());
        Resume<DataScientist> dataResume = new Resume<>("Kabir", 2, new DataScientist());
        Resume<ProductManager> managerResume = new Resume<>("Neha", 5, new ProductManager());

        processResume(softwareResume);
        processResume(dataResume);
        processResume(managerResume);

        List<JobRole> roles = new ArrayList<>();
        roles.add(softwareResume.getRole());
        roles.add(dataResume.getRole());
        roles.add(managerResume.getRole());

        System.out.println("Screening pipeline roles:");
        displayRoles(roles);
    }
}
