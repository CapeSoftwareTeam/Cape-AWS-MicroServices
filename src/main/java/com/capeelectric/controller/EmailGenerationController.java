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

import com.capeelectric.exception.InspectionException;
import com.capeelectric.exception.InstalReportException;
import com.capeelectric.exception.PeriodicTestingException;
import com.capeelectric.exception.SummaryException;
import com.capeelectric.exception.SupplyCharacteristicsException;
import com.capeelectric.service.AWSEmailService;

/**
 * @author capeelectricsoftware
 *
 */
public class EmailGenerationController {

private static final Logger logger = LoggerFactory.getLogger(EmailGenerationController.class);
	
	@Autowired
	private AWSEmailService awsEmailService;

	@GetMapping("/sendPDFinMail/{user}/{type}/{id}/{name}")
	public ResponseEntity<byte[]> sendFinalPDF(@PathVariable String user, @PathVariable String type,
			@PathVariable Integer id, @PathVariable String name)
			throws InstalReportException, SupplyCharacteristicsException, InspectionException, PeriodicTestingException,
			SummaryException, Exception {
		logger.info("called sendFinalPDF function userName: {},siteId : {}, siteName : {}", user,id,name);

		awsEmailService.sendEmailPDF(user,id,id,name);

		return new ResponseEntity<byte[]>(HttpStatus.OK);
	}
	
	@GetMapping("/generateEmail/{email}/{content}")
	public void sendEmail(@PathVariable String email, @PathVariable String content) throws MessagingException {
		logger.info("Calling the email service");
		awsEmailService.sendEmail(email, content);
	}
	
	@GetMapping("/generateEmailForComments/{toEmail}/{ccEmail}/{content}")
	public void sendEmailForComments(@PathVariable String toEmail, @PathVariable String ccEmail, @PathVariable String content) throws MessagingException {
		logger.info("Calling email service for comments");
		awsEmailService.sendEmail(toEmail, ccEmail, content);
	}
	
}
