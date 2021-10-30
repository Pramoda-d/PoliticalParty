package com.training.ratings.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ratings.dto.PoliticalLeaderDto;
import com.training.ratings.exceptions.InvalidDataException;
import com.training.ratings.service.PoliticalLeaderService;

@RestController
@RequestMapping("/politics/api/v1")
public class PoliticalLeaderController {

	@Autowired
	private PoliticalLeaderService politicalLeaderService;

	@PostMapping("/leader/register-leader")
	public ResponseEntity<?> addPoliticalLeader(@Valid @RequestBody PoliticalLeaderDto politicalLeaderDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Political Leader Data is not valid");
		}
		politicalLeaderService.registerPoliticalLeader(politicalLeaderDto);
		return ResponseEntity.ok(politicalLeaderDto);

	}

	@PutMapping("/update-leader")
	public ResponseEntity<?> updatePoliticalLeader(@Valid @RequestBody PoliticalLeaderDto politicalLeaderDto,
			BindingResult result) {
		if (result.hasErrors()) {
			throw new InvalidDataException("Political Leader Data is not valid");
		}
		politicalLeaderService.updatePoliticalLeader(politicalLeaderDto);
		return ResponseEntity.ok(politicalLeaderDto);

	}
	

	@DeleteMapping("/party/delete/{leaderId}")
	public ResponseEntity<?> deletePoliticalLeader(@PathVariable Long leaderId) {
	
		politicalLeaderService.deletePoliticalLeader(leaderId);
		return ResponseEntity.ok(true);

	}

	@GetMapping("/{politicalLeaderId}")
	public ResponseEntity<?> getPoliticalLeaderById(@PathVariable Long politicalLeaderId) {

		PoliticalLeaderDto politicalLeaderById = politicalLeaderService.getPoliticalLeaderById(politicalLeaderId);
		return ResponseEntity.ok(politicalLeaderById);

	}

	@GetMapping
	public ResponseEntity<?> getAllPoliticalLeader() {
		List<PoliticalLeaderDto> allPoliticalLeaders = politicalLeaderService.getAllPoliticalLeaders();
		return ResponseEntity.ok(allPoliticalLeaders);

	}

	@GetMapping("/by-party-id/{politicalPartyId}")
	public ResponseEntity<?> getAllPoliticalLeaderByPartyId(@PathVariable Long politicalPartyId) {

		List<PoliticalLeaderDto> politicalLeadersByPartyId = politicalLeaderService
				.getPoliticalLeadersByPartyId(politicalPartyId);
		return ResponseEntity.ok(politicalLeadersByPartyId);

	}

}
