package com.rharo.jpastreamer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rharo.jpastreamer.dto.BrandDto;
import com.rharo.jpastreamer.interfaces.BrandService;
import com.rharo.jpastreamer.model.Brand;
import com.rharo.jpastreamer.service.mapper.BrandMapper;
import com.speedment.jpastreamer.application.JPAStreamer;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private JPAStreamer jpaStreamer;

	@Autowired
	private BrandMapper brandMapper;

	@Override
	public List<BrandDto> findAll() {

		List<Brand> brandList = jpaStreamer.stream(Brand.class).collect(Collectors.toList());

		return brandMapper.convertToDto(brandList);

	}

	@Override
	public BrandDto findById(Long id) {

		Brand brand = jpaStreamer.stream(Brand.class).filter(item -> item.getId().equals(id)).findFirst().orElseThrow();

		return brandMapper.convertToDto(brand);
	}

	@Override
	public List<BrandDto> findByName(String name) {

		List<Brand> brandList = jpaStreamer.stream(Brand.class).filter(item -> item.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());

		return brandMapper.convertToDto(brandList);
	}

}