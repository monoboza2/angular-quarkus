package com.snimmo.domain;

import com.snimmo.domain.enums.Position;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="Career")
public class Career extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CAREER_GENERATOR")
    @SequenceGenerator(sequenceName = "CAREER_SEQ", name = "CAREER_GENERATOR", allocationSize = 1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Position position;

    private String description;

    private String salaryExpect;

    private Integer amountReceived;

    private boolean statusPosition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
