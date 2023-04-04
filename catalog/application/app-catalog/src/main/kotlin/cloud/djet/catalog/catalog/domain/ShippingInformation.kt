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
* Customs inspection is an important procedure during transportation. Normally, after the parcel arrived in the destination country/area, it will go through the course of customs inspection. If the status of the parcel has not been updated for a long time, based on the tracking info, the addressee should either contact the seller for the necessary document/paper needed by the customs or contact the local customs to assist in customs clearance. For your information, if the shipments sent to most European countries are held by the customs, it is suggested that the addressee can get back to the seller to ask for some kind of invoice or a description of the parcel for the customs. If the parcel is not claimed for a long time, the parcel will be then destroyed. So please pay attention to the deadline. Below please kindly check the common customs information.
* @param header This header of element with order and period of element activity.
* @param address 
* @param name 
* @param phone 
* @param email 
* @param deliveryInstructions Instructions for delivery
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.2.0")

@JsonPropertyOrder("id", "header", "address", "name", "phone", "email", "deliveryInstructions")

@Entity
@Table(name = "shipping_information")
data class ShippingInformation(

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
	var email: ContactPoint?,

	@Column(name = "delivery_instructions", columnDefinition = "text")
	var deliveryInstructions: String?

) : BaseDomain()

