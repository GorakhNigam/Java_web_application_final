package com.virtusa.banking.appln;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.virtusa.banking.bean.Account;
import com.virtusa.banking.dao.AccountDao;
import com.virtusa.banking.dao.DaybookDao;

public class GetAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//double balance = 0;		
		Date date = new Date();
		//Account ac = new Account(123,"gorakh", 1000, date);		
		AccountDao dao = new AccountDao();
		if(input.equals("create")) {
			
			//int accountNo = sc.nextInt();
			String name = sc.next();
			double amount = sc.nextDouble();
			
			Account ac = new Account(0,name,amount, date);
			AccountDao accnt = new AccountDao();
			accnt.createAccount(ac);
		}
		
		
		if(input.equals("deposite")) {
			int accountNo = sc.nextInt();
			double amount = sc.nextDouble();
			dao.deposite(accountNo, date,"Credited","gift",amount);
			System.out.println("deposited");
		}
		else if(input.equals("withdraw")) {
			int accountNo = sc.nextInt();
			double amount = sc.nextDouble();
			
			dao.withdraw(accountNo,date,"debited","gift",amount);
		}
		else if(input.equals("checkBalance")) {
			int accountNo = sc.nextInt();
			dao.checkBalance(accountNo);
		}
		else if(input.equals("getStatement")) {
			int accountNo = sc.nextInt();
			DaybookDao dbdao = new DaybookDao();
			dbdao.getStatement(accountNo);
		}
			
	}

}
