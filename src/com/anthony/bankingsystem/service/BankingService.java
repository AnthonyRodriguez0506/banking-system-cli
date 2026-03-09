package com.anthony.bankingsystem.service;

import com.anthony.bankingsystem.repository.CustomerRepository;

public class BankingService {

    CustomerRepository repo;
    public BankingService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void initializeServices() {
        repo.initializeCustomers();
    }

    public Double withdraw (String ID, Double withdraw) {
        if (withdraw > repo.searchBalance(ID) || (repo.searchBalance(ID)) == 0) {
            System.out.println("Insufficient Balance");
            return 0.0;
        }
        return repo.searchBalance(ID) - withdraw;
    }

    public Double transfer (String IdSender, Double transfer, String IdReceiver) {
        if (transfer > repo.searchBalance(IdSender) || (repo.searchBalance(IdSender)) == 0) {
            System.out.println("Insufficient Balance");
            return 0.0;
        }
        repo.updateBalance(IdSender, repo.searchBalance(IdSender) - transfer);
        repo.updateBalance(IdReceiver, repo.searchBalance(IdReceiver) + transfer);
        return repo.searchBalance(IdSender);
    }

}
