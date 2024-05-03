package com.infenia.ReactivePms.entity;

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

    private String name;

    @Column("duration_in_month")
    private int durationInMonth;
}
