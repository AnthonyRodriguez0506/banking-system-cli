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

    public void reportEveryClients () {

        double minBalance = Double.MAX_VALUE;
        double maxBalance = Double.MIN_VALUE;
        String maxBalanceId = "";
        String minBalanceId = "";

        System.out.println("REPORTE DE BALANCE DE USUARIOS");
        for (String id:repo.getUsers().keySet()) {

            if (repo.searchBalance(id) > maxBalance) {
                maxBalanceId = repo.searchClient(id);
                maxBalance = repo.searchBalance(id);
            }

            if (repo.searchBalance(id) < minBalance) {
                minBalanceId = repo.searchClient(id);
                minBalance = repo.searchBalance(id);
            }
            System.out.println("--------------------");
            System.out.println(id);
            System.out.println(repo.searchClient(id));
            System.out.println("RD$" + repo.searchBalance(id));
        }
//        System.out.println(maxBalanceId); Print the user with the highest balance
//        System.out.println(minBalanceId); Print the user with the lowest balance
    }
}
