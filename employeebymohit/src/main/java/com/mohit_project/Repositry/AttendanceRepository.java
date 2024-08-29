package com.mohit_project.Repositry;

import com.mohit_project.Entity.Attendance;
import com.mohit_project.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployee(Employee employee);

    @Query("SELECT a FROM Attendance a WHERE a.employee.id = :employeeId")
    List<Attendance> findByEmployeeId(@Param("employeeId") Long employeeId);
}