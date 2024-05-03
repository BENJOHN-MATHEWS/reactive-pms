package com.infenia.ReactivePms.controller;

import com.infenia.ReactivePms.entity.Project;
import com.infenia.ReactivePms.service.ProjectService;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;


    //get all project
    @GetMapping("/getAllProject")
    public ResponseEntity<Flux<Project>> getAllProject() {
        Flux<Project> ProjectFlux = projectService.getAllProject();
        return new ResponseEntity<Flux<Project>>(ProjectFlux,HttpStatus.OK);
    }

    //get by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Mono<Project>> getById(@PathVariable Long id) {
        return new ResponseEntity<Mono<Project>>(projectService.getById(id), HttpStatus.FOUND);
    }

    //Add new project
    @PostMapping("/addProject")
    public ResponseEntity<Mono<Project>> addProject(@RequestBody Project project) {
        return new ResponseEntity<Mono<Project>>(projectService.addProject(project),HttpStatus.CREATED);
    }

    //Update by id
    @PutMapping("/update/{id}")
    public ResponseEntity<Mono<Project>> update(@PathVariable Long id, @RequestBody Project updatedProject) {
        return new ResponseEntity<Mono<Project>>(projectService.update(id, updatedProject),HttpStatus.ACCEPTED);

    }

    //Delete by id
    @DeleteMapping("/deleteProjectById/{id}")
    public ResponseEntity<Mono<Void>> deleteProjectById(@PathVariable Long id) {
        return new ResponseEntity<Mono<Void>>(projectService.deleteProjectById(id),HttpStatus.NO_CONTENT);
    }

    //below apis are with Query Method (QM)

    //get all project Query Method
    @GetMapping("/qm/getAllProject")
    public ResponseEntity<Flux<Project>> getAllProjectQM() {
        return new ResponseEntity<Flux<Project>>(projectService.getAllProjectQM(), HttpStatus.OK);
    }

    //get by id with Query Method
    @GetMapping("/qm/getById/{id}")
    public ResponseEntity<Mono<Project>> getByIdQM(@PathVariable Long id) {
        return new ResponseEntity<Mono<Project>>(projectService.getByIdQM(id),HttpStatus.FOUND);
    }

    //Add new project with Query Method
    @PostMapping("/qm/addProject")
    public ResponseEntity<Mono<Void>> addProjectQM(@RequestBody Project newProject) {
        return new ResponseEntity<Mono<Void>>(projectService.addProjectQM(newProject),HttpStatus.CREATED);
    }

    //Update by id with Query Method
    //Not fully functioning working on it
    @PutMapping("/qm/update/{id}")
    public ResponseEntity<Mono<Void>> updateProjectQM(@PathVariable Long id, @RequestBody Project updatedProject) {
        return new ResponseEntity<Mono<Void>>(projectService.updateProjectQM(id,updatedProject),HttpStatus.ACCEPTED);
    }

    //Delete by id with Query Method
    @DeleteMapping("/qm/delete/{id}")
    public ResponseEntity<Mono<Void>> deleteProjectQM(@PathVariable Long id) {
        return new ResponseEntity<Mono<Void>>(projectService.deleteProjectQM(id),HttpStatus.NO_CONTENT);
    }

}
