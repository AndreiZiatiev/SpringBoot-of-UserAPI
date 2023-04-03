package cloud.djet.catalog.catalog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["cloud.djet.catalog.catalog", "cloud.djet.catalog.config"])
@EntityScan(value = ["cloud.djet.catalog.catalog.domain", "cloud.djet.catalog.domain"])
class CatalogApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<CatalogApplication>(*args)
}
