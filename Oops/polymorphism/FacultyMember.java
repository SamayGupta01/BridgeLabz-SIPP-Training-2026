// FacultyMember class - Standard fine rates for faculty

public class FacultyMember extends LibraryMember {
    private static final double FINE_PER_DAY = 10.0;
    private String departmentName;
    
    public FacultyMember(String memberName, String memberId, String departmentName) {
        super(memberName, memberId);
        this.departmentName = departmentName;
    }
    
    @Override
    public double calculateFine(int overdueDays) {
        double fine = overdueDays * FINE_PER_DAY;
        setOutstandingFine(fine);
        return fine;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Department: " + departmentName);
        System.out.println("Fine Rate: Rs." + FINE_PER_DAY + " per day (Standard)");
    }
}
