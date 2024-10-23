import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.paypalService;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("type contract data:");
        System.out.print("Number: "); int number = sc.nextInt();
        System.out.print("Date: "); LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Contract value: "); double value = sc.nextDouble();
        
        Contract contract = new Contract(number, date, value);

        System.out.println("How many installments?");
        int n = sc.nextInt();

        ContractService ContractService = new ContractService(new paypalService());

        ContractService.processContract(contract, n);

        System.out.println("Installments:");
        for(Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
    }
}