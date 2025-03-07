package com.EmpDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.EmpServices.EmpService;
import com.EmpServices.Employee;

public class EmpDriver {
	public static void main(String[] args) 
	{
	 
		
		EmpService e1=new EmpService();
		boolean f=true;
		while(f) {
			System.out.println("WELCOME TO EMPLOYEE MANAGEMENT APPLICATION");
			System.out.println("MENU DETAILS");
			System.out.println("Press 1 to Register Employee");
			System.out.println("Press 2 to Update Employee");
			System.out.println("Press 3 to Delete Employee");
			System.out.println("Press 4 to Fetch all Employees details");
			System.out.println("Press 5 to Close the Application");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter your Choice: ");
			int choice =sc.nextInt();
		switch(choice)
		{
		
		case 1:
			int res=e1.save();
			if(res!=0) System.out.println("Data Saved");
			else System.out.println("Data not Saved");
			break;
			
		case 2:
			int res2=e1.update();
			if(res2!=0) System.out.println("Updated Successfully...");
			else System.out.println("Not updated :(");
			break;
			
		case 3:
			int res1=e1.delete();
			if(res1!=0)System.out.println("Data deleted...!");
			else System.out.println("Data is Not Deleted :(");
			break;
			
		case 4:
			 List<Employee> s=e1.select();
			if(!s.isEmpty()) {
			for(int i=0;i<s.size();i++)
			{
			System.out.println(s.get(i));	 
			}
			}
			break;
		
		case 5:	
		 
		if(e1.close()) 
		{
			System.out.println("Connection closed successfully......!");
		}
		f=false;
		break;
		
		default:
				break;
		}
		}
		
	}
	
}
