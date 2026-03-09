package com.anthony.bankingsystem;
import com.anthony.bankingsystem.repository.CustomerRepository;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepository();

        repo.initializeCustomers();
        System.out.println(repo.searchClient("402-1093656-9"));
        System.out.println(repo.searchBalance("402-1093656-9"));

    }
}
