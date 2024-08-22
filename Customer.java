package com.hexaware;

import java.util.*;
import java.text.SimpleDateFormat;

class Customer {
    int custId;
    String custName;
    String city;
    double premium;
    Date dateOfBirth;

    Customer(int custId, String custName, String city, double premium, Date dateOfBirth) {
        this.custId = custId;
        this.custName = custName;
        this.city = city;
        this.premium = premium;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return "Customer ID: " + custId + ", Name: " + custName + ", City: " + city + 
               ", Premium: " + premium + ", Date of Birth: " + sdf.format(dateOfBirth);
    }

    public static void main(String[] args) throws Exception {
        List<Customer> customers = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        customers.add(new Customer(1, "Prasanna", "Pondicherry", 90000, sdf.parse("29-04-2003")));
        customers.add(new Customer(2, "Raguram", "Mumbai", 75000, sdf.parse("22-07-1990")));
        customers.add(new Customer(3, "Ram", "Delhi", 85000, sdf.parse("05-11-1987")));
        customers.add(new Customer(4, "Pravin", "Chennai", 60000, sdf.parse("17-05-1993")));
        customers.add(new Customer(5, "Sabari", "Kolkata", 92000, sdf.parse("12-08-1984")));
        customers.add(new Customer(6, "Virat", "Delhi", 82000, sdf.parse("09-03-1986")));
        customers.add(new Customer(7, "Vishnu", "Bangalore", 78000, sdf.parse("25-12-1989")));
        customers.add(new Customer(8, "Karthick", "Mumbai", 89000, sdf.parse("30-09-1982")));
        customers.add(new Customer(9, "balaji", "Delhi", 94000, sdf.parse("07-04-1991")));
        customers.add(new Customer(10, "Sachin", "Hyderabad", 70000, sdf.parse("01-11-1988")));

        
        customers.forEach(System.out::println);

        System.out.println("\nCustomers with premium > 80000:");
        customers.stream().filter(c -> c.premium > 80000).forEach(System.out::println);

        System.out.println("\nCustomers from Delhi:");
        customers.stream().filter(c -> c.city.equalsIgnoreCase("Delhi")).forEach(System.out::println);

        System.out.println("\nCustomers sorted by Date of Birth:");
        customers.stream().sorted(Comparator.comparing(c -> c.dateOfBirth))
                 .forEach(System.out::println);

        System.out.println("\nCustomers sorted by Name:");
        customers.stream().sorted(Comparator.comparing(c -> c.custName))
                 .forEach(System.out::println);
    }
}
