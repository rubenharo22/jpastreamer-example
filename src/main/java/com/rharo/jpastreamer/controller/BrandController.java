package com.rharo.jpastreamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rharo.jpastreamer.dto.BrandDto;
import com.rharo.jpastreamer.interfaces.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@GetMapping
	public ResponseEntity<List<BrandDto>> findAllUsers(@RequestParam(value = "name", required = false) String name) {

		if (null != name) {

			return ResponseEntity.ok(brandService.findByName(name));

		}
		return ResponseEntity.ok(brandService.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<BrandDto> findById(@PathVariable Long id) {

		return ResponseEntity.ok(brandService.findById(id));

	}

}