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

import com.iiht.training.eloan.controller.ClerkController;
import com.iiht.training.eloan.model.ProcessingDto;
import com.iiht.training.eloan.model.exception.ExceptionResponse;
import com.iiht.training.eloan.service.ClerkService;
import com.iiht.training.eloan.testutils.MasterData;

@WebMvcTest(ClerkController.class)
@AutoConfigureMockMvc
public class ClerkExceptionTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClerkService clerkService;
	
	@Test
	public void testProcessLoanClerkNotFoundException() throws Exception {
		ProcessingDto processingDto = MasterData.getProcessingDto();
		ExceptionResponse exResponse = new ExceptionResponse("Clerk with Id - 2 not Found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		
		when(this.clerkService.processLoan(2L, 1L, processingDto)).thenThrow(new ClerkNotFoundException("Clerk with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/clerk/process/2/1")
				.content(MasterData.asJsonString(processingDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contains(exResponse.getMessage())? "true" : "false"),	
				exceptionTestFile);
		
	}
	
	@Test
	public void testProcessLoanNotFoundException() throws Exception {
		ProcessingDto processingDto = MasterData.getProcessingDto();
		ExceptionResponse exResponse = new ExceptionResponse("Loan with Id - 2 not Found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		
		when(this.clerkService.processLoan(1L, 2L, processingDto)).thenThrow(new LoanNotFoundException("Loan with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/clerk/process/1/2")
				.content(MasterData.asJsonString(processingDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contains(exResponse.getMessage())? "true" : "false"),	
				exceptionTestFile);
		
	}
	@Test
	public void testAlreadyProcessedException() throws Exception {
		ProcessingDto processingDto = MasterData.getProcessingDto();
		ExceptionResponse exResponse = new ExceptionResponse("Loan with Id - 1 alredy processed!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		
		when(this.clerkService.processLoan(1L, 1L, processingDto)).thenThrow(new AlreadyProcessedException("Loan with Id - 1 alredy processed!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/clerk/process/1/1")
				.content(MasterData.asJsonString(processingDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contains(exResponse.getMessage())? "true" : "false"),	
				exceptionTestFile);
		
	}
	
	
}
