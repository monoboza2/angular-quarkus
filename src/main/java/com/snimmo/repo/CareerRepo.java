package com.snimmo.repo;

import com.snimmo.domain.Career;
import com.snimmo.domain.enums.Position;
import com.snimmo.util.PagedResult;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.logging.Logger;


import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CareerRepo implements PanacheRepository<Career> {

    private static final Logger LOG = Logger.getLogger(CareerRepo.class);

    public PagedResult<Career> findPagedAndSorted(int page, int size, String sortField, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.ascending(sortField) : Sort.descending(sortField);
        Page paging = Page.of(page, size);

        PanacheQuery<Career> query = findAll(sort).page(paging);
        List<Career> careers = query.list();
        long totalCount = query.count();

        return new PagedResult<>(careers, totalCount, page, size);
    }

    public PagedResult<Career> searchCareers(Position position, Boolean statusPosition, int page, int size, String sortField, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.ascending(sortField) : Sort.descending(sortField);
        Page paging = Page.of(page, size);

        PanacheQuery<Career> query = find("position = ?1 and statusPosition = ?2", sort, position, statusPosition).page(paging);
        List<Career> careers = query.list();
        long totalCount = query.count();

        return new PagedResult<>(careers, totalCount, page, size);
    }
}
