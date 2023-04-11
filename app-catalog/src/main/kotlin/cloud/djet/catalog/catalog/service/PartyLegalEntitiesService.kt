package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.LegalEntity
import cloud.djet.catalog.catalog.repository.PartyLegalEntitiesRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyLegalEntitiesService(
    repository: PartyLegalEntitiesRepository
) : AbstractService<LegalEntity, PartyLegalEntitiesRepository>(repository)
