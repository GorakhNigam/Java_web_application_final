package test1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Long, Person> lst = new HashMap<>();
		System.out.println("Enter The Number of Employees");
		int n = sc.nextInt();
		for(int i=0; i<n;i++) {
			System.out.println("Enter The "+i+" Employee Details:");
			System.out.println("Enter the Firstname");
			String firstname = sc.next();
			System.out.println("Enter the Lastname");
			String lastname = sc.next();
			System.out.println("Enter the Mobile");
			long mob = sc.nextLong();
			System.out.println("Enter the Email");
			String email = sc.next();
			System.out.println("Enter the Address");
			String address = sc.next();
			Person per = new Person(firstname, lastname, mob, email, address);
			lst.put(mob, per);
			
		}
		
		for (HashMap.Entry<Long, Person> entry : HashMap.entrySet()) {
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	}

}
