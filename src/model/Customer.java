/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Customer extends Person{
    private double WalletBalance;

    public Customer() {
    }

    public Customer(double WalletBalance, String name, String phoneNo, String password) {
        super(name, phoneNo, password);
        this.WalletBalance = WalletBalance;
    }

    
    public double getWalletBalance() {
        return WalletBalance;
    }

    public void setWalletBalance(double WalletBalance) {
        this.WalletBalance = WalletBalance;
    }

    
    
}
