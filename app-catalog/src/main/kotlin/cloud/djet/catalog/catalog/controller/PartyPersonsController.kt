package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Person
import cloud.djet.catalog.catalog.service.PartyPersonsService
import cloud.djet.catalog.catalog.controller.api.PartyPersonsApi
import cloud.djet.catalog.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PartyPersonsController(service: PartyPersonsService)
    : AbstractController<Person, PartyPersonsService>(service), PartyPersonsApi {


    override fun partyPersonsCreatePerson(
			@PathVariable("partyId") partyId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@RequestBody person: Person): ResponseEntity<Person> {
        return super.create(partyId, person)
    }

    override fun partyPersonsGetPerson(
			@PathVariable("partyId") partyId: String,
			@PathVariable("personId") personId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?): ResponseEntity<Person> {
        return super.getById(partyId, personId)
    }

    override fun partyPersonsGetPersonList(
			@PathVariable("partyId") partyId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Person>> {
        return getAll(partyId, search, page)
    }

    override fun partyPersonsModifyPerson(
			@PathVariable("partyId") partyId: String,
			@PathVariable("personId") personId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@RequestBody person: Person): ResponseEntity<Person> {
        return super.modify(partyId, personId, person)
    }

    override fun partyPersonsUpdatePerson(
			@PathVariable("partyId") partyId: String,
			@PathVariable("personId") personId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@RequestBody person: Person): ResponseEntity<Person> {
        return super.update(partyId, personId, person)
    }

}
