package com.company;
import com.sun.jdi.Value;

import java.util.*;
import java.lang.*;

class Account
{
    int revenue;
    String Accountname, CompanyName;

    // Constructor
    public Account(int revenue, String Accountname,
                   String CompanyName)
    {
        this.revenue = revenue;
        this.Accountname = Accountname;
        this.CompanyName = CompanyName;
    }
    public String getAccountname() {
        return Accountname;
    }
    public String getCompanyName() {
        return CompanyName;
    }
    public int getrevenue() {
        return revenue;
    }


    // Used to print student details in main()
    public String toString()
    {
        return this.revenue + " " + this.Accountname +
                " " + this.CompanyName;
    }

}


class Sortbyroll implements Comparator<Account>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Account a, Account b)
    {
        return a.revenue - b.revenue;
    }
}




//----------------------------------End Account------------------------------------------------------------------

class Contact
{
    int ContactTo, ReportsTo;
    String Contactname, CompanyName;

    // Constructor
    public Contact(int ContactTo, String Contactname,
                   String CompanyName, int ReportsTo)
    {
        this.ContactTo = ContactTo;
        this.Contactname = Contactname;
        this.CompanyName = CompanyName;
        this.ReportsTo = ReportsTo;
    }
    public int getContactTo(){
        return ContactTo;
    }
    public String getContactname(){
        return Contactname;
    }
    public String getCompanyName(){
        return CompanyName;
    }
    public int getReportsTo(){
        return ReportsTo;
    }

    // Used to print student details in main()
    public String toString()
    {
        return this.ContactTo + " " + this.Contactname +
                " " + this.CompanyName + " " + this.ReportsTo;
    }
}

//------------------------------------End Contact---------------------------------------------------------------

class Opportunity
{
    int CloseDate, Amount, Probability;
    String Accountname, Stage;

    // Constructor
    public Opportunity(int CloseDate, int Amount, String Accountname,
                   int Probability, String Stage)
    {
        this.CloseDate = CloseDate;
        this.Amount = Amount;
        this.Accountname = Accountname;
        this.Probability = Probability;
        this.Stage = Stage;
    }
    public String getStage(){
        return Stage;
    }
    public String getAccountname(){
        return Accountname;
    }
    public int getCloseDate(){
        return CloseDate;
    }
    public int getAmount(){
        return Amount;
    }
    public int getProbability(){
        return Probability;
    }


    // Used to print student details in main()
    public String toString()
    {
        return this.CloseDate + " " + this.Amount+ " " + this.Accountname +
                " " + this.Probability + " " + this.Stage;
    }
}
//---------------------------------------------------------End Opp---------------------------------------------



public class Main {
    public static void main(String[] args) {
        // write your code here
        //Account
        ArrayList<Account> ar = new ArrayList<Account>();
        ar.add(new Account(11100, "Ju", "Vmware"));
        ar.add(new Account(1310, "Ha", "TCS"));
        ar.add(new Account(12100, "Chi", "Infogain"));
        ar.add(new Account(000, "Zoe", "TCS"));
        ar.add(new Account(55500, "Kam Du", "LTI"));
        ar.add(new Account(900, "Parker", "Cong"));

        System.out.println("Unsorted");
        for (int k = 0; k < ar.size(); k++) {
            System.out.println(ar.get(k));
        }

        Collections.sort(ar, new Sortbyroll());

        System.out.println("\nSorted by revenue");
        for (int j = 0; j < ar.size(); j++) {
            System.out.println(ar.get(j));
        }
        System.out.println("\n Revenue > 1000");
        for (int i = 0; i < ar.size(); i++){
            if (ar.get(i).revenue > 1000){
                System.out.println(ar.get(i).getAccountname() + " " + ar.get(i).getCompanyName() + " " + ar.get(i).getrevenue());
            }
        }



        //Contact
        ArrayList<Contact> con = new ArrayList<Contact>();
        con.add(new Contact(1, "John", "Vmware",5));
        con.add(new Contact(5, "Woom", "TCS", 9));
        con.add(new Contact(9, "Nack", "InfoGain", 10));

        System.out.println("\n Mapping part");
        Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
        hm.put(con.get(0).ContactTo,con.get(0).ReportsTo);
        hm.put(con.get(1).ContactTo,con.get(1).ReportsTo);
        hm.put(con.get(2).ContactTo,con.get(2).ReportsTo);



        Integer Srconnection = 1;
        Integer Trconnection = 10;
        Integer Curconnection = Srconnection;
        if(Srconnection == Trconnection || Curconnection == null){
            System.out.println("Source and target connection are same//Invaild//");
        }else{
            while (Curconnection != null){
                if (Curconnection == Trconnection){
                    System.out.println("Reach Found");
                    break;
                }
                Curconnection = hm.get(Curconnection);
                System.out.println(Curconnection);
            }
        }


            //Opp
        ArrayList<Opportunity> opp = new ArrayList<>();
        opp.add(new Opportunity(1, 50000000, "bbb",80, "Prospecting"));
        opp.add(new Opportunity(3, 40000000, "aaa", 70, "Lead qualification"));
        opp.add(new Opportunity(2, 78690000, "ccc", 90, "Prospecting"));
        opp.add(new Opportunity(0, 40000000, "aaa", 70, "Opportunity won"));
        opp.add(new Opportunity(5, 35678900, "nnnn", 50, "Proposal"));
        opp.add(new Opportunity(9, 9000000, "mmm", 40, "Prospecting"));

        System.out.println("\n Stage == Prospecting");
        for (int i = 0; i < opp.size(); i++){
            if (opp.get(i).Stage == "Prospecting"){
                System.out.println(opp.get(i).getAccountname() + " " + opp.get(i).getProbability() + " " + opp.get(i).getStage());
            }
        }




    }
    }
