package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Contact
import cloud.djet.catalog.catalog.repository.PartyContactsRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyContactsService(
    repository: PartyContactsRepository
) : AbstractService<Contact, PartyContactsRepository>(repository)
