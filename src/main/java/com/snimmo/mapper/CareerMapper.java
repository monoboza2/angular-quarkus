package com.snimmo.mapper;

import com.snimmo.domain.Career;
import com.snimmo.dto.CareerDto;
import org.mapstruct.*;

@Mapper(componentModel="jakarta")
public interface CareerMapper {
    @Mapping(target = "id", source = "id")
    Career toEntity(CareerDto careerDto);
    @Mapping(target = "id", source = "id")
    CareerDto toDto(Career career);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Career partialUpdate(CareerDto careerDto, @MappingTarget Career career);
}