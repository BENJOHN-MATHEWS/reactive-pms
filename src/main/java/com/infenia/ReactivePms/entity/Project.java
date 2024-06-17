package com.infenia.ReactivePms.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Project {

    @Id
    private Long id;

    @NotNull(message = " Name cannot be Null")
    @NotEmpty(message = " Name cannot be Empty")
    @Size(max = 10, message = " Name must not exceed 10 characters")
    private String name;

    @NotNull(message = "duration cannot be null")
    @Min(value = 1, message = " Minimum 1 month")
    @Column("duration_in_month")
    private int durationInMonth;
}
