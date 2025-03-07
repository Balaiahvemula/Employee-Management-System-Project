package com.EmpServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService
{
	private static Connection con;
	private static String url="jdbc:postgresql://localhost:5432/employeeManagement?user=postgres&password=123";
	private static Scanner sc=new Scanner(System.in);
	static 
	{
		try {
			Class.forName("org.postgresql.Driver");
			
			con=DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException e) {
		   e.printStackTrace();	 
		}
		catch (SQLException e) {
	 		e.printStackTrace();
		}
	}
	
	public int save()
	{
		int res=0;
		
		System.out.println("Enter Employee Id : ");
		int id=sc.nextInt();
		
		System.out.println("Enter the Name: ");
		String name=sc.next();
		
		System.out.println("Enter Employee age : ");
		int age=sc.nextInt();
		
		System.out.println("Enter Employee sal : ");
		int sal=sc.nextInt();
		
		String sql="insert into employees values(?,?,?,?)";
		
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			pstm.setInt(4, sal);
			
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		return res;
	}
	
	public int delete()
	{
		int res=0;
		System.out.println("Enter the id to be deleted :");
		int id=sc.nextInt();
		String sql="DELETE from employees where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			
			pstm.setInt(1, id);
			res=pstm.executeUpdate();
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		
		return res;
	}

	
	public int update()
	{
		int res=0;
		System.out.println("Enter the id to be Updated: ");
		int id=sc.nextInt();
		System.out.println("Enter the sal to increase:");
		int sal=sc.nextInt();
		String sql="update employees set sal =sal+? where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(2, id);
			pstm.setInt(1, sal);
			 res=pstm.executeUpdate();
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		return res;
	}
	
	public List<Employee> select()
	{
		 List <Employee> l=new ArrayList<Employee>();
		
		String sql="select * from employees";
		try {
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				int sal=rs.getInt(4);
				l.add(new Employee(id, name, age, sal));
			}
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		return l;
	}
	
	public boolean close()
	{
		boolean flag=false;
		try {
			con.close();
			flag=true;			
		} catch (SQLException e) {
 			e.printStackTrace();
		}
		return flag;
	}
	
}
