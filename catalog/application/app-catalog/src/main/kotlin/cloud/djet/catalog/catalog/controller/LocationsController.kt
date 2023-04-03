package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Location
import cloud.djet.catalog.catalog.service.LocationsService
import cloud.djet.catalog.catalog.controller.api.LocationsApi
import cloud.djet.catalog.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class LocationsController(service: LocationsService)
    : AbstractController<Location, LocationsService>(service), LocationsApi {


    override fun locationsCreateLocation(
			@RequestBody location: Location): ResponseEntity<Location> {
        return super.create(location)
    }

    override fun locationsGetLocation(
			@PathVariable("locationId") locationId: String): ResponseEntity<Location> {
        return super.getById(locationId)
    }

    override fun locationsGetLocationList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Location>> {
        return getAll(search, page)
    }

    override fun locationsModifyLocation(
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
        return super.modify(locationId, location)
    }

    override fun locationsUpdateLocation(
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
        return super.update(locationId, location)
    }

}
