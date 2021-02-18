package com.dhruba.SpringOrmDurgesh;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dhruba.SpringOrmDurgesh.dao.StudentDao;
import com.dhruba.SpringOrmDurgesh.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
     
    	ApplicationContext context= new ClassPathXmlApplicationContext("config.xml"); 
    	StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
    	//Student student=new Student(1,"Dhruba Roka","Gorkha");
    	//int r = studentDao.insert(student);
    	//System.out.println("done"+r);
    	
    	
    	BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
    	
    	boolean go=true;
    	while (go) {
			
		
    	System.out.println("PRESS 1 for add new student");
    	System.out.println("PRESS 2 for display all student");
    	System.out.println("PRESS 3 for get detail of single student");
    	System.out.println("PRESS 4 for delete student");
    	System.out.println("PRESS 5 for update student");
    	System.out.println("PRESS 6 for exit");
    	
    	try {
    		
    		int input=Integer.parseInt(bReader.readLine());
			/*
			 * if(input==1)
			 *  { //add a new student } 
			 *  else if(input==2)
			 *   { //display }
			 */
    		
    		switch (input) {
			case 1:
				//add new student
				
				//taking inputs from users
				System.out.println("Enter user id:");
				int uId=Integer.parseInt(bReader.readLine());
				
				System.out.println("Enter username:");
				String uName=bReader.readLine();
				
				System.out.println("Enter user city:");
				String uCity=bReader.readLine();
				
				//creating stuent object and setting values
				Student student = new Student();
				student.setStudentId(uId);
				student.setStudentName(uName);
				student.setStudentCity(uCity);
				
				//saving student object to database by calling insert of student dao
				int r=studentDao.insert(student);
				System.out.println(r+"student added");
				System.out.println("********************************");
				System.out.println();
				
				break;
			case 2:
				//display all student
				List<Student> allStudents = studentDao.getAllStudents();
				for(Student s:allStudents) {
					System.out.println("Id: "+ s.getStudentId());
					System.out.println("Name: "+ s.getStudentName());
					System.out.println("City: "+ s.getStudentCity());
					System.out.println("_____________________________________");
				}
				System.out.println("**********************************");
				
				break;
			case 3:
				//get detail of single student
				System.out.println("Enter user id:");
				int userId=Integer.parseInt(bReader.readLine());
				Student student2 = studentDao.getStudent(userId);
				System.out.println("Id: "+ student2.getStudentId());
				System.out.println("Name: "+ student2.getStudentName());
				System.out.println("City: "+ student2.getStudentCity());
				System.out.println("_____________________________________");
				
				break;
			case 4:
				//delete student
				System.out.println("Enter user id:");
				int userId1=Integer.parseInt(bReader.readLine());
				studentDao.deleteStudent(userId1);
				System.out.println("student deleted.......");
				break;
			case 5:
				//update student
				break;
			case 6:
				//exit
				go=false;
				break;

			
			}
			
		} catch (Exception e) {
			System.out.println("Invalid input try with another one");
			System.out.println(e.getMessage());
		}
    	
    	}
    System.out.println("thankyou for using my application");
    System.out.println("c u soon!");
    }
    
}
