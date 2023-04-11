package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Person
import cloud.djet.catalog.catalog.repository.PartyPersonsRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyPersonsService(
    repository: PartyPersonsRepository
) : AbstractService<Person, PartyPersonsRepository>(repository)
