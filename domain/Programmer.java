package com.team.domain;

import com.team.service.*;
public class  Programmer extends Employee{
	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;
	
	public Programmer() {
		super();
	}

	

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}



	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	@Override
//	public String toString() {
//		return "Programmer [memberId=" + memberId + ", status=" + status + ", equipment=" + equipment + "]";
//	}
	public String toString() {
		return getDetails() + "\tProgrammer\t" + status + "\t\t\t" + equipment.getDescription() ;
//һ��		return super.toString() + "\tProgrammer" + status + "\t\t\t" + equipment.getDescription() ;
	}
	
	public String getTeamBaseDetail() {
		return memberId+"/"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary();
	}
	
	public String getDetailForTeam() {
		return getTeamBaseDetail()+"\tProgrammer";
		
	}
	
	
	
	
	
	

}
