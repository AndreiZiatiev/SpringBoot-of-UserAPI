package cloud.djet.catalog.listener

import cloud.djet.catalog.domain.BaseDomain
import java.util.*
import javax.persistence.*

class BaseDomainListener {

    @PrePersist
    fun <T : BaseDomain> touchForCreate(domain: T) {
        domain.id = UUID.randomUUID().toString()
    }
}
