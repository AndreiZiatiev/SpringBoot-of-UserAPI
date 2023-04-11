package cloud.djet.catalog.catalog.domain

import cloud.djet.catalog.catalog.domain.Address
import cloud.djet.catalog.catalog.domain.ContactPoint
import cloud.djet.catalog.catalog.domain.HumanName
import cloud.djet.catalog.domain.BaseDomain
import cloud.djet.catalog.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Any record or information compiled or maintained with respect to a consumer that identifies the consumer and provides a means by which the consumer’s financial obligation incurred by accepting a free offer may be paid or otherwise satisfied, including but not limited to information pertaining to a consumer’s credit card, payment card, charge card, debit card, checking, savings, or other banking account, and electronic funds transfer information.
* @param header This header of element with order and period of element activity.
* @param address Billing address
* @param name Name for billing information
* @param phone Phone for billing information
* @param email EMail for billing information
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.0.1")

@JsonPropertyOrder("id", "header", "address", "name", "phone", "email")

@Entity
@Table(name = "billing_information")
data class BillingInformation(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end_")),
	)
	@Embedded
	var header: Element?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "address", referencedColumnName = "id")
	var address: Address?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "name", referencedColumnName = "id")
	var name: HumanName?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "phone", referencedColumnName = "id")
	var phone: ContactPoint?,

	@OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
	@JoinColumn(name = "email", referencedColumnName = "id")
	var email: ContactPoint?

) : BaseDomain()

