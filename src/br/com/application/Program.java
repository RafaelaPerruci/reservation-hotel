package br.com.application;

import br.com.model.entities.Account;
import br.com.model.exception.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);



        System.out.println("Enter the Account data: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.println("Holder name: ");
        String name = sc.nextLine();
        System.out.println("Initial balance: ");
        Double initialBalance = sc.nextDouble();
        System.out.println("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();

        Account acc = new Account(number, name, initialBalance, withdrawLimit);

        System.out.println();
        System.out.print("Enter an amount to withdraw: ");
        double amount = sc.nextDouble();

        try{
            acc.withdraw(amount);
            System.out.printf("New balance: %.2f%n", acc.getBalance());
            System.out.println(acc);
        }
        catch (BusinessException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }


      sc.close();
    }

}
