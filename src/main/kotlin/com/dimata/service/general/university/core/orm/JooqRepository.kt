package com.dimata.service.general.university.core.orm

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.jooq.DSLContext

@ApplicationScoped
class JooqRepository {

    @Inject
    protected lateinit var jooq: DSLContext

}