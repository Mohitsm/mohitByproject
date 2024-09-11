package com.mohit_project.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KycUpdate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long kycUpdateid;
	  private String aadharNo;

	    @Lob
	    @Column(name = "aadhar_doc", columnDefinition="LONGBLOB")
	    private byte[] aadharDoc;

	    private String panNo;

	    @Lob
	    @Column(name = "pan_doc", columnDefinition="LONGBLOB")
	    private byte[] panDoc;

	    private String accountNo;
	    private String ifsc;
	    private String bankName;
	    private String bankAddress;

	    @Lob
	    @Column(name = "passbook_doc", columnDefinition="LONGBLOB")
	    private byte[] passbookDoc;

	    private String kycStatus;
	    

}
