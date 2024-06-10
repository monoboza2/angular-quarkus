package com.snimmo.dto;

import com.snimmo.domain.enums.Position;

public class CareerDto{

    private Long id;

    private Position position;

    private String description;

    private String salaryExpect;

    private Integer amountReceived;

    private boolean statusPosition;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSalaryExpect() {
        return salaryExpect;
    }

    public void setSalaryExpect(String salaryExpect) {
        this.salaryExpect = salaryExpect;
    }

    public Integer getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(Integer amountReceived) {
        this.amountReceived = amountReceived;
    }

    public boolean isStatusPosition() {
        return statusPosition;
    }

    public void setStatusPosition(boolean statusPosition) {
        this.statusPosition = statusPosition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
