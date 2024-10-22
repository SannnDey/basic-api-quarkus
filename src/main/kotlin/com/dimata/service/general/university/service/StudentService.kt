package com.dimata.service.general.university.service

import com.dimata.service.general.university.model.request.StudentRequestBody
import com.dimata.service.general.university.model.response.StudentResponse
import com.dimata.service.general.university.repository.StudentRepository
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class StudentService(
    private val studentRepository: StudentRepository
) {
    fun create(body : StudentRequestBody) : StudentResponse {
        try {
            val data = studentRepository.create(body)
            return StudentResponse(
                studentId = data.studentId,
                name = data.name,
                identityId = data.identityId,
            );
        }catch (e : Exception){
            throw RuntimeException(e);
        }
    }

    fun update(studentId : String, body : StudentRequestBody) : StudentResponse {
        try {
            studentRepository.update(studentId, body)
            return StudentResponse(
                studentId = studentId,
                name = body.name,
                identityId = body.identityId
            );
        }catch (e : Exception){
            throw RuntimeException(e);
        }
    }

    fun delete(name: String){
        try {
             studentRepository.delete(name)
        }catch (e : Exception){
            throw  RuntimeException(e);
        }
    }
}