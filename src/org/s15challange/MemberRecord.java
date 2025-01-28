package org.s15challange;


import java.util.Date;

public abstract class MemberRecord {
    private int memberId;
    private String type;  // Öğrenci veya akademik personel
    private Date dateOfMembership;
    private int noBooksIssued;  // Ödünç alınan kitap sayısı
    private int maxBookLimit;  // Maksimum kitap ödünç alma limiti
    private String name;
    private String address;
    private String phoneNo;

    // Constructor
    public MemberRecord(int memberId, String type, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.noBooksIssued = 0;
    }

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

    // Getter ve Setter metodları
    public int getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return 5;
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
}
