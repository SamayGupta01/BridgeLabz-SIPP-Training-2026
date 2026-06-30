// GuestMember class - Higher fine rates for guest members

public class GuestMember extends LibraryMember {
    private static final double FINE_PER_DAY = 15.0;
    private String visitorInstitution;
    
    public GuestMember(String memberName, String memberId, String visitorInstitution) {
        super(memberName, memberId);
        this.visitorInstitution = visitorInstitution;
    }
    
    @Override
    public double calculateFine(int overdueDays) {
        double fine = overdueDays * FINE_PER_DAY;
        setOutstandingFine(fine);
        return fine;
    }
    
    public String getVisitorInstitution() {
        return visitorInstitution;
    }
    
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Visitor Institution: " + visitorInstitution);
        System.out.println("Fine Rate: Rs." + FINE_PER_DAY + " per day (Guest Member)");
    }
}
