/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2_p4;

/**
 *
 * @author adham
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Lab2_p4 {

    public static Invoice[] readInvoiceDetailsFromFile(String fileName) throws IOException {
        Scanner fileScanner = new Scanner(new File(fileName));
        int invoiceCount = Integer.parseInt(fileScanner.nextLine().trim());
        Invoice[] invoices = new Invoice[invoiceCount];

        for (int i = 0; i < invoiceCount; i++) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(",");

            int invoiceNumber = Integer.parseInt(parts[0]);
            String customerName = parts[1];
            int itemCount = Integer.parseInt(parts[2]);

            double[] prices = new double[itemCount];
            for (int j = 0; j < itemCount; j++) {
                prices[j] = Double.parseDouble(parts[3 + j]);
            }

            invoices[i] = new Invoice(invoiceNumber, customerName, prices);
        }

        fileScanner.close();
        return invoices;
    }

    public static void printInvoices(Invoice[] invoices) {
        for (Invoice inv : invoices) {
            inv.report();
        }
    }

    public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter filename: ");
    String filename = scanner.nextLine();

    Invoice[] invoices = readInvoiceDetailsFromFile(filename);

    Arrays.sort(invoices, (a, b) -> Double.compare(b.calculateInvoice(), a.calculateInvoice()));

    System.out.println("\nInvoices sorted by total after discount:");
    printInvoices(invoices);

    System.out.println("\nDo you want to enter a new invoice?");
    System.out.println("1. Yes");
    System.out.println("2. No");
    System.out.print("Enter choice: ");
    int choice = scanner.nextInt();
    scanner.nextLine(); 

    if (choice == 1) {
        System.out.println("\nEnter new invoice:");

        System.out.print("Invoice Number: ");
        int invoiceNumber = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Prices (separated by commas ','): ");
        String priceLine = scanner.nextLine();
        String[] priceParts = priceLine.split(",");
        double[] prices = new double[priceParts.length];
        for (int i = 0; i < priceParts.length; i++) {
            prices[i] = Double.parseDouble(priceParts[i].trim());
        }

        Invoice newInvoice = new Invoice(invoiceNumber, customerName, prices);

        List<Invoice> invoiceList = new ArrayList<>(Arrays.asList(invoices));
        invoiceList.add(newInvoice);

        (PrintWriter writer = new PrintWriter(new FileWriter(filename)) 
            writer.println(invoiceList.size());
            for (Invoice inv : invoiceList) {
                writer.print(inv.getInvoiceNumber() + "," + inv.getCustomerName() + "," + inv.getPrices().length);
                for (double price : inv.getPrices()) {
                    writer.print("," + price);
                }
                writer.println();
            }
        

        System.out.println("New invoice saved successfully.");
    }
    else {
        System.out.println("No changes made. Exiting.");
    }
    

    scanner.close();
 }

}

