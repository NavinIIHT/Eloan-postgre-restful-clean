package com.iiht.training.eloan.functional;

import static com.iiht.training.eloan.testutils.TestUtils.businessTestFile;
import static com.iiht.training.eloan.testutils.TestUtils.currentTest;
import static com.iiht.training.eloan.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.when;

import java.util.List;

//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.iiht.training.eloan.controller.AdminController;
import com.iiht.training.eloan.model.UserDto;
import com.iiht.training.eloan.service.AdminService;
import com.iiht.training.eloan.testutils.MasterData;

//@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
@AutoConfigureMockMvc
//@ContextConfiguration(classes = {AdminController.class})
//@WebMvcTest
// @SpringBootTest
public class AdminControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AdminService adminService;
	
	
	
	@Test
	public void testRegisterClerk() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setId(1L);
		
		when(this.adminService.registerClerk(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/register-clerk")
				.content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedUserDto))? "true" : "false"),	
				businessTestFile);
		
	}
	
	@Test
	public void testRegisterClerkBehavior() throws Exception {
		final int count[] = new int[1];
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setId(1L);
		when(this.adminService.registerClerk(userDto)).then(new Answer<UserDto>() {

			@Override
			public UserDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedUserDto;
			}
		});
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/register-clerk")
				.content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				count[0] == 1? true : false,	
				businessTestFile);
		
	
	}
	
	@Test
	public void testGetAllClerks() throws Exception {
		List<UserDto> userDtos = MasterData.getUserDtoList();
		
		when(this.adminService.getAllClerks()).thenReturn(userDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/all-clerks")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(userDtos))? "true" : "false"),	
				businessTestFile);
		
	}
	
	@Test
	public void testGetAllClerksBehavior() throws Exception {
		final int count[] = new int[1];
		List<UserDto> userDtos = MasterData.getUserDtoList();
		when(this.adminService.getAllClerks()).then(new Answer<List<UserDto>>() {

			@Override
			public List<UserDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return userDtos;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/all-clerks")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		yakshaAssert(currentTest(), 
				count[0] == 1? true : false,	
				businessTestFile);
		
	
	}
	
	@Test
	public void testRegisterManager() throws Exception {
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setId(1L);
		
		when(this.adminService.registerManager(userDto)).thenReturn(savedUserDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/register-manager")
				.content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(savedUserDto))? "true" : "false"),	
				businessTestFile);
		
	}
	
	@Test
	public void testRegisterManagerBehavior() throws Exception {
		final int count[] = new int[1];
		UserDto userDto = MasterData.getUserDto();
		UserDto savedUserDto = MasterData.getUserDto();
		savedUserDto.setId(1L);
		when(this.adminService.registerManager(userDto)).then(new Answer<UserDto>() {

			@Override
			public UserDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedUserDto;
			}
		});
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin/register-manager")
				.content(MasterData.asJsonString(userDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				count[0] == 1? true : false,	
				businessTestFile);
		
	
	}
	
	@Test
	public void testGetAllManagers() throws Exception {
		List<UserDto> userDtos = MasterData.getUserDtoList();
		
		when(this.adminService.getAllManagers()).thenReturn(userDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/all-managers")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(userDtos))? "true" : "false"),	
				businessTestFile);
		
	}
	
	@Test
	public void testGetAllManagersBehavior() throws Exception {
		final int count[] = new int[1];
		List<UserDto> userDtos = MasterData.getUserDtoList();
		when(this.adminService.getAllManagers()).then(new Answer<List<UserDto>>() {

			@Override
			public List<UserDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return userDtos;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admin/all-managers")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		yakshaAssert(currentTest(), 
				count[0] == 1? true : false,	
				businessTestFile);
		
	
	}
}
