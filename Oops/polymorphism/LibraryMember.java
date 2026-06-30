// Problem 4: Smart Library Membership System
// Superclass LibraryMember

public abstract class LibraryMember {
    protected String memberName;
    protected String memberId;
    protected double outstandingFine;
    
    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.outstandingFine = 0;
    }
    
    // Abstract method - each membership type calculates fines differently
    public abstract double calculateFine(int overdueDays);
    
    public String getMemberName() {
        return memberName;
    }
    
    public String getMemberId() {
        return memberId;
    }
    
    public double getOutstandingFine() {
        return outstandingFine;
    }
    
    public void setOutstandingFine(double fine) {
        this.outstandingFine = fine;
    }
    
    public void printDetails() {
        System.out.println("Member Name: " + memberName);
        System.out.println("Member ID: " + memberId);
        System.out.println("Membership Type: " + this.getClass().getSimpleName());
        System.out.println("Outstanding Fine: Rs." + String.format("%.2f", outstandingFine));
    }
}
