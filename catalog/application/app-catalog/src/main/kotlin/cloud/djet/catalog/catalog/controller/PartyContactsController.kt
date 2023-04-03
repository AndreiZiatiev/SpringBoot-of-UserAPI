package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Contact
import cloud.djet.catalog.catalog.service.PartyContactsService
import cloud.djet.catalog.catalog.controller.api.PartyContactsApi
import cloud.djet.catalog.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PartyContactsController(service: PartyContactsService)
    : AbstractController<Contact, PartyContactsService>(service), PartyContactsApi {


    override fun partyContactsCreateContact(
			@PathVariable("partyId") partyId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return super.create(partyId, contact)
    }

    override fun partyContactsGetContact(
			@PathVariable("partyId") partyId: String,
			@PathVariable("contactId") contactId: String): ResponseEntity<Contact> {
        return super.getById(partyId, contactId)
    }

    override fun partyContactsGetContactList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Contact>> {
        return getAll(partyId, search, page)
    }

    override fun partyContactsModifyContact(
			@PathVariable("partyId") partyId: String,
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return super.modify(partyId, contactId, contact)
    }

    override fun partyContactsUpdateContact(
			@PathVariable("partyId") partyId: String,
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
        return super.update(partyId, contactId, contact)
    }

}
