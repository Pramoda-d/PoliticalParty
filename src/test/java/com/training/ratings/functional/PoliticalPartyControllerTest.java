package com.training.ratings.functional;

import static com.training.ratings.testutils.TestUtils.businessTestFile;
import static com.training.ratings.testutils.TestUtils.currentTest;
import static com.training.ratings.testutils.TestUtils.testReport;
import static com.training.ratings.testutils.TestUtils.testAssert;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
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

import com.training.ratings.controller.PoliticalPartyController;
import com.training.ratings.dto.PoliticalPartyDto;
import com.training.ratings.service.PoliticalPartyService;
import com.training.ratings.testutils.MasterData;

@WebMvcTest(PoliticalPartyController.class)
@AutoConfigureMockMvc
public class PoliticalPartyControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PoliticalPartyService partyService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testRegisterPoliticalParty() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		PoliticalPartyDto savedPoliticalPartyDto = MasterData.getPartyDto();

		savedPoliticalPartyDto.setPoliticalPartyId(1L);

		when(this.partyService.registerParty(politicalPartyDto)).thenReturn(savedPoliticalPartyDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/parties/register-party")
				.content(MasterData.asJsonString(politicalPartyDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		testAssert(currentTest(),
				(result.getResponse().getContentAsString()
						.contentEquals(MasterData.asJsonString(savedPoliticalPartyDto)) ? "true" : "false"),
				businessTestFile);

	}

	@Test
	public void testRegisterPoliticalPartyIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		PoliticalPartyDto savedPoliticalPartyDto = MasterData.getPartyDto();

		savedPoliticalPartyDto.setPoliticalPartyId(1L);
		when(partyService.registerParty(politicalPartyDto)).then(new Answer<PoliticalPartyDto>() {

			@Override
			public PoliticalPartyDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedPoliticalPartyDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/politics/api/v1/parties/register-party")
				.content(MasterData.asJsonString(politicalPartyDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		testAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testGetAllPoliticalParties() throws Exception {
		List<PoliticalPartyDto> politicalPartyDtos = MasterData.getPartyDtoList();

		when(this.partyService.getAllParties()).thenReturn(politicalPartyDtos);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/parties/get/all").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		testAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(politicalPartyDtos))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetAllPoliticalPartiesIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		List<PoliticalPartyDto> politicalPartyDtos = MasterData.getPartyDtoList();
		when(this.partyService.getAllParties()).then(new Answer<List<PoliticalPartyDto>>() {

			@Override
			public List<PoliticalPartyDto> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return politicalPartyDtos;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/parties/get/all").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		testAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}
	
	@Test
	public void testGetPoliticalPartyById() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		politicalPartyDto.setPoliticalPartyId(1L);
		when(this.partyService.getPartyById(1L)).thenReturn(politicalPartyDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/parties/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		testAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(politicalPartyDto))
						? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testGetPoliticalPartyByIdIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		when(this.partyService.getPartyById(1L)).then(new Answer<PoliticalPartyDto>() {

			@Override
			public PoliticalPartyDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return politicalPartyDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/politics/api/v1/parties/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		testAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}


	@Test
	public void testUpdatePoliticalParty() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		PoliticalPartyDto savedPoliticalPartyDto = MasterData.getPartyDto();

		savedPoliticalPartyDto.setPoliticalPartyId(1L);

		when(this.partyService.updateParty(politicalPartyDto)).thenReturn(savedPoliticalPartyDto);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/politics/api/v1/parties/update-party")
				.content(MasterData.asJsonString(politicalPartyDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		testAssert(currentTest(),
				(result.getResponse().getContentAsString()
						.contentEquals(MasterData.asJsonString(savedPoliticalPartyDto)) ? "true" : "false"),
				businessTestFile);

	}

	@Test
	public void testUpdatePoliticalPartyIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		PoliticalPartyDto savedPoliticalPartyDto = MasterData.getPartyDto();

		savedPoliticalPartyDto.setPoliticalPartyId(1L);
		when(partyService.updateParty(politicalPartyDto)).then(new Answer<PoliticalPartyDto>() {

			@Override
			public PoliticalPartyDto answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return savedPoliticalPartyDto;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/politics/api/v1/parties/update-party")
				.content(MasterData.asJsonString(politicalPartyDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		testAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

	@Test
	public void testDeletePoliticalParty() throws Exception {
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		politicalPartyDto.setPoliticalPartyId(1L);

		when(this.partyService.deleteParty(1L)).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/politics/api/v1/parties/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		testAssert(currentTest(),
				(result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(true)) ? "true"
						: "false"),
				businessTestFile);

	}

	@Test
	public void testDeletePoliticalPartyIsServiceMethodCalled() throws Exception {
		final int count[] = new int[1];
		PoliticalPartyDto politicalPartyDto = MasterData.getPartyDto();
		politicalPartyDto.setPoliticalPartyId(1L);
		when(partyService.deleteParty(1L)).then(new Answer<Boolean>() {

			@Override
			public Boolean answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return true;
			}
		});
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/politics/api/v1/parties/1")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		testAssert(currentTest(), count[0] == 1 ? true : false, businessTestFile);

	}

}
