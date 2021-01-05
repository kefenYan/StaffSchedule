package com.team.service;

import static com.team.service.Data.*;
import com.team.domain.*;

public class NameListService {
	private Employee[] employees ;

	public NameListService() {
		super();
		employees = new Employee[EMPLOYEES.length];//���Ե�����ֱ��Data
		for(int i=0;i<employees.length;i++) {
			int type  = Integer.parseInt(EMPLOYEES[i][0]);
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type){
			case EMPLOYEE:
				employees[i] = new Employee(id, name,  age,  salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name,  age,  salary,  equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment,bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus,stock);
				break;
				
				
				
			}
			
		}
	}
	
	private Equipment createEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		String modelOrName = EQUIPMENTS[index][1];
		switch(type) {
		case PC:
			String display = EQUIPMENTS[index][2];
			return new PC(modelOrName,display);
			
		case NOTEBOOK:
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName,price);
			
		case PRINTER:
			return new Printer(modelOrName,EQUIPMENTS[index][2]);
		
		}
		return null;
	}

	public Employee[] getAllEmployees() {
		return employees;
		
	}
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0;i<employees.length;i++) {
			if(employees[i].getId() == id ) {
				return employees[i];
			}
		}
		throw new TeamException ("Cannot find the specified employee!");
		
	}

}
