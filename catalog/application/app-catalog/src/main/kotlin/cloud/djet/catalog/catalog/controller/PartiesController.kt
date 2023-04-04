package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Party
import cloud.djet.catalog.catalog.service.PartiesService
import cloud.djet.catalog.catalog.controller.api.PartiesApi
import cloud.djet.catalog.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PartiesController(service: PartiesService)
    : AbstractController<Party, PartiesService>(service), PartiesApi {


    override fun partiesCreateParty(
			@RequestBody party: Party): ResponseEntity<Party> {
        return super.create(party)
    }

    override fun partiesGetParty(
			@PathVariable("partyId") partyId: String): ResponseEntity<Party> {
        return super.getById(partyId)
    }

    override fun partiesGetPartyList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Party>> {
        return getAll(search, page)
    }

    override fun partiesUpdateParty(
			@PathVariable("partyId") partyId: String,
			@RequestBody party: Party): ResponseEntity<Party> {
        return super.update(partyId, party)
    }

}
