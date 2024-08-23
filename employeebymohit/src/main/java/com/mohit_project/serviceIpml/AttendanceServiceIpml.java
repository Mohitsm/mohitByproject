//package com.mohit_project.serviceIpml;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import com.mohit_project.Entity.Attendance;
//import com.mohit_project.Repositry.AttendanceRepo;
//import com.mohit_project.Service.AttendanceService;
//import com.mohit_project.exception.ResourceNotFoundException;
//import com.mohit_project.paylode.AttendanceDto;
//
//
//@Service
//public class AttendanceServiceIpml implements AttendanceService {
//	
//	@Autowired
//	private AttendanceRepo attendanceRepo;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Override
//	public long getPresentEmployees() {
//		// TODO Auto-generated method stub
//		return this.attendanceRepo.countPresentEmployees();
//	}
//
//	@Override
//	public long getAbsentEmployees() {
//		// TODO Auto-generated method stub
//		return this.attendanceRepo.countAbsentEmployees();
//	}
//
//	@Override
//	public long getLateEmployees() {
//		// TODO Auto-generated method stub
//		return this.attendanceRepo.countLateEmployees();
//	}
//
//	@Override
//	public long getHalfDayEmployees() {
//		// TODO Auto-generated method stub
//		return this.attendanceRepo.countHalfDayEmployees();
//	}
//
//	@Override
//	public List<AttendanceDto> getAllAttendance() {
//		// TODO Auto-generated method stub
//	 List<Attendance> attendances=this.attendanceRepo.findAll();
//	 List<AttendanceDto> getAllAttendance=attendances.stream().map((po)->this.modelMapper.map(po, AttendanceDto.class)).collect(Collectors.toList());
//		return getAllAttendance;
//	}
//
//	@Override
//	public AttendanceDto getAttendanceById(Long attendanceId) {
//		// TODO Auto-generated method stub
//         Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));
//
//		
//		return this.modelMapper.map(attendance,AttendanceDto.class);
//		
//	}
//
//	@Override
//	public AttendanceDto punchIn(AttendanceDto attendanceDTO) {
//		// TODO Auto-generated method stub
//		Attendance attendance=this.modelMapper.map(attendanceDTO, Attendance.class);
//		Attendance createAttendance=this.attendanceRepo.save(attendance);
//		
//		return this.modelMapper.map(createAttendance, AttendanceDto.class);
//	}
//
//	@Override
//	public AttendanceDto punchOut(Long attendanceId) {
//		 Optional<Attendance> attendanceOpt = attendanceRepo.findById(attendanceId);
//	        if (attendanceOpt.isPresent()) {
//	            Attendance attendance = attendanceOpt.get();
//	            attendance.setPunchOut(LocalDateTime.now());
//	            attendance = attendanceRepo.save(attendance);
//	            return this.modelMapper.map(attendance, AttendanceDto.class);
//	        }
//	        return null; // Or throw an exception
//	}
//
////	@Override
////	public AttendanceDto punchOut(Long attendanceId, LocalDateTime punchOutTime) {
////		// TODO Auto-generated method stub
////		Attendance attendance=this.attendanceRepo.findById(attendanceId).orElseThrow(()-> new ResourceNotFoundException("Attendance", "Id", attendanceId));
////		if(attendance!=null) {
////			attendance.setPunchOut(punchOutTime);
////			this.attendanceRepo.save(attendance);
////		}
////		return this.modelMapper.map(attendance, AttendanceDto.class);
////	}
//
//	
//
//}
