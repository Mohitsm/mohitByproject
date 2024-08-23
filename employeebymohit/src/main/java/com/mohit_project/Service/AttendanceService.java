//package com.mohit_project.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.mohit_project.Entity.Attendance;
//import com.mohit_project.Entity.Employee;
//import com.mohit_project.Repositry.AttendanceRepo;
//
//
//@Service
//public class AttendanceService {
//    @Autowired
//    private AttendanceRepo attendanceRepository;
//
//    public List<Attendance> getAttendanceByEmployeeId(Long employeeId) {
//        return attendanceRepository.findByEmployeeId(employeeId);
//    }
// 
//    public Attendance punchIn(Employee employee) {
//        Attendance attendance = new Attendance();
//        attendance.setEmployee(employee);
//        attendance.setPunchIn(LocalDateTime.now());
//        return attendanceRepository.save(attendance);
//    }
//
//    public Attendance punchOut(Long attendanceId) {
//        Optional<Attendance> attendanceOpt = attendanceRepository.findById(attendanceId);
//        if (attendanceOpt.isPresent()) {
//            Attendance attendance = attendanceOpt.get();
//            attendance.setPunchOut(LocalDateTime.now());
//            return attendanceRepository.save(attendance);
//        }
//        return null;
//    }
//}
