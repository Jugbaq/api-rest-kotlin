package com.jugbaq.apirest.service

import com.jugbaq.apirest.model.Student
import com.jugbaq.apirest.repository.StudentRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class StudentService(private val studentRepository: StudentRepository) {
    fun getAllStudent(): List<Student> = studentRepository.findAll().toList()

    fun createStudent(student: Student): Student {
        return studentRepository.save(student)
    }

   fun getStudentById(id: Long): Student {
        return studentRepository.findById(id).orElseGet{ throw ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id $id was not found.") }
   }

    fun updateStudent(id: Long, student: Student): Student {
        val studentLoaded = studentRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id $id was not found.") }

        val studentUpdated = studentLoaded.copy(
            name = student.name,
            email = student.email,
            address = student.address
        )

        return studentRepository.save(studentUpdated)
    }

    fun deleteStudent(id: Long) {
        val student = studentRepository.findById(id)
        if (student.isPresent) {
            studentRepository.delete(student.get())
        }
    }
}