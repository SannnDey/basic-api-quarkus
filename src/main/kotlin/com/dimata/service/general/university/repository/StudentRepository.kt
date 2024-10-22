package com.dimata.service.general.university.repository

import com.dimata.service.general.university.core.orm.JooqRepository
import com.dimata.service.general.university.jooq.gen.Tables.STUDENT
import com.dimata.service.general.university.model.request.StudentRequestBody
import com.dimata.service.general.university.model.response.StudentResponse
import com.github.f4b6a3.uuid.UuidCreator
import jakarta.enterprise.context.ApplicationScoped


@ApplicationScoped
class StudentRepository : JooqRepository() {
    fun getAll(): List<StudentResponse> = jooq.selectFrom(STUDENT).fetchInto(StudentResponse::class.java)

    fun create(body: StudentRequestBody) = jooq.newRecord(
        STUDENT, body
    ).also {
        it.studentId = UuidCreator.getTimeOrderedEpoch().toString()
        it.store();
    };

    fun update(studentId: String, body: StudentRequestBody) = jooq.update(STUDENT)
        .set(STUDENT.NAME, body.name)
        .set(STUDENT.IDENTITY_ID, body.identityId)
        .where(STUDENT.STUDENT_ID.eq(studentId))
        .execute()


    fun delete(name: String) = jooq.delete(STUDENT)
        .where(STUDENT.NAME.eq(name))
        .execute()
}