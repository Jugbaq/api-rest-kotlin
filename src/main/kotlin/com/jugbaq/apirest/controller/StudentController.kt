package com.jugbaq.apirest.controller

import com.jugbaq.apirest.model.Student
import com.jugbaq.apirest.service.StudentService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PutMapping


@RestController
@RequestMapping("api/v1")
class StudentController (private val studentService: StudentService) {

    @GetMapping("/students")
    fun getStudents(): List<Student> {
        return studentService.getAllStudent()
    }

    @GetMapping("/students/{id}")
    fun getStudentById(@PathVariable id: Long): Student? {
        return studentService.getStudentById(id)
    }

    @PostMapping("/students")
    fun createStudent(@RequestBody student:Student): Student {
        return studentService.createStudent(student)
    }

    @PutMapping("/students/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody student: Student): Student? {
        return studentService.updateStudent(id, student)
    }

    @DeleteMapping("/students/{id}")
    fun deleteUser(@PathVariable id: Long) {
        studentService.deleteStudent(id)
    }
}