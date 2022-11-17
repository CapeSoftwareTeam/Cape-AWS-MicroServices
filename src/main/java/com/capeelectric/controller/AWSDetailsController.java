/**
 * 
 */
package com.capeelectric.controller;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capeelectric.exception.InspectionException;
import com.capeelectric.exception.InstalReportException;
import com.capeelectric.exception.PeriodicTestingException;
import com.capeelectric.exception.SummaryException;
import com.capeelectric.exception.SupplyCharacteristicsException;
import com.capeelectric.service.AWSEmailService;
import com.capeelectric.util.EmailContent;

/**
 * @author capeelectricsoftware
 *
 */
@RestController
@RequestMapping("/api/email/v1")
public class AWSDetailsController {

private static final Logger logger = LoggerFactory.getLogger(AWSDetailsController.class);
	
	@Autowired
	private AWSEmailService awsEmailService;

	@GetMapping("/sendPDFInMail/{user}/{type}/{id}/{name}")
	public ResponseEntity<byte[]> sendFinalPDF(@PathVariable String user, @PathVariable String type,
			@PathVariable Integer id, @PathVariable String name)
			throws InstalReportException, SupplyCharacteristicsException, InspectionException, PeriodicTestingException,
			SummaryException, Exception {
		logger.info("called sendFinalPDF function userName: {},siteId : {}, siteName : {}", user,id,name);

		awsEmailService.sendEmailPDF(user,id,id,name, type);

		return new ResponseEntity<byte[]>(HttpStatus.OK);
	}
	
	@GetMapping("/sendEmail/{email}/{content}")
	public void sendEmail(@PathVariable String email, @PathVariable String content) throws MessagingException {
		logger.info("Calling the email service");
		awsEmailService.sendEmail(email, content);
	}
	
	@PutMapping("/sendEmailToUser/{email}")
    public void sendEmail(@PathVariable String email, @RequestBody EmailContent content) throws MessagingException {
        logger.info("Calling the email to User : {}"+email);
        awsEmailService.sendEmailForLMS(email, content.getContentDetails());
    }
	
	@PutMapping("/sendEmailToAdmin")
	public void sendEmailToAdmin(@RequestBody EmailContent content) throws MessagingException {
		logger.info("Calling the email service for admin");
		awsEmailService.sendEmailToAdmin(content.getContentDetails());
	}
	
	@PutMapping("/sendEmailForComments/{toEmail}/{ccEmail}")
	public void sendEmailForComments(@PathVariable String toEmail, @PathVariable String ccEmail, @RequestBody EmailContent content) throws MessagingException {
		logger.info("Calling email service for comments");
		awsEmailService.sendEmail(toEmail, ccEmail, content.getContentDetails());
	}
	
	@PutMapping("/sendEmailForApproval/{email}")
	public void sendEmailForApproval(@PathVariable String email, @RequestBody EmailContent content) throws MessagingException {
		logger.info("Calling email service for comments");
		awsEmailService.sendEmail(email, content.getContentDetails());
	}
	
//	@GetMapping("/sendEmailForLMS/{email}/{content}")
//	public void sendEmailForLMS(@PathVariable String email, @PathVariable String content) throws MessagingException {
//		logger.info("Calling the email service");
//		awsEmailService.sendEmailForLMS(email, content);
//	}
	
	@GetMapping(value = "/health")
	public ResponseEntity<?> health() throws Exception {
	    try {
	        return ResponseEntity.status(200).body("Ok");
	    } catch (Exception e) {
	        return (ResponseEntity<?>) ResponseEntity.internalServerError().body(e.getMessage());
	    }
	}
	
}
