package cloud.djet.catalog.catalog.controller.api

import cloud.djet.catalog.catalog.domain.Contact
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

@Api(value = "PartyContacts", tags = ["PartyContacts"], description = "the PartyContacts API")
interface PartyContactsApi {

	@ApiOperation(value = "CreateContact", nickname = "partyContactsCreateContact", notes = "Create new Contact. Validate Contact not yet exist.", tags=["PartyContacts"])
	@ApiResponses(
		ApiResponse(code = 201, message = "Object created successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 401, message = "Contact is already exist."),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PostMapping("/parties/{partyId}/contacts")
	fun partyContactsCreateContact(
			@PathVariable("partyId") partyId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "GetContact", nickname = "partyContactsGetContact", notes = "Get contact or list of contacts from service.", tags=["PartyContacts"])
	@ApiResponses(
		ApiResponse(code = 200, message = "Contact is found and returned."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Contact is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@GetMapping("/parties/{partyId}/contacts/{contactId}")
	fun partyContactsGetContact(
			@PathVariable("partyId") partyId: String,
			@PathVariable("contactId") contactId: String): ResponseEntity<Contact> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "GetContactList", nickname = "partyContactsGetContactList", notes = "Get contact or list of contacts from service.", tags=["PartyContacts"])
	@ApiResponses(
		ApiResponse(code = 200, message = "Contact is found and returned."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Contact is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@GetMapping("/parties/{partyId}/contacts")
	fun partyContactsGetContactList(
			@PathVariable("partyId") partyId: String,
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Contact>> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "ModifyContact", nickname = "partyContactsModifyContact", notes = "Change Contact properties to values specified in request. Property not specified will remain same. No element of any collection will be deleted. ", tags=["PartyContacts"])
	@ApiResponses(
		ApiResponse(code = 204, message = "Operation completed successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 404, message = "Contact is not found"),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PatchMapping("/parties/{partyId}/contacts/{contactId}")
	fun partyContactsModifyContact(
			@PathVariable("partyId") partyId: String,
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "UpdateContact", nickname = "partyContactsUpdateContact", notes = "Change contact specification. Contact will be created if not exist.", tags=["PartyContacts"])
	@ApiResponses(
		ApiResponse(code = 204, message = "Operation completed successfully."),
		ApiResponse(code = 400, message = "Execution of user request failed."),
		ApiResponse(code = 409, message = "User don't have permissions to execute operation on the object.")
	)
	@PutMapping("/parties/{partyId}/contacts/{contactId}")
	fun partyContactsUpdateContact(
			@PathVariable("partyId") partyId: String,
			@PathVariable("contactId") contactId: String,
			@RequestBody contact: Contact): ResponseEntity<Contact> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

}
