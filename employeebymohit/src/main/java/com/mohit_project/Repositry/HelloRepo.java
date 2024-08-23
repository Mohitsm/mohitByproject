package com.mohit_project.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mohit_project.Entity.Hello;



@Repository
public interface HelloRepo extends JpaRepository<Hello, Long> {
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Present'")
	    long countPresentEmployees();
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Absent'")
	    long countAbsentEmployees();
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Late'")
	    long countLateEmployees();
	 @Query("SELECT COUNT(e) FROM Hello e WHERE e.status = 'Half Day'")
	    long countHalfDayEmployees();


}
