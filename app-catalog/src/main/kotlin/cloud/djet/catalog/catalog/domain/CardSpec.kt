package cloud.djet.catalog.catalog.domain

import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Specification for bank account transfer.
* @param cardNumber Card number of customer. 
* @param cardToken Routing number to institution.
* @param paymentURL URL of payment for card spec
* @param transactionId Id of transaction that generated token
* @param approved field to determine if transaction of card spec is approved
* @param paymentId Id of payment which created the instrument
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.6.0")

@JsonPropertyOrder("cardNumber", "cardToken", "paymentURL", "transactionId", "approved", "paymentId")

@Embeddable
data class CardSpec(

	@Column(name = "card_number")
	var cardNumber: String?,

	@Column(name = "card_token")
	var cardToken: String?,

	@Column(name = "payment_url")
	var paymentURL: String?,

	@Column(name = "transaction_id")
	var transactionId: String?,

	@Column(name = "approved")
	var approved: Boolean?,

	@Column(name = "payment_id")
	var paymentId: String?

) 

