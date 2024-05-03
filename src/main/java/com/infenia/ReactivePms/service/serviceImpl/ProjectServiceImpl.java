package com.infenia.ReactivePms.service.serviceImpl;

import com.infenia.ReactivePms.entity.Project;
import com.infenia.ReactivePms.repository.ProjectRepository;
import com.infenia.ReactivePms.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Flux<Project> getAllProject() {

        return projectRepository.findAll();
    }

    @Override
    public Flux<Project> getAllProjectQM() {

        return projectRepository.getAllProjectQM();
    }

    @Override
    public Mono<Project> getById(Long id) {

        return projectRepository.findById(id);
    }

    @Override
    public Mono<Project> addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Mono<Void> deleteProjectById(Long id) {
        return projectRepository.deleteById(id);
    }

    @Override
    public Mono<Project> update(Long id, Project updatedProject) {

        Mono<Project> existingProject = projectRepository.findById(id);

        Mono<Project> newProject = existingProject.flatMap(eProject -> {
            eProject.setDurationInMonth(updatedProject.getDurationInMonth());
            eProject.setName(updatedProject.getName());
            return projectRepository.save(eProject);

        });

        return newProject;
    }

    @Override
    public Mono<Project> getByIdQM(Long id) {
        return projectRepository.getByIdQM(id);
    }

    @Override
    public Mono<Void> addProjectQM(Project newProject) {
        return projectRepository.addProjectQM(newProject.getName(), newProject.getDurationInMonth());

    }

    @Override
    public Mono<Void> deleteProjectQM(Long id) {

        return projectRepository.deleteProjectQM(id);
    }

    @Override
    public Mono<Void> updateProjectQM(Long id, Project updatedProject) {

        projectRepository.updateProjectQM(id, updatedProject.getName(), updatedProject.getDurationInMonth());
        return null;
    }

}
