package com.training.ratings.testutils;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.ratings.dto.DevelopmentDto;
import com.training.ratings.dto.PoliticalLeaderDto;
import com.training.ratings.dto.PoliticalPartyDto;

public class MasterData {

	public static PoliticalPartyDto getPartyDto() {
		PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
		politicalPartyDto.setPoliticalPartyId(1L);
		politicalPartyDto.setPartyName("National Party");
		politicalPartyDto.setFounderName("David");
		return politicalPartyDto;
	}

	public static List<PoliticalPartyDto> getPartyDtoList() {
		List<PoliticalPartyDto> politicalPartyDtos = new ArrayList<PoliticalPartyDto>();
		PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
		politicalPartyDto.setPoliticalPartyId(1L);
		politicalPartyDto.setPartyName("National Party");
		politicalPartyDto.setFounderName("David");
		politicalPartyDtos.add(politicalPartyDto);
		politicalPartyDto = new PoliticalPartyDto();
		politicalPartyDto.setPoliticalPartyId(2L);
		politicalPartyDto.setPartyName("State Party");
		politicalPartyDto.setFounderName("Alan");
		politicalPartyDtos.add(politicalPartyDto);
		return politicalPartyDtos;
	}

	public static PoliticalLeaderDto getPoliticalLeaderDto() {
		PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(1L);
		politicalLeaderDto.setPoliticalPartyId(1L);
		politicalLeaderDto.setCandidateName("Leena");
		politicalLeaderDto.setCandidateState("Karnataka");
		return politicalLeaderDto;
	}

	public static List<PoliticalLeaderDto> getPoliticalLeaderDtoList() {
		List<PoliticalLeaderDto> politicalLeaderDtos = new ArrayList<>();
		PoliticalLeaderDto politicalLeaderDto = new PoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(1L);
		politicalLeaderDto.setPoliticalPartyId(1L);
		politicalLeaderDto.setCandidateName("Leena");
		politicalLeaderDto.setCandidateState("Karnataka");
		politicalLeaderDtos.add(politicalLeaderDto);
		politicalLeaderDto = new PoliticalLeaderDto();
		politicalLeaderDto.setPoliticalLeaderId(2L);
		politicalLeaderDto.setPoliticalPartyId(2L);
		politicalLeaderDto.setCandidateName("Meena");
		politicalLeaderDto.setCandidateState("Bihar");
		politicalLeaderDtos.add(politicalLeaderDto);
		return politicalLeaderDtos;
	}

	public static DevelopmentDto getDevelopmentDto() {
		DevelopmentDto developmentDto = new DevelopmentDto();
		developmentDto.setDevelopmentId(1L);
		developmentDto.setPoliticalLeaderId(1L);
		developmentDto.setTitle("Smart City");
		developmentDto.setBudget("250000000");
		developmentDto.setActivity("Making Reads");
		developmentDto.setActivityMonth(5);
		developmentDto.setActivityYear(2022);
		developmentDto.setState("karnataka");
		return developmentDto;

	}

	public static List<DevelopmentDto> getDevelopmentDtoList() {
		List<DevelopmentDto> developmentDtos = new ArrayList<>();
		DevelopmentDto developmentDto = new DevelopmentDto();
		developmentDto.setDevelopmentId(1L);
		developmentDto.setPoliticalLeaderId(1L);
		developmentDto.setTitle("Smart City");
		developmentDto.setBudget("250000000");
		developmentDto.setActivity("Making Reads");
		developmentDto.setActivityMonth(5);
		developmentDto.setActivityYear(2022);
		developmentDto.setState("karnataka");
		developmentDtos.add(developmentDto);
		developmentDto = new DevelopmentDto();
		developmentDto.setDevelopmentId(2L);
		developmentDto.setPoliticalLeaderId(2L);
		developmentDto.setTitle("Health Camp");
		developmentDto.setBudget("2500000");
		developmentDto.setActivity("Organizing Health Camp");
		developmentDto.setActivityMonth(9);
		developmentDto.setActivityYear(2022);
		developmentDto.setState("Bihar");
		developmentDtos.add(developmentDto);
		return developmentDtos;

	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
