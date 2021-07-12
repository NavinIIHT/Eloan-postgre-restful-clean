package com.iiht.training.eloan.exception;

import static com.iiht.training.eloan.testutils.TestUtils.currentTest;
import static com.iiht.training.eloan.testutils.TestUtils.exceptionTestFile;
import static com.iiht.training.eloan.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.eloan.controller.CustomerController;
import com.iiht.training.eloan.model.LoanDto;
import com.iiht.training.eloan.model.exception.ExceptionResponse;
import com.iiht.training.eloan.service.CustomerService;
import com.iiht.training.eloan.testutils.MasterData;

@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class CustomerExceptionTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;
	
	@Test
	public void testApplyLoanCustomerNotFoundException() throws Exception {
		LoanDto loanDto = MasterData.getLoanDto();
		ExceptionResponse exResponse = new ExceptionResponse("Customer with Id - 2 not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		
		when(this.customerService.applyLoan(2L, loanDto)).thenThrow(new CustomerNotFoundException("Customer with Id - 2 not found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customer/apply-loan/2")
				.content(MasterData.asJsonString(loanDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contains(exResponse.getMessage())? "true" : "false"),	
				exceptionTestFile);
		
	}
	
	@Test
	public void testGetStatusLoanNotFoundException() throws Exception {
		
		ExceptionResponse exResponse = new ExceptionResponse("Loan with Id - 2 not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		
		when(this.customerService.getStatus(2L)).thenThrow(new LoanNotFoundException("Loan with Id - 2 not found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/loan-status/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contains(exResponse.getMessage())? "true" : "false"),	
				exceptionTestFile);
		
	}
	
	@Test
	public void testGetStatusAllCustomerNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("Customer with Id - 2 not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		
		when(this.customerService.getStatusAll(2L)).thenThrow(new CustomerNotFoundException("Customer with Id - 2 not found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customer/loan-status-all/2")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contains(exResponse.getMessage())? "true" : "false"),	
				exceptionTestFile);
		
	}
	
}
