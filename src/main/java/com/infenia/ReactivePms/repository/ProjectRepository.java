package com.infenia.ReactivePms.repository;

import com.infenia.ReactivePms.entity.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ProjectRepository extends R2dbcRepository<Project,Long> {
    @Query("Select * From project")
    Flux<Project> getAllProjectQM();

    @Query("Select * from project where id = :id")
    Mono<Project> getByIdQM(Long id);

    @Query("Insert into project (name, duration_in_month) values ( :name, :durationInMonth)")
    Mono<Void> addProjectQM(String name, int durationInMonth);

    @Query("Delete from project where id = :id")
    Mono<Void> deleteProjectQM(Long id);

    @Query("Update project set name = :name , duration_in_month = :durationInMonth where id = :id")
    Mono<Void> updateProjectQM(Long id, String name, int durationInMonth);

}
