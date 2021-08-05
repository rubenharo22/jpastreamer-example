package com.rharo.jpastreamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rharo.jpastreamer.dto.CarDto;
import com.rharo.jpastreamer.interfaces.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping
	public ResponseEntity<List<CarDto>> findAllUsers() {
		return ResponseEntity.ok(carService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CarDto> findById(@PathVariable Long id) {

		return ResponseEntity.ok(carService.findById(id));

	}

}