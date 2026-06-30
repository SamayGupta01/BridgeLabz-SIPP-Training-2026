// StudentMember class - Discounted fine rates for students

public class StudentMember extends LibraryMember {
    private static final double FINE_PER_DAY = 5.0;
    private String collegeName;
    
    public StudentMember(String memberName, String memberId, String collegeName) {
        super(memberName, memberId);
        this.collegeName = collegeName;
    }
    
    @Override
    public double calculateFine(int overdueDays) {
        double fine = overdueDays * FINE_PER_DAY;
        setOutstandingFine(fine);
        return fine;
    }
    
    public String getCollegeName() {
        return collegeName;
    }
    
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("College: " + collegeName);
        System.out.println("Fine Rate: Rs." + FINE_PER_DAY + " per day (Student Discount)");
    }
}
