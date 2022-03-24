/*
Create a java project “ Employee Management System” to manage the employees in a company using MySQL database .
Database name : CompanyDb
•	Add the Employees ( empCode, name, phone, email, designation, salary, company name, address,  )
•	View All employees

 */

package com.Harman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Enter the option:");
            System.out.println("1.Add the Employees:");
            System.out.println("2.View all the Employees:");
            System.out.println("3.Exit:");
            option = s.nextInt();

            switch (option) {

                case 1: {
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/CompanyDb?autoReconnect=true&useSSL=false", "root", "");
                        String empCode, name, phone, email, designation, salary, companyname, address;
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Enter the empCode:");
                        empCode = sc.nextLine();
                        System.out.println("Enter the name:");
                        name = sc.nextLine();
                        System.out.println("Enter the phone:");
                        phone = sc.nextLine();
                        System.out.println("Enter the email:");
                        email = sc.nextLine();
                        System.out.println("Enter the designation:");
                        designation = sc.nextLine();
                        System.out.println("Enter the salary:");
                        salary = sc.nextLine();
                        System.out.println("Enter the companyname:");
                        companyname = sc.nextLine();
                        System.out.println("Enter the address:");
                        address = sc.nextLine();
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employee`(`empCode`, `name`, `phone`, `email`, `designation`, `salary`, `companyname`, `address`) VALUES (" + empCode + ",'" + name + "'," + phone + ",'" + email + "','" + designation + "'," + salary + ",'" + companyname + "','" + address + "') ");
                        //stmt.executeUpdate("INSERT INTO employees(empCode, `name`, `phone`, `email`, `designation`, `salary`, `companyname`, `address`) VALUES ("+empCode+",'"+name+"',"+phone+",'"+email+"','"+designation+"',"+salary+",'"+companyname+"','"+address+"')");

                        System.out.println("Inserted Successfully!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.println("Add the employees:");
                    break;
                }
                case 2: {
                    System.out.println("View all the employees");
                    try {
                        Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/CompanyDB?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `empCode`, `name`, `phone`, `email`, `designation`, `salary`, `companyname`, `address` FROM `employee` WHERE 1");

                        while (rs.next()) {
                            System.out.println("ID :"+rs.getInt("id"));
                            System.out.println("empcode=" + rs.getInt("empcode"));
                            System.out.println("name=" + rs.getString("name"));
                            System.out.println("phone=" + rs.getInt("phone"));
                            System.out.println("designation=" + rs.getString("designation"));
                            System.out.println("salary=" + rs.getInt("salary"));
                            System.out.println("companyname=" + rs.getString("companyname"));
                            System.out.println("address=" + rs.getString("address"));
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                }

                case 3:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! ");
                    break;

            }
        }
    }
}
