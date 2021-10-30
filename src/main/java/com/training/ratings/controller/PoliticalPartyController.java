package com.training.ratings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ratings.dto.PoliticalPartyDto;
import com.training.ratings.exceptions.InvalidDataException;
import com.training.ratings.service.PoliticalPartyService;

import javax.validation.Valid;

@RestController
@RequestMapping("/politics/api/v1/parties")
public class PoliticalPartyController {

	@Autowired
	private PoliticalPartyService politicalPartyService;

	@PostMapping("/register-party")
	public ResponseEntity<?> createParty(@Valid @RequestBody PoliticalPartyDto politicalPartyDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Party Data is not Valid");
		}
		politicalPartyService.registerParty(politicalPartyDto);
		return ResponseEntity.ok(politicalPartyDto);

	}

	@PutMapping("/update-party")
	public ResponseEntity<?> updateParty(@Valid @RequestBody PoliticalPartyDto politicalPartyDto, BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Party Data is not Valid");
		}
		politicalPartyService.updateParty(politicalPartyDto);
		return ResponseEntity.ok(politicalPartyDto);

	}

	@DeleteMapping("/{partyId}")
	public ResponseEntity<?> deleteParty(@PathVariable Long partyId) {
		boolean result = politicalPartyService.deleteParty(partyId);
		return ResponseEntity.ok(result);

	}

	@GetMapping("/{partyId}")
	public ResponseEntity<PoliticalPartyDto> getPartyById(@PathVariable Long partyId) {
		PoliticalPartyDto politicalPartyDto = politicalPartyService.getPartyById(partyId);
		return ResponseEntity.ok(politicalPartyDto);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<PoliticalPartyDto>> getAllParties() {
		List<PoliticalPartyDto> politicalPartyDtos = politicalPartyService.getAllParties();
		return ResponseEntity.ok(politicalPartyDtos);
	}

}
