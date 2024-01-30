package com.teamd.teamdspringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamd.teamdspringapi.entity.Course;
import com.teamd.teamdspringapi.service.CourseService;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("http://localhost:5173")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseID}")
    public Course getCourseById(@PathVariable Long courseID) {
        return courseService.getCourseId(courseID);
    }

    @GetMapping("/byInstructor/{instructor_ID}")
    public List<Course> getCourseByInstructorId(@PathVariable Long instructor_ID) {
        return courseService.getCourseByInstructorId(instructor_ID);
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseService.savCourse(course);
    }

    @DeleteMapping("/{courseID}")
    public void deleteCourse(@PathVariable Long courseID) {
        courseService.deleteCourse(courseID);
    }
}
