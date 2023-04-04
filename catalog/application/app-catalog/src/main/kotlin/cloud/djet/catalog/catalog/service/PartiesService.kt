package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Party
import cloud.djet.catalog.catalog.repository.PartiesRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartiesService(
    repository: PartiesRepository
) : AbstractService<Party, PartiesRepository>(repository)
