package com.mohan.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohan.college.entities.College;
import com.mohan.college.repo.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	@Override
	public List<College> getAll() {
		
		return collegeRepository.findAll();
	}

	@Override
	public void save(College college) {
		collegeRepository.save(college);
		
	}

	@Override
	public College getById(Long id) {
		return collegeRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		collegeRepository.deleteById(id);
		
	}
}
