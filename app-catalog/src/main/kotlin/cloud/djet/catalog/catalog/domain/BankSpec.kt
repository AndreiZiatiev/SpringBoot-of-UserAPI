package cloud.djet.catalog.catalog.domain

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Specification for bank account transfer.
* @param routingNumber Routing number to institution.
* @param accountNumber Account number of bank customer. 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.0")

@JsonPropertyOrder("routingNumber", "accountNumber")

@Embeddable
data class BankSpec(

	@Column(name = "routing_number")
	var routingNumber: String,

	@Column(name = "account_number")
	var accountNumber: String

) 

