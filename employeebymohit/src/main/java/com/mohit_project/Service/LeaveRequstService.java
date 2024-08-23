package com.mohit_project.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit_project.Entity.LeaveRequst;
import com.mohit_project.Repositry.LeaveRequstRepo;



@Service
public class LeaveRequstService {
	
	@Autowired
	private LeaveRequstRepo leaveRequstRepo;
	
	public LeaveRequst create(LeaveRequst leaveRequst) {
		return this.leaveRequstRepo.save(leaveRequst);
	}
	
	public List<LeaveRequst> getAll(){
		return this.leaveRequstRepo.findAll();
	}

}
