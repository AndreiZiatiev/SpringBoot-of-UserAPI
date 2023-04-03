package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Contact
import cloud.djet.catalog.catalog.repository.ContactsRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class ContactsService(
    repository: ContactsRepository
) : AbstractService<Contact, ContactsRepository>(repository)
