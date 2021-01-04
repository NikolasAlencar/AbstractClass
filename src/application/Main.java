package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		List<Person> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual our company (i/c)? ");
			char ch = sc.next().charAt(0);
			if (ch == 'c') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Anual income: ");
				double income = sc.nextDouble();
				System.out.print("Number of employees: ");
				int employees = sc.nextInt();
				Person person = new LegalPerson(name, income, employees);
				list.add(person);
			}else {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Anual income: ");
				double income = sc.nextDouble();
				System.out.print("Health expenditures: ");
				Double health = sc.nextDouble();
				Person person = new NaturalPerson(name, income, health);
				list.add(person);
			}
		}
		double sum = 0;
		System.out.println("TAXES PAID:");
		for (Person person : list) {
			System.out.println(person.toString());
			sum += person.calcTax();
		}
		System.out.println("");
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		sc.close();
		}

	}