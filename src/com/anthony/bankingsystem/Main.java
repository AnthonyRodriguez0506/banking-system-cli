package com.anthony.bankingsystem;
import com.anthony.bankingsystem.repository.CustomerRepository;
import com.anthony.bankingsystem.service.BankingService;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepository() ;
        BankingService service = new BankingService(repo);
        repo.initializeCustomers();
        service.initializeServices();

        System.out.println(repo.searchClient("402-1093656-9"));
        System.out.println(repo.searchBalance("402-1093656-9"));
        System.out.println(repo.searchBalance("031-8472651-3"));
        System.out.println(service.transfer("402-1093656-9", 5000.0, "031-8472651-3"));
        System.out.println(repo.searchClient("031-8472651-3"));
        System.out.println(repo.searchBalance("031-8472651-3"));

    }
}
