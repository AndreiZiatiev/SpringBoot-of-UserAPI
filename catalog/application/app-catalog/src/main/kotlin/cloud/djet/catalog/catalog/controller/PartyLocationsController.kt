package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Location
import cloud.djet.catalog.catalog.service.PartyLocationsService
import cloud.djet.catalog.catalog.controller.api.PartyLocationsApi
import cloud.djet.catalog.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PartyLocationsController(service: PartyLocationsService)
    : AbstractController<Location, PartyLocationsService>(service), PartyLocationsApi {


    override fun partyLocationsCreateLocation(
			@PathVariable("partyId") partyId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
        return super.create(partyId, location)
    }

    override fun partyLocationsGetLocation(
			@PathVariable("partyId") partyId: String,
			@PathVariable("locationId") locationId: String): ResponseEntity<Location> {
        return super.getById(partyId, locationId)
    }

    override fun partyLocationsGetLocationList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Location>> {
        return getAll(partyId, search, page)
    }

    override fun partyLocationsModifyLocation(
			@PathVariable("partyId") partyId: String,
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
        return super.modify(partyId, locationId, location)
    }

    override fun partyLocationsUpdateLocation(
			@PathVariable("partyId") partyId: String,
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
        return super.update(partyId, locationId, location)
    }

}
