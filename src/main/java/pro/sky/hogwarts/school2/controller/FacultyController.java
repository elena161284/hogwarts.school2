package pro.sky.hogwarts.school2.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.hogwarts.school2.model.Faculty;
import pro.sky.hogwarts.school2.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping("{id}")
    public Faculty getInfo(@PathVariable long id) {
        return facultyService.findFaculty(id);
    }
    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @PutMapping()
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }
    @DeleteMapping("{id}")
    public Faculty deletedFaculty(@PathVariable Long id) {
        return facultyService.deletedFaculty(id);
    }
    @GetMapping("/byNameOrColorIgnoreCase")
    public Collection<Faculty> byNameOrColorIgnoreCase(
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String name)
    {
        return facultyService.filterByNameOrColor(color, name);
    }
}
