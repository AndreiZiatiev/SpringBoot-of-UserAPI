package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Location
import cloud.djet.catalog.catalog.repository.PartyLocationsRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyLocationsService(
    repository: PartyLocationsRepository
) : AbstractService<Location, PartyLocationsRepository>(repository)
