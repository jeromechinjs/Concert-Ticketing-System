/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class VIPCustomer extends Customer{
    private final double discountRate = 0.95;

    public VIPCustomer() {
    }

    public VIPCustomer(double WalletBalance, String name, String phoneNo, String password) {
        super(WalletBalance, name, phoneNo, password);
    }

    

    public double getDiscountRate() {
        return discountRate;
    }
  
    
}
