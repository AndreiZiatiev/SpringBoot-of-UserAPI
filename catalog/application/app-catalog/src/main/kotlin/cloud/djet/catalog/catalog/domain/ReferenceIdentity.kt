package cloud.djet.catalog.catalog.domain

import cloud.djet.catalog.domain.BaseDomain
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* Complex structure to describe referenced resource
* @param resourceId Optional URI of the target Resource
* @param name Optional URI of the target Resource
* @param description Description of the Reference, can be target Resource description or custom one
* @param type Optional URI of the target Resource
* @param uri Optional URI of the target Resource
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:")

@JsonPropertyOrder("id", "resourceId", "name", "description", "type", "uri")

@Entity
@Table(name = "reference_identity")
data class ReferenceIdentity(

	@Column(name = "resource_id")
	var resourceId: String?,

	@Column(name = "name")
	var name: String?,

	@Column(name = "description")
	var description: String?,

	@Column(name = "type")
	var type: String?,

	@Column(name = "uri")
	var uri: String?

) : BaseDomain()

