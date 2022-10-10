package com.capeelectric.exception;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capeelectric.util.ErrorMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({UserException.class})
    public ResponseEntity<ErrorMessage> handleUserException(UserException e){
    		ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "404");
    		return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({ChangePasswordException.class})
    public ResponseEntity<ErrorMessage> handleChangePasswordException(ChangePasswordException e){
    		ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "406");
    		return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    
   }
    
    @ExceptionHandler({CompanyDetailsException.class})
    public ResponseEntity<ErrorMessage> handleCompanyDetailsException(CompanyDetailsException e) {
        ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "400");
        return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ForgotPasswordException.class})
    public ResponseEntity<ErrorMessage> handleForgotPasswordException(ForgotPasswordException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "406");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
    
    @ExceptionHandler({UpdatePasswordException.class})
    public ResponseEntity<ErrorMessage> handleUpdatePasswordException(UpdatePasswordException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "400");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({InstalReportException.class})
    public ResponseEntity<ErrorMessage> handleInstalReportException(InstalReportException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "404");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({SupplyCharacteristicsException.class})
    public ResponseEntity<ErrorMessage> handleSupplyCharacteristicsException(SupplyCharacteristicsException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "406");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler({InspectionException.class})
    public ResponseEntity<ErrorMessage> handleInspectionException(InspectionException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "404");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({DecimalConversionException.class})
    public ResponseEntity<ErrorMessage> handleDecimalConversionException(DecimalConversionException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "400");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({PeriodicTestingException.class})
    public ResponseEntity<ErrorMessage> handlePeriodicTestingException(PeriodicTestingException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "404");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({SummaryException.class})
    public ResponseEntity<ErrorMessage> handleSummaryException(SummaryException e){
            ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "406");
            return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler({RegistrationException.class})
    public ResponseEntity<ErrorMessage> handleRegistrationException(RegistrationException e){
    		ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "406");
    		return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
    
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ErrorMessage> handleAuthenticationException(AuthenticationException e){
    		ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "404");
    		return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({ObservationException.class})
    public ResponseEntity<ErrorMessage> handleObservationException(ObservationException e){
    		ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "404");
    		return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler({PdfException.class})
    public ResponseEntity<ErrorMessage> handlePDFException(ObservationException e){
    	ErrorMessage exceptionMessage = new ErrorMessage(e.getMessage(), e.getLocalizedMessage(), "406");
    	return new ResponseEntity<ErrorMessage>(exceptionMessage, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
    }
}