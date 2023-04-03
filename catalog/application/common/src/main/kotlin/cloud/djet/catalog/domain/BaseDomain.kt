package cloud.djet.catalog.domain

import cloud.djet.catalog.listener.BaseDomainListener
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import com.vladmihalcea.hibernate.type.json.JsonStringType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import javax.persistence.*

@TypeDefs(value = [
    TypeDef(name = "json", typeClass = JsonStringType::class),
    TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
])
@MappedSuperclass
@EntityListeners(BaseDomainListener::class)
open class BaseDomain {
    @Id
    open var id: String? = null
}
