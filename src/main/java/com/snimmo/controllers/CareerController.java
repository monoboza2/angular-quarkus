package com.snimmo.controllers;

import com.snimmo.domain.enums.Position;
import com.snimmo.dto.CareerDto;
import com.snimmo.service.CareerService;
import com.snimmo.util.PagedResult;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/api/career")
public class CareerController {


    private final CareerService careerService;

    @Inject
    CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)

    public Response createCareer(CareerDto career) {
        careerService.addCareer(career);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PagedResult<CareerDto> getCareersPagedAndSorted(@QueryParam("page") @DefaultValue("0") int page,
                                                           @QueryParam("size") @DefaultValue("10") int size,
                                                           @QueryParam("sortField") @DefaultValue("id") String sortField,
                                                           @QueryParam("sortOrder") @DefaultValue("asc") String sortOrder) {
        return careerService.getCareersPagedAndSorted(page, size, sortField, sortOrder);
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public PagedResult<CareerDto> searchCareers(@QueryParam("position") Position position,
                                                @QueryParam("statusPosition") Boolean statusPosition,
                                                @QueryParam("page") @DefaultValue("0") int page,
                                                @QueryParam("size") @DefaultValue("10") int size,
                                                @QueryParam("sortField") @DefaultValue("id") String sortField,
                                                @QueryParam("sortOrder") @DefaultValue("asc") String sortOrder) {
        return careerService.searchCareers(position, statusPosition, page, size, sortField, sortOrder);
    }


    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateCareer(@PathParam("id") Long id, CareerDto career) {
        careerService.updateCareer(id, career);
        return Response.status(Response.Status.OK).build();
    }

    //
    @DELETE
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteCareer(@PathParam("id") Long id) {
        careerService.deleteCareer(id);
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
