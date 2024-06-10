package com.snimmo.service;

import com.snimmo.domain.Career;
import com.snimmo.domain.enums.Position;
import com.snimmo.dto.CareerDto;
import com.snimmo.util.PagedResult;

import java.util.List;

public interface CareerService {
    void addCareer(CareerDto careerDto);

//    List<CareerDto> getCareersPagedAndSorted(int page, int size, String sortField, String sortOrder);

    void updateCareer(Long id, CareerDto careerDto);

    void deleteCareer(Long careerId);

    // PagedResult<CareerDto> getAllCareers(int page, int size, String sortField, String sortOrder);

    PagedResult<CareerDto> searchCareers(Position position, Boolean statusPosition, int page, int size, String sortField, String sortOrder);
    PagedResult<CareerDto> getCareersPagedAndSorted(int page, int size, String sortField, String sortOrder);


    }