package cloud.djet.catalog.catalog.domain

import cloud.djet.catalog.catalog.domain.BankSpec
import cloud.djet.catalog.catalog.domain.CardSpec
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Payment specification for all supported payment types.
* @param bank Specification for bank account as payment instrument.
* @param card Specification for credit card as payment instrument.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.1.0")

@JsonPropertyOrder("bank", "card")

@Embeddable
data class PaymentInstrumentSpec(

	@AttributeOverrides(
		AttributeOverride(name = "routingNumber", column = Column(name = "bank_routing_number")),
		AttributeOverride(name = "accountNumber", column = Column(name = "bank_account_number")),
	)
	@Embedded
	var bank: BankSpec?,

	@AttributeOverrides(
		AttributeOverride(name = "cardNumber", column = Column(name = "card_card_number")),
		AttributeOverride(name = "cardToken", column = Column(name = "card_card_token")),
		AttributeOverride(name = "paymentURL", column = Column(name = "card_payment_url")),
		AttributeOverride(name = "transactionId", column = Column(name = "card_transaction_id")),
		AttributeOverride(name = "approved", column = Column(name = "card_approved")),
		AttributeOverride(name = "paymentId", column = Column(name = "card_payment_id")),
	)
	@Embedded
	var card: CardSpec?

) 

