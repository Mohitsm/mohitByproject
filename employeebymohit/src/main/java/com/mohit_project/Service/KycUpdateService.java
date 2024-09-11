//package com.mohit_project.Service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.mohit_project.Entity.KycUpdate;
//import com.mohit_project.Repositry.KycUpdateRepo;
//
//@Service
//public class KycUpdateService {
//	 private final Path rootLocation = Paths.get("C:/Users/Mohit Kumar/myweb/uploads");
//	
//	@Autowired
//	private KycUpdateRepo kycUpdateRepo;
//	
////	public KycUpdate createEmployee(Long employeeId, String aadharNo, MultipartFile aadharDoc,
////            String panNo, MultipartFile panDoc, String accountNo,
////            String ifsc, String bankName, String bankAddress,
////            MultipartFile passbookDoc, String kycStatus) throws IOException {
////
////KycUpdate employee = new KycUpdate();
////employee.setKycUpdateid(employeeId);
////employee.setAadharNo(aadharNo);
////employee.setAadharDoc(aadharDoc.getBytes());
////employee.setPanNo(panNo);
////employee.setPanDoc(panDoc.getBytes());
////employee.setAccountNo(accountNo);
////employee.setIfsc(ifsc);
////employee.setBankName(bankName);
////employee.setBankAddress(bankAddress);
////employee.setPassbookDoc(passbookDoc.getBytes());
////employee.setKycStatus(kycStatus);
////
////return kycUpdateRepo.save(employee);
////}
////	  
//	 public void createEmployee(Long employeeId, String aadharNo, MultipartFile aadharDoc, String panNo, MultipartFile panDoc,
//             String accountNo, String ifsc, String bankName, String bankAddress, MultipartFile passbookDoc,
//             String kycStatus) throws IOException {
//
//// Save documents
//if (aadharDoc != null && !aadharDoc.isEmpty()) {
//String aadharFilename = "aadhar_" + employeeId + ".pdf";
//saveFile(aadharDoc, aadharFilename);
//}
//
//if (panDoc != null && !panDoc.isEmpty()) {
//String panFilename = "pan_" + employeeId + ".pdf";
//saveFile(panDoc, panFilename);
//}
//
//if (passbookDoc != null && !passbookDoc.isEmpty()) {
//String passbookFilename = "passbook_" + employeeId + ".pdf";
//saveFile(passbookDoc, passbookFilename);
//}
//
//// Create a new Employee object
//KycUpdate employee = new KycUpdate();
//employee.setKycUpdateid(employeeId);
//employee.setAadharNo(aadharNo);
//employee.setPanNo(panNo);
//employee.setAccountNo(accountNo);
//employee.setIfsc(ifsc);
//employee.setBankName(bankName);
//employee.setBankAddress(bankAddress);
//employee.setKycStatus(kycStatus);
//
//// Save employee to the database
//kycUpdateRepo.save(employee);
//}
//
//private void saveFile(MultipartFile file, String filename) throws IOException {
//Path destinationPath = rootLocation.resolve(filename);
//Files.createDirectories(destinationPath.getParent()); // Ensure directory exists
//file.transferTo(destinationPath.toFile());
//}
//}


package com.mohit_project.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.Entity.KycUpdate;
import com.mohit_project.Repositry.KycUpdateRepo;


@Service
public class KycUpdateService {

    private final Path rootLocation = Paths.get("C:/Users/Mohit Kumar/myweb/uploads");

    @Autowired
    private KycUpdateRepo kycUpdateRepository;

    public void createEmployee(Long employeeId, String aadharNo, MultipartFile aadharDoc, String panNo, MultipartFile panDoc,
                               String accountNo, String ifsc, String bankName, String bankAddress, MultipartFile passbookDoc,
                               String kycStatus) throws IOException {

        try {
            // Save documents
            if (aadharDoc != null && !aadharDoc.isEmpty()) {
                String aadharFilename = "aadhar_" + employeeId + ".pdf";
                saveFile(aadharDoc, aadharFilename);
            }

            if (panDoc != null && !panDoc.isEmpty()) {
                String panFilename = "pan_" + employeeId + ".pdf";
                saveFile(panDoc, panFilename);
            }

            if (passbookDoc != null && !passbookDoc.isEmpty()) {
                String passbookFilename = "passbook_" + employeeId + ".pdf";
                saveFile(passbookDoc, passbookFilename);
            }

            // Create a new Employee object
            KycUpdate employee = new KycUpdate();
            employee.setKycUpdateid(employeeId);
            employee.setAadharNo(aadharNo);
            employee.setPanNo(panNo);
            employee.setAccountNo(accountNo);
            employee.setIfsc(ifsc);
            employee.setBankName(bankName);
            employee.setBankAddress(bankAddress);
            employee.setKycStatus(kycStatus);

            // Save employee to the database
            kycUpdateRepository.save(employee);

        } catch (IOException e) {
            System.err.println("File handling error: " + e.getMessage());
            throw e; // Re-throw the exception to be handled by the controller
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("Failed to create employee due to unexpected error", e);
        }
    }

    private void saveFile(MultipartFile file, String filename) throws IOException {
        Path destinationPath = rootLocation.resolve(filename);
        Files.createDirectories(destinationPath.getParent()); // Ensure directory exists
        file.transferTo(destinationPath.toFile());
    }
}
