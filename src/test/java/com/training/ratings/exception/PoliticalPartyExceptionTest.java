package com.training.ratings.exception;

import static com.training.ratings.testutils.TestUtils.currentTest;
import static com.training.ratings.testutils.TestUtils.exceptionTestFile;
import static com.training.ratings.testutils.TestUtils.testReport;
import static com.training.ratings.testutils.TestUtils.testAssert;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
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

import com.training.ratings.controller.PoliticalPartyController;
import com.training.ratings.dto.PoliticalPartyDto;
import com.training.ratings.exceptions.PoliticalPartyNotFoundException;
import com.training.ratings.model.exception.ExceptionResponse;
import com.training.ratings.service.PoliticalPartyService;
import com.training.ratings.testutils.MasterData;

@WebMvcTest(PoliticalPartyController.class)
@AutoConfigureMockMvc
public class PoliticalPartyExceptionTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PoliticalPartyService partyService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testRegisterPoliticalPartyInvalidDataException() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		PoliticalPartyDto savedPoliticalPartyDto = MasterData.getPartyDto();
		savedPoliticalPartyDto.setPoliticalPartyId(1L);

		politicalPartyDto.setPartyName("Ab");

		when(this.partyService.registerParty(politicalPartyDto)).thenReturn(savedPoliticalPartyDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/parties/register-party")
				.content(MasterData.asJsonString(politicalPartyDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		testAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}
	
	@Test
	public void testUpdatePoliticalPartyInvalidDataException() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		PoliticalPartyDto savedPoliticalPartyDto = MasterData.getPartyDto();
		savedPoliticalPartyDto.setPoliticalPartyId(1L);

		politicalPartyDto.setPartyName("Ab");

		when(this.partyService.registerParty(politicalPartyDto)).thenReturn(savedPoliticalPartyDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/politics/api/v1/parties/update-party")
				.content(MasterData.asJsonString(politicalPartyDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		testAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}


	@Test
	public void testDeletePoliticalPartyNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("Political Party with Id - 2 not Found!", System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value());

		when(this.partyService.deleteParty(2L)).thenThrow(new PoliticalPartyNotFoundException("Political Party with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/politics/api/v1/parties/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		testAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);

	}
	@Test
	public void testGetByIdPoliticalPartyNotFoundException() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse("Political Party with Id - 2 not Found!", System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value());
		
		when(this.partyService.getPartyById(2L)).thenThrow(new PoliticalPartyNotFoundException("Political Party with Id - 2 not Found!"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/parties/2")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		testAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);
		
	}

}
