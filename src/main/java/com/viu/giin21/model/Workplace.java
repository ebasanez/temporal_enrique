package com.viu.giin21.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "workplace")
@AllArgsConstructor
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer owner;
    private String name;
    private Integer processability;
    private Integer maximumQueueSize;

    public Workplace() {
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProcessability() {
        return processability;
    }

    public void setProcessability(Integer processability) {
        this.processability = processability;
    }

    public Integer getMaximumQueueSize() {
        return maximumQueueSize;
    }

    public void setMaximumQueueSize(Integer maximumQueueSize) {
        this.maximumQueueSize = maximumQueueSize;
    }
}
