package cloud.djet.catalog.catalog.controller.api

import cloud.djet.catalog.catalog.domain.Location
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Api(value = "PartyLocations", tags = ["PartyLocations"], description = "the PartyLocations API")
interface PartyLocationsApi {

	@ApiOperation(value = "CreateLocation", nickname = "partyLocationsCreateLocation", notes = "Create new Location. Validate Location not yet exist.", tags=["PartyLocations"])
	@ApiResponses(
		ApiResponse(code = 201, message = "Object created successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 401, message = "Object is already exist."),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PostMapping("/parties/{partyId}/locations")
	fun partyLocationsCreateLocation(
			@PathVariable("partyId") partyId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "GetLocation", nickname = "partyLocationsGetLocation", notes = "Get location or list of locations from service.", tags=["PartyLocations"])
	@ApiResponses(
		ApiResponse(code = 200, message = "Person is found and returned."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Object is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@GetMapping("/parties/{partyId}/locations/{locationId}")
	fun partyLocationsGetLocation(
			@PathVariable("partyId") partyId: String,
			@PathVariable("locationId") locationId: String): ResponseEntity<Location> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "GetLocationList", nickname = "partyLocationsGetLocationList", notes = "Get location or list of locations from service.", tags=["PartyLocations"])
	@ApiResponses(
		ApiResponse(code = 200, message = "Person is found and returned."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Object is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@GetMapping("/parties/{partyId}/locations")
	fun partyLocationsGetLocationList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Location>> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "ModifyLocation", nickname = "partyLocationsModifyLocation", notes = "Change Location properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["PartyLocations"])
	@ApiResponses(
		ApiResponse(code = 204, message = "Operation completed successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Object is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PatchMapping("/parties/{partyId}/locations/{locationId}")
	fun partyLocationsModifyLocation(
			@PathVariable("partyId") partyId: String,
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "UpdateLocation", nickname = "partyLocationsUpdateLocation", notes = "Change location specification. Location will be created if not exist.", tags=["PartyLocations"])
	@ApiResponses(
		ApiResponse(code = 204, message = "Operation completed successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PutMapping("/parties/{partyId}/locations/{locationId}")
	fun partyLocationsUpdateLocation(
			@PathVariable("partyId") partyId: String,
			@PathVariable("locationId") locationId: String,
			@RequestBody location: Location): ResponseEntity<Location> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

}
