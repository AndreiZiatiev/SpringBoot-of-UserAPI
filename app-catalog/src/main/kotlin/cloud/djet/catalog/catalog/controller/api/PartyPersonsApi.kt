package cloud.djet.catalog.catalog.controller.api

import cloud.djet.catalog.catalog.domain.Person
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

@Api(value = "PartyPersons", tags = ["PartyPersons"], description = "the PartyPersons API")
interface PartyPersonsApi {

	@ApiOperation(value = "CreatePerson", nickname = "partyPersonsCreatePerson", notes = "Create new Person. Validate Person not yet exist.", tags=["PartyPersons"])
	@ApiResponses(
		ApiResponse(code = 201, message = "Object created successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 401, message = "Object is already exist."),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PostMapping("/parties/{partyId}/persons")
	fun partyPersonsCreatePerson(
			@PathVariable("partyId") partyId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@RequestBody person: Person): ResponseEntity<Person> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "GetPerson", nickname = "partyPersonsGetPerson", notes = "Get person or list of persons from service.", tags=["PartyPersons"])
	@ApiResponses(
		ApiResponse(code = 200, message = "Person is found and returned."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Object is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@GetMapping("/parties/{partyId}/persons/{personId}")
	fun partyPersonsGetPerson(
			@PathVariable("partyId") partyId: String,
			@PathVariable("personId") personId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?): ResponseEntity<Person> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "GetPersonList", nickname = "partyPersonsGetPersonList", notes = "Get person or list of persons from service.", tags=["PartyPersons"])
	@ApiResponses(
		ApiResponse(code = 200, message = "Person is found and returned."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Object is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@GetMapping("/parties/{partyId}/persons")
	fun partyPersonsGetPersonList(
			@PathVariable("partyId") partyId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Person>> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "ModifyPerson", nickname = "partyPersonsModifyPerson", notes = "Change Person properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["PartyPersons"])
	@ApiResponses(
		ApiResponse(code = 204, message = "Operation completed successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Object is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PatchMapping("/parties/{partyId}/persons/{personId}")
	fun partyPersonsModifyPerson(
			@PathVariable("partyId") partyId: String,
			@PathVariable("personId") personId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@RequestBody person: Person): ResponseEntity<Person> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "UpdatePerson", nickname = "partyPersonsUpdatePerson", notes = "Change person specification. Person will be created if not exist.", tags=["PartyPersons"])
	@ApiResponses(
		ApiResponse(code = 204, message = "Operation completed successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PutMapping("/parties/{partyId}/persons/{personId}")
	fun partyPersonsUpdatePerson(
			@PathVariable("partyId") partyId: String,
			@PathVariable("personId") personId: String,
			@RequestHeader(value = "X-entity-partyId", required = true) xEntityPartyId: String,
			@RequestHeader(value = "X-access-reference", required = false) xAccessReference: String?,
			@RequestBody person: Person): ResponseEntity<Person> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

}
