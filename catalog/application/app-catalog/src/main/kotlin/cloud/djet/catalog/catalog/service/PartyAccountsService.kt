package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.Account
import cloud.djet.catalog.catalog.repository.PartyAccountsRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class PartyAccountsService(
    repository: PartyAccountsRepository
) : AbstractService<Account, PartyAccountsRepository>(repository)
