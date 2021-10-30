package com.training.ratings.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.ratings.dto.DevelopmentDto;
import com.training.ratings.repository.DevelopmentRepository;
import com.training.ratings.service.DevelopmentService;
import com.training.ratings.entity.Development;
import com.training.ratings.exceptions.DevelopmentNotFoundException;

@Service
public class DevelopmentServiceImpl implements DevelopmentService {

	@Autowired
	private DevelopmentRepository repository;

	@Override
	public DevelopmentDto createDevelopment(DevelopmentDto developmentDto) {
	Development development = new Development();
	BeanUtils.copyProperties(developmentDto,development);
	repository.save(development);
	return developmentDto;
	}

	@Override
	public DevelopmentDto updateDevelopment(DevelopmentDto developmentDto) {
	Development development = new Development();
	BeanUtils.copyProperties(developmentDto,development);
	repository.save(development);
	return developmentDto;
	}

	@Override
	public boolean deleteDevelopment(Long developmentId) {
		DevelopmentDto devById = getDevelopmentById(developmentId);
		Development development = new Development();
		BeanUtils.copyProperties(devById, development);
		repository.delete(development);
		return true;
	}

	@Override
	public DevelopmentDto getDevelopmentById(Long developmentId) {
		Optional<Development> devById = repository.findById(developmentId);
		if (devById.isPresent()) {
			DevelopmentDto developmentDto = new DevelopmentDto();
			BeanUtils.copyProperties(devById.get(), developmentDto);
			return developmentDto;
		} else {
			throw new DevelopmentNotFoundException("Development with id " + developmentId + " not found");
		}
	}

	@Override
	public List<DevelopmentDto> getAllDevelopments() {
		List<Development> devList = repository.findAll();
		List<DevelopmentDto> devrDtos = new ArrayList<>();
		for (Development dev : devList) {
			DevelopmentDto devDto = new DevelopmentDto();
			BeanUtils.copyProperties(dev, devDto);
			
		}
		return devrDtos;
	}

	@Override
	public List<DevelopmentDto> getAllDevelopmentsByLeaderId(Long politicalLeaderId) {
		return null;
	}

}
