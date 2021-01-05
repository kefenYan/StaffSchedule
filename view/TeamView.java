package com.team.view;


import com.team.domain.*;
import com.team.service.*;
import com.team.service.TeamService;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	public void enterMainMenu() {
		boolean loopFlag = true;
		char menu = 0;
		while(loopFlag) {
			if(menu !='1') {
			listAllEmployees();
			}
			System.out.println("1-Team list 2-add mumber 3-delete mumber 4-exit choise please(1-4):");
			menu  = TSUtility.readMenuSelection();
			switch(menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("Are you sure to exit (Y/N):");
				char isExist = TSUtility.readConfirmSelection();
				if(isExist =='Y') {
					loopFlag = false;
				}
				break;
				
			}
		}
		
	}
	private void listAllEmployees() {
System.out.println("-------------------Bank network development team scheduling software--------------------\n");
		
		Employee[] employees = listSvc.getAllEmployees();
		if(employees == null||employees.length == 0) {
			System.out.println("The company does not have any employee information");	
		}else {
			System.out.println("ID\tname\tage\tsalary\tposition\tstatus\tbonus\tstock\tRequisition equipment");	
//	Traverse employee members
			for(int i = 0;i<employees.length;i++) {
				System.out.println(employees[i]);	
			}
					
		}
		System.out.println("-----------------------------------------------------\n");
	
		
	}
	private void getTeam() {
System.out.println("-------------------List of development team members--------------------\n");
		
		Programmer[] team = teamSvc.getTeam();
		if(team ==null||team.length ==0) {
			System.out.println("The development team currently has no employees");
		}else {
			System.out.println("TID/ID\tname\tage\tsalary\tposition\tstatus\tbonus\tstock\n");
			for(int i = 0;i<team.length;i++) {
				System.out.println(team[i].getDetailForTeam());	
			}
		}
		
		System.out.println("------------------------------------------------------\n");
		
		
	}
	private void addMember() {
		System.out.println("-------------------Add development team members--------------------");
		System.out.print("Please enter the ID of the development team member to be added:");
		int id = TSUtility.readInt();
		
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.print("Added successfully\n");

		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.print("Add failed, reason"+e.getMessage()+"\n");
		}
//			Press enter to continue......
			TSUtility.readReturn();
		
	}
	private void deleteMember() {
		System.out.println("-------------------Delete development team members--------------------");
		System.out.print("Please enter the TID of the development team member to be deleted:");
		int memberId = TSUtility.readInt();
		
		
		System.out.print("Please confirm whether to delete (Y/N):");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete == 'N') {
			return;
		}
		
		try {
			teamSvc.removeMember(memberId);
			System.out.print("successfully deleted\n");
		} catch (TeamException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.print("Delete failed, reason"+e.getMessage()+"\n");
		}
//		Press enter to continue......
		TSUtility.readReturn();
		
	}
	
	

	public static void main(String[] args) {
		
		TeamView tv = new TeamView();
		tv.enterMainMenu();

	}

}
