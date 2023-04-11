package cloud.djet.catalog.catalog.domain

import cloud.djet.catalog.catalog.domain.PaymentInstrumentSpec
import cloud.djet.catalog.domain.BaseDomain
import cloud.djet.catalog.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Payment instrument to use for payment from eccount.
* @param header This header of element with order and period of element activity.
* @param type Type of financial instrument used for account payments.
* @param name Name of payment instrument for user to identify it
* @param spec Specification of payment instrument for specified type.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.1.0")

@JsonPropertyOrder("id", "header", "type", "name", "spec")

@Entity
@Table(name = "payment_instrument")
data class PaymentInstrument(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end_")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "type")
	var type: String?,

	@Column(name = "name")
	var name: String?,

	@AttributeOverrides(
		AttributeOverride(name = "bank.routingNumber", column = Column(name = "spec_bank_routing_number")),
		AttributeOverride(name = "bank.accountNumber", column = Column(name = "spec_bank_account_number")),
		AttributeOverride(name = "card.cardNumber", column = Column(name = "spec_card_card_number")),
		AttributeOverride(name = "card.cardToken", column = Column(name = "spec_card_card_token")),
		AttributeOverride(name = "card.paymentURL", column = Column(name = "spec_card_payment_url")),
		AttributeOverride(name = "card.transactionId", column = Column(name = "spec_card_transaction_id")),
		AttributeOverride(name = "card.approved", column = Column(name = "spec_card_approved")),
		AttributeOverride(name = "card.paymentId", column = Column(name = "spec_card_payment_id")),
	)
	@Embedded
	var spec: PaymentInstrumentSpec?

) : BaseDomain()

