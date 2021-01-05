package com.team.service;

import com.team.service.TeamException;
import com.team.service.Status;
import com.team.domain.*;

public class TeamService {
	private static int counter =1;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;
	
	public TeamService() {
		super();
	}
//Get all members of the team, traverse all members in the team
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i=0;i<team.length;i++ ) {
			team[i] = this.team[i];			
		}
		return team;
	}
	
	public void addMember(Employee e) throws TeamException {
//	Members are full and cannot be added
		if (total >= MAX_MEMBER) {
			throw new TeamException("Members are full and cannot be added");
		}
//	The member is not a developer and cannot be added
		if (!(e instanceof Programmer)) {
			throw new TeamException("The member is not a developer and cannot be added");
		}
//		The employee is already in the development team
		if (isExit(e)) {
			throw new TeamException("The employee is already in the development team");
		}
//		The employee is already a member of a team	
//		The employee is on vacation and cannot be added
		Programmer p = (Programmer) e;
		if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("The employee is already a member of a team");
		} else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("The employee is on vacation and cannot be added");
		}
		
//		There can be at most one architect in the team	
//		There can be no more than two designers in the team	
//	There can be no more than three programmers in the team
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		
		if (p instanceof Architect) {
			if(numOfArch>=1) {
				throw new TeamException("	There can be at most one architect in the team	ʦ");
			}			
		}else if (p instanceof Designer) {
			if(numOfDes>=2) {
				throw new TeamException("There can be no more than two designers in the team	");
			}			
		}else if (p instanceof Programmer) {
			if(numOfPro >=3) {
				throw new TeamException("There can be no more than three programmers in the team");
			}			
		}
//	ֻIt’s just a reference address.
//		p.setStatus(Status.BUSY);
//		p.setMemberID(counter++);
//		Add p or e to the existing team
		team[total++] = p;
//		attribute assignment of p
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		
	}
	private boolean isExit(Employee e) {
		for(int i =0;i<total;i++) {
			if(team[i].getId() == e.getId()) {
			return true;			
		}
			}
		return false;
	}
	
	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for(;i<total;i++) {
			if(team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
//The specified id is not found
		if(i == total) {
			throw new TeamException("The employee with the specified memberID cannot be found, the deletion failed");
		}	
		
//After deleting the member, the following element covers the previous element
		for(int j = i+1;j<total;j++) {
			team[j-1] = team[j];
		}
//	The value of the element that is empty behind is null
		team[--total] = null;

	}
		
	}


