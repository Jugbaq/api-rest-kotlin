package com.jugbaq.apirest.repository

import com.jugbaq.apirest.model.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Long> {
}