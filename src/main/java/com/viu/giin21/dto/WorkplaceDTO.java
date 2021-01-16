package com.viu.giin21.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class WorkplaceDTO {

    private Integer id;

    @NotNull
    private Integer owner;

    @NotNull
    @Size(min = 1, max = 30)
    private String name;

    @NotNull
    @Min(1)
    @Max(1000000)
    private Integer processability;

    @NotNull
    @Min(1)
    @Max(1000000)
    private Integer maximumQueueSize;
}
