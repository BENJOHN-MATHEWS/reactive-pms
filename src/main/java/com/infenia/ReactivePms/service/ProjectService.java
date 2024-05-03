package com.infenia.ReactivePms.service;

import com.infenia.ReactivePms.entity.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectService {
    Flux<Project> getAllProject();

    Flux<Project> getAllProjectQM();

    Mono<Project> getById(Long id);

    Mono<Project> addProject(Project project);

    Mono<Void> deleteProjectById(Long id);

    Mono<Project> update(Long id, Project updatedProject);

    Mono<Project> getByIdQM(Long id);

    Mono<Void> addProjectQM(Project newProject);

    Mono<Void> deleteProjectQM(Long id);

    Mono<Void> updateProjectQM(Long id, Project updatedProject);
}
