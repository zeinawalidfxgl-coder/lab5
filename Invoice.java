/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2_p4;

/**
 *
 * @author adham
 */
public class Invoice{
    private int invoiceNumber;
    private String customerName;
    private double[] prices;

    public Invoice(int invoiceNumber, String customerName, double[] prices) {
        this.invoiceNumber = invoiceNumber;
        this.customerName = customerName;
        this.prices = prices;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double[] getPrices() {
        return prices;
    }

    public void setPrices(double[] prices) {
        this.prices = prices;
    }
    
    public double calculateInvoice() {
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }

        double discount = 0.0;
        if (total >= 1000 && total < 5000) {
            discount = 0.01; 
        } else if (total >= 5000 && total <= 8000) {
            discount = 0.04; 
        } else if (total >= 8000 && total <=10000) {
            discount = 0.06;
        } else if (total >=10000) {
            discount = 0.08;   
        }   

        return total - (total * discount);
    }
    public void report() {
        double total = 0.0;
        for (double price : prices) {
            total += price;
        }
    
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total: " + total);
        System.out.println("Total after discount: " + calculateInvoice());
       
    }
}
