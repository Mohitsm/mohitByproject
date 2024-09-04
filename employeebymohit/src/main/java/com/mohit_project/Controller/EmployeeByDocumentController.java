package com.mohit_project.Controller ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mohit_project.serviceIpml.EmployeeByDocumentService;

import java.io.IOException;

@RestController
@RequestMapping("/api/documents")
public class EmployeeByDocumentController {

    @Autowired
    private EmployeeByDocumentService documentService;

    // Endpoint to upload documents for an employee
    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocuments(@RequestParam("matric") MultipartFile matric,
                                                  @RequestParam("inter") MultipartFile inter,
                                                  @RequestParam("graduation") MultipartFile graduation,
                                                  @RequestParam("pg") MultipartFile pg,
                                                  @RequestParam("aadhar") MultipartFile aadhar,
                                                  @RequestParam("pan") MultipartFile pan,
                                                  @RequestParam("dl") MultipartFile dl,
                                                  @RequestParam("employeeId") Long employeeId) {
        try {
            documentService.saveDocumentDetails(matric, inter, graduation, pg, aadhar, pan, dl, employeeId);
            return ResponseEntity.ok("Documents uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload documents: " + e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // Endpoint to download a specific document by employee ID and file name
    @GetMapping("/download/{employeeId}/{fileName}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long employeeId, @PathVariable String fileName) {
        Resource resource = documentService.loadDocumentAsResource(employeeId, fileName);
        if (resource != null) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }
//
//    // Endpoint to get document details by employee ID
//    @GetMapping("/{employeeId}")
//    public ResponseEntity<?> getDocumentDetails(@PathVariable Long employeeId) {
//        return documentService.getEmployeeDocumentById(employeeId)
//                .map(document -> ResponseEntity.ok(document))
//                .orElseGet(() -> ResponseEntity.status(404).body("Document not found for employee ID: " + employeeId));
//    }

}
