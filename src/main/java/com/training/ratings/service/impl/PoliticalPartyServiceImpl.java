package com.training.ratings.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ratings.dto.PoliticalPartyDto;
import com.training.ratings.entity.PoliticalParty;
import com.training.ratings.exceptions.PoliticalPartyNotFoundException;
import com.training.ratings.repository.PoliticalPartyRepository;
import com.training.ratings.service.PoliticalPartyService;

@Service
public class PoliticalPartyServiceImpl implements PoliticalPartyService {

	@Autowired
	private PoliticalPartyRepository politicalPartyRepository;

	@Override
	public PoliticalPartyDto registerParty(PoliticalPartyDto politicalPartyDto) {
		PoliticalParty politicalParty = new PoliticalParty();
		BeanUtils.copyProperties(politicalPartyDto, politicalParty);
		politicalPartyRepository.save(politicalParty);
		return politicalPartyDto;
	}

	@Override
	public PoliticalPartyDto updateParty(PoliticalPartyDto politicalPartyDto) {
		PoliticalParty politicalParty = new PoliticalParty();
		BeanUtils.copyProperties(politicalPartyDto, politicalParty);
		politicalPartyRepository.save(politicalParty);
		return politicalPartyDto;
	}

	@Override
	public boolean deleteParty(Long partyId) {
		PoliticalPartyDto politicalPartyDto = getPartyById(partyId);
		PoliticalParty politicalParty = new PoliticalParty();
		BeanUtils.copyProperties(politicalPartyDto, politicalParty);
		politicalPartyRepository.delete(politicalParty);
		return false;
	}

	@Override
	public PoliticalPartyDto getPartyById(Long partyId) {
		Optional<PoliticalParty> politicalParty = politicalPartyRepository.findById(partyId);
		if (!politicalParty.isPresent()) {
			PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
			BeanUtils.copyProperties(politicalParty.get(), politicalPartyDto);
			return politicalPartyDto;
		} else {
			throw new PoliticalPartyNotFoundException("Party with Id " + partyId + " not found");
		}
	}

	@Override
	public List<PoliticalPartyDto> getAllParties() {
		List<PoliticalParty> politicalParties = politicalPartyRepository.findAll();
		List<PoliticalPartyDto> politicalPartyDtos = new ArrayList<>();
		for (PoliticalParty politicalParty : politicalParties) {
			PoliticalPartyDto politicalPartyDto = new PoliticalPartyDto();
			BeanUtils.copyProperties(politicalParty, politicalPartyDto);
			politicalPartyDtos.add(politicalPartyDto);
		}
		return politicalPartyDtos;
	}


}
