package com.team.junit;

import org.junit.Test;

import com.team.service.TeamException;
import com.team.domain.Employee;
import com.team.service.NameListService;

public class NameListServiceTest {

	@Test	
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0; i<employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 5;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
