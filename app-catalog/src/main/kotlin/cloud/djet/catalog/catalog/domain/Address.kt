package cloud.djet.catalog.catalog.domain

import cloud.djet.catalog.domain.BaseDomain
import cloud.djet.catalog.domain.Element
import java.util.UUID
import org.hibernate.annotations.Type
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* An address expressed using postal conventions (as opposed to GPS or other location definition formats). This data type may be used to convey addresses for use in delivering mail as well as for visiting locations which might not be valid for mail delivery. There are a variety of postal address formats defined around the world.  http://build.fhir.org//datatypes.html#Address 
* @param header This header of element with id and period of element activity.
* @param text Text representation of the address
* @param line Street name, number, direction & P.O. Box etc. This repeating element order: The order in which lines should appear in an address label
* @param city Name of city, town etc.
* @param district District name (aka county)
* @param state Address state. Sub-unit of country (abbreviations ok)
* @param postalCode Postal code for area
* @param country Country (e.g. can be ISO 3166 2 or 3 letter code)
* @param useFor What address use for.
* @param addressType Type of address.
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:2.2.0")

@JsonPropertyOrder("id", "header", "text", "line", "city", "district", "state", "postalCode", "country", "useFor", "addressType")

@Entity
@Table(name = "address")
data class Address(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end_")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "text")
	var text: String?,

	@Type(type = "json")
	@Column(name = "line", columnDefinition = "json")
	var line: List<String>?,

	@Column(name = "city")
	var city: String?,

	@Column(name = "district")
	var district: String?,

	@Column(name = "state")
	var state: String?,

	@Column(name = "postal_code")
	var postalCode: String?,

	@Column(name = "country")
	var country: String?,

	@Column(name = "use_for")
	var useFor: String?,

	@Column(name = "address_type")
	var addressType: String?

) : BaseDomain()

