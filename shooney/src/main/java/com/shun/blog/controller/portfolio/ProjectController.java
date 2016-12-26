package com.shun.blog.controller.portfolio;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.shun.blog.model.portfolio.project.Greeting;
import com.shun.blog.model.portfolio.project.Project;
import com.shun.blog.service.portfolio.project.ProjectService;

@RestController
@RequestMapping("/")
public class ProjectController {
	
	@Autowired
	private ProjectService pService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
	
	@RequestMapping(value = "/portfolio/project/list", method = RequestMethod.GET)
	public String webp(ModelMap model) {
		
		return "portfolio/project/list";
	}
	
	@RequestMapping(value = "/project/", method = RequestMethod.GET)
	public ResponseEntity<List<Project>> listAllProjects() {
		List<Project> Projects = pService.findAllProjects();
		if(Projects.isEmpty()){
			return new ResponseEntity<List<Project>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Project>>(Projects, HttpStatus.OK);
	}


	//-------------------Retrieve Single Project--------------------------------------------------------
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> getProject(@PathVariable("id") long id) {
		System.out.println("Fetching Project with id " + id);
		Project Project = pService.findById(id);
		if (Project == null) {
			System.out.println("Project with id " + id + " not found");
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Project>(Project, HttpStatus.OK);
	}

	
	
	//-------------------Create a Project--------------------------------------------------------
	
	@RequestMapping(value = "/project/", method = RequestMethod.POST)
	public ResponseEntity<Void> createProject(@RequestBody Project project, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Project " + project.getTitle());

		if (pService.isProjectExist(project)) {
			System.out.println("A Project with title " + project.getTitle() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		pService.saveProject(project);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/project/{id}").buildAndExpand(project.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	//------------------- Update a Project --------------------------------------------------------
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Project> updateProject(@PathVariable("id") long id, @RequestBody Project project) {
		System.out.println("Updating Project " + id);
		
		Project currentProject = pService.findById(id);
		
		if (currentProject==null) {
			System.out.println("Project with id " + id + " not found");
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}

		currentProject.setTitle(project.getTitle());
		currentProject.setContent(project.getContent());
		currentProject.setLatestDate(project.getLatestDate());
		currentProject.setImages(project.getImages());
		
		pService.updateProject(currentProject);
		return new ResponseEntity<Project>(currentProject, HttpStatus.OK);
	}

	//------------------- Delete a Project --------------------------------------------------------
	
	@RequestMapping(value = "/project/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Project> deleteProject(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Project with id " + id);

		Project Project = pService.findById(id);
		if (Project == null) {
			System.out.println("Unable to delete. Project with id " + id + " not found");
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}

		pService.deleteProjectById(id);
		return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
	}

	
	//------------------- Delete All Project --------------------------------------------------------
	
	@RequestMapping(value = "/project/", method = RequestMethod.DELETE)
	public ResponseEntity<Project> deleteAllProjects() {
		System.out.println("Deleting All Projects");

		pService.deleteAllProjects();
		return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
	}

}
