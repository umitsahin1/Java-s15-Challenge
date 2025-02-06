package org.s15challange;
import java.util.Date;
import java.util.Objects;

public abstract class MemberRecord {
    private int memberId;
    private Type type;
    private Date dateOfMembership;
    private int noBooksIssued;  // Ödünç alınan kitap sayısı
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;


    // Constructor
    public MemberRecord(int memberId, Type type, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.noBooksIssued = 0;
        this.maxBookLimit = 5;
        this.dateOfMembership = new Date();
    }

    public MemberRecord() {
    }

    // Getter ve Setter Metodları
    public int getMemberId() {
        return memberId;
    }

    public Type getType() {
        return type;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }


    //Methods

    // Ödünç alınan kitap sayısını artıran metot
    public void incBookIssued() {
        if (noBooksIssued < maxBookLimit) {
            noBooksIssued++;
        } else {
            System.out.println("Maximum 5 books allowed!");
        }
    }

    // Ödünç alınan kitap sayısını azaltan metot
    public void decBookIssued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        } else {
            System.out.println("No books to return.");
        }
    }

    // Üyenin bilgilerini döndüren metot
    public String getMember() {
        return "Member ID: " + memberId + ", Name: " + name + ", Type: " + type;
    }

    // Fatura ödeme metodu
    public void payBill(double amount) {
        System.out.println(name + " paid a bill of " + amount);
    }



    @Override
    public String toString() {
        return "MemberRecord{" +
                "memberId=" + memberId +
                ", type=" + type +
                ", dateOfMembership=" + dateOfMembership +
                ", noBooksIssued=" + noBooksIssued +
                ", maxBookLimit=" + maxBookLimit +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MemberRecord that)) return false;
        return memberId == that.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memberId);
    }
}
