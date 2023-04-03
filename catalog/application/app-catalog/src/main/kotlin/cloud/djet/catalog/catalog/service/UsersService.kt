package cloud.djet.catalog.catalog.service

import cloud.djet.catalog.catalog.domain.User
import cloud.djet.catalog.catalog.repository.UsersRepository
import cloud.djet.catalog.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class UsersService(
    repository: UsersRepository
) : AbstractService<User, UsersRepository>(repository)
