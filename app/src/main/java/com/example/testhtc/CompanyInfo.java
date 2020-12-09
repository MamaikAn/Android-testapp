package com.example.testhtc;

import java.util.ArrayList;

public class CompanyInfo {
    public Company company;

    public static class Company {
        public String name;
        public String age;
        public String[] competences;
        public ArrayList<Employees> employees;

        public static class Employees {
            public String name;
            public String phone_number;
            public String[] skills;
        }
    }
}
