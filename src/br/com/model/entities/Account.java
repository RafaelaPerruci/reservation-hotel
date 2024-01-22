package br.com.model.entities;

import br.com.model.exception.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrwLimit;

    public Account(Integer number, String holder, Double balance, Double withdrwLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrwLimit = withdrwLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrwLimit() {
        return withdrwLimit;
    }
    public void deposit(Double amount){

        this.balance += amount;
    }
    public void withdraw(Double amount){
        if (amount > withdrwLimit){
            throw new BusinessException("The amount exceeds withdraw limit");
        }
        if (balance < amount){
            throw new BusinessException("Not enough balance");
        }

        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account number: " + number +
                ", Holder: " + holder  +
                ", Balance: " + balance +
                ", Withdrw Limit: " + withdrwLimit;
    }
}
