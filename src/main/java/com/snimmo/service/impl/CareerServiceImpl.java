package com.snimmo.service.impl;


import com.snimmo.domain.Career;
import com.snimmo.domain.enums.Position;
import com.snimmo.dto.CareerDto;
import com.snimmo.mapper.CareerMapper;
import com.snimmo.repo.CareerRepo;
import com.snimmo.service.CareerService;
import com.snimmo.util.PagedResult;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;


import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CareerServiceImpl implements CareerService {

    private final CareerRepo careerRepo;
    private final CareerMapper careerMapper;
    private final EntityManager entityManager;

    @Inject
    CareerServiceImpl(CareerRepo careerRepo, CareerMapper careerMapper, EntityManager entityManager) {
        this.careerRepo = careerRepo;
        this.careerMapper = careerMapper;
        this.entityManager = entityManager;

    }

    @Override
    @Transactional
    public void addCareer(CareerDto careerDto) {
       careerRepo.persist(careerMapper.toEntity(careerDto));
    }


    public PagedResult<CareerDto> getCareersPagedAndSorted(int page, int size, String sortField, String sortOrder) {
        PagedResult<Career> result = careerRepo.findPagedAndSorted(page, size, sortField, sortOrder);
        List<CareerDto> careerDtos = result.getContent().stream()
                .map(careerMapper::toDto)
                .collect(Collectors.toList());
        return new PagedResult<>(careerDtos, result.getTotalElements(), page, size);
    }

    public PagedResult<CareerDto> searchCareers(Position position, Boolean statusPosition, int page, int size, String sortField, String sortOrder) {
        PagedResult<Career> result = careerRepo.searchCareers(position, statusPosition, page, size, sortField, sortOrder);
        List<CareerDto> careerDtos = result.getContent().stream()
                .map(careerMapper::toDto)
                .collect(Collectors.toList());
        return new PagedResult<>(careerDtos, result.getTotalElements(), page, size);
    }

    @Override
    @Transactional
    public void updateCareer(Long id, CareerDto careerDto) {
        Career career = careerRepo.findById(id);
        if (career == null) {
            throw new NotFoundException();
        } else {
            career.setPosition(careerDto.getPosition());
            career.setDescription(careerDto.getDescription());
            career.setSalaryExpect(career.getSalaryExpect());
            career.setStatusPosition(careerDto.isStatusPosition());
            career.setAmountReceived(careerDto.getAmountReceived());
        }
        careerRepo.persist(career);
    }

    @Override
    @Transactional
    public void deleteCareer(Long careerId) {
        careerRepo.deleteById(careerId);
    }

}
