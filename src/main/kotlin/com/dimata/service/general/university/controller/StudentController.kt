package com.dimata.service.general.university.controller

import com.dimata.service.general.university.model.request.StudentRequestBody
import com.dimata.service.general.university.repository.StudentRepository
import com.dimata.service.general.university.service.StudentService
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.core.Response

@Path("/api/students")
class StudentController(
    private val studentService: StudentService,
    private val studentRepository: StudentRepository
){

    @GET
    fun getData() : Response{
        return Response.ok(studentRepository.getAll()).build()
    }

    @POST
    fun createStudent(student: StudentRequestBody): Response {
        return Response.ok(studentService.create(student)).build()
    }

    @PUT
    @Path("/{studentId}")
    fun updateStudent(@PathParam("studentId") studentId: String, student: StudentRequestBody): Response {
        return Response.ok(studentService.update(studentId, student)).build()
    }

    @DELETE
    @Path("/{name}")
    fun deleteStudent(@PathParam("name") name: String): Response {
        return  Response.ok(studentService.delete(name)).build()
    }
}