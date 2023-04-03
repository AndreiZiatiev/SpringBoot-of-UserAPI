package cloud.djet.catalog.catalog.domain

import cloud.djet.catalog.domain.BaseDomain
import cloud.djet.catalog.domain.Element
import java.util.UUID
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Flag that indicates if terms and conditions are accepted
* @param header This header of element with id and period of element activity.
* @param isSet Boolean value indicating if terms and conditions are accepted
* @param termsAndConditionsText Text describing terms and conditions
* @param version Version of terms and conditions
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:1.2.0")

@JsonPropertyOrder("id", "header", "isSet", "termsAndConditionsText", "version")

@Entity
@Table(name = "terms_and_conditions")
data class TermsAndConditions(

	@AttributeOverrides(
		AttributeOverride(name = "order", column = Column(name = "header_order_")),
		AttributeOverride(name = "rank", column = Column(name = "header_rank_")),
		AttributeOverride(name = "period.start", column = Column(name = "header_period_start")),
		AttributeOverride(name = "period.end", column = Column(name = "header_period_end_")),
	)
	@Embedded
	var header: Element?,

	@Column(name = "is_set")
	var isSet: Boolean?,

	@Column(name = "terms_and_conditions_text", columnDefinition = "text")
	var termsAndConditionsText: String?,

	@Column(name = "version")
	var version: String?

) : BaseDomain()

