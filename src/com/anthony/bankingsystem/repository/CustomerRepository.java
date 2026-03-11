package com.anthony.bankingsystem.repository;
import java.util.HashMap;

public class CustomerRepository {

        HashMap<String, String> users = new HashMap<>();
        HashMap<String, Double> balance = new HashMap<>();

        public HashMap<String, String> getUsers() {
                return users;
        }

        public void initializeCustomers() {
                users.put("402-1093656-9", "Anthony Rodríguez");
                users.put("031-8472651-3", "María Fernández");
                users.put("223-5647812-7", "Juan Martínez");
                users.put("054-9182736-5", "Ana López");
                users.put("402-7364519-2", "Pedro González");
                users.put("015-6829471-8", "Lucía Herrera");
                users.put("402-5719384-6", "Miguel Santana");
                users.put("031-7645291-4", "Sofía Castillo");
                users.put("223-8192735-1", "Diego Morales");
                users.put("054-6738291-9", "Valentina Pérez");

                balance.put("402-1093656-9", 12540.75);
                balance.put("031-8472651-3", 98320.50);
                balance.put("223-5647812-7", 45760.25);
                balance.put("054-9182736-5", 31090.80);
                balance.put("402-7364519-2", 76450.10);
                balance.put("015-6829471-8", 58930.65);
                balance.put("402-5719384-6", 14275.40);
                balance.put("031-7645291-4", 90860.90);
                balance.put("223-8192735-1", 67340.55);
                balance.put("054-6738291-9", 25010.35);
        }

        public String searchClient(String ID) {
                return users.get(ID);
        }

        public Double searchBalance(String ID) {
                return balance.get(ID);
        }

        public void updateBalance(String ID, Double newBalance) {
                balance.put(ID, newBalance);
        }
}