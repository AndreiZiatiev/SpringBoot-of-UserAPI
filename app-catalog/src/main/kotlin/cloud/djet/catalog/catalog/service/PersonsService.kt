package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Person
import cloud.djet.catalog.catalog.repository.PersonsRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PersonsService(
    repository: PersonsRepository
) : AbstractService<Person, PersonsRepository>(repository)
