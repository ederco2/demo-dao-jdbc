package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=====TEST 1: Department findById====");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=====TEST 3: Department findByAll====");
		List<Department>list = departmentDao.findAll();
		for (Department department2 : list) {
			System.out.println(department2);
		}
	
		System.out.println("\n=====TEST 4: Department insert====");
		Department newDep = new Department(null,"Eder Jofre");				
		departmentDao.insert(newDep);
		System.out.println("Inserted: " + newDep.getId());
		
		System.out.println("\n=====TEST 5: Department Update====");
		department =departmentDao.findById(5);
		department.setName("Cabron");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=====TEST 6: Department Delete====");
		System.out.println("Enter id for delete test:");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted!");
		
		sc.close();
	}
}
