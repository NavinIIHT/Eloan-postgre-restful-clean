package com.iiht.training.eloan.boundary;

import static com.iiht.training.eloan.testutils.TestUtils.currentTest;
import static com.iiht.training.eloan.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.eloan.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.eloan.model.LoanDto;
import com.iiht.training.eloan.model.ProcessingDto;
import com.iiht.training.eloan.model.SanctionDto;
import com.iiht.training.eloan.model.UserDto;
import com.iiht.training.eloan.testutils.MasterData;

@ExtendWith(SpringExtension.class)
// @WebMvcTest
public class BoundaryTest {
	private Validator validator;

    //----------------------------------------------------------------------------------------------
    @BeforeEach
    public void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
	public void testUserFirstNameNotNull() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setFirstName("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserFirstNameMinThree() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setFirstName("Ab");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserFirstNameMaxHundred() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		String name = "";
		for(int i=0;i<120;i++) {
			name.concat("A");
		}
		userDto.setFirstName(name);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserLastNameNotNull() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setLastName("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserLastNameMinThree() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setLastName("Ab");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserLastNameMaxHundred() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		String name = "";
		for(int i=0;i<120;i++) {
			name.concat("A");
		}
		userDto.setLastName(name);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    
    @Test
	public void testUserEmailNotNull() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setEmail("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserEmailMinThree() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setEmail("Ab");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserEmailMaxHundred() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		String name = "";
		for(int i=0;i<120;i++) {
			name.concat("A");
		}
		userDto.setEmail(name);
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserEmailValidFormat() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setEmail("abc");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserMobileNotNull() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setMobile("");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserMobileMinTen() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		userDto.setMobile("12345");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testUserMobileMaxTen() throws Exception 
	{
		UserDto userDto =  MasterData.getUserDto();
		
		userDto.setMobile("123456789001");
		Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanNameNotNull() throws Exception 
	{
		LoanDto loanDto = MasterData.getLoanDto();
		loanDto.setLoanName(null);
		Set<ConstraintViolation<LoanDto>> violations = validator.validate(loanDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanNameMinThree() throws Exception 
	{
    	LoanDto loanDto = MasterData.getLoanDto();
		loanDto.setLoanName("ab");
		Set<ConstraintViolation<LoanDto>> violations = validator.validate(loanDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanNameMaxHundred() throws Exception 
	{
    	LoanDto loanDto = MasterData.getLoanDto();
		String name = "";
		for(int i=0;i<120;i++) {
			name.concat("A");
		}
		loanDto.setLoanName(name);
		Set<ConstraintViolation<LoanDto>> violations = validator.validate(loanDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanAmountNotNull() throws Exception 
	{
		LoanDto loanDto = MasterData.getLoanDto();
		loanDto.setLoanAmount(null);
		Set<ConstraintViolation<LoanDto>> violations = validator.validate(loanDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanAmountNotZero() throws Exception 
	{
    	LoanDto loanDto = MasterData.getLoanDto();
		loanDto.setLoanAmount(0.0);
		Set<ConstraintViolation<LoanDto>> violations = validator.validate(loanDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAcresOfLandNotNull() throws Exception 
	{
		ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAcresOfLand(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAcresOfLandNotZero() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAcresOfLand(0.0);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLandValueNotNull() throws Exception 
	{
		ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setLandValue(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLandValueNotZero() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setLandValue(0.0);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testSuggestedAmountOfLoanNotNull() throws Exception 
	{
		ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setSuggestedAmountOfLoan(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testSuggestedAmountOfLoanNotZero() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setSuggestedAmountOfLoan(0.0);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAddressOfPropertyNotNull() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAddressOfProperty(null);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAddressOfPropertyMinThree() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		processingDto.setAddressOfProperty("ab");
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testAddressOfPropertyMaxOneFifty() throws Exception 
	{
    	ProcessingDto processingDto =  MasterData.getProcessingDto();
		String name = "";
		for(int i=0;i<160;i++) {
			name.concat("A");
		}
		processingDto.setAddressOfProperty(name);
		Set<ConstraintViolation<ProcessingDto>> violations = validator.validate(processingDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanAmountSanctionedNotNull() throws Exception 
	{
		SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setLoanAmountSanctioned(null);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanAmountSanctionedNotZero() throws Exception 
	{
    	SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setLoanAmountSanctioned(0.0);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testTermOfLoanNotNull() throws Exception 
	{
		SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setTermOfLoan(null);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testTermOfLoanNNotZero() throws Exception 
	{
    	SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setTermOfLoan(0.0);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
}
