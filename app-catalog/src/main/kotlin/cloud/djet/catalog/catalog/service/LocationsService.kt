package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Location
import cloud.djet.catalog.catalog.repository.LocationsRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class LocationsService(
    repository: LocationsRepository
) : AbstractService<Location, LocationsRepository>(repository)
