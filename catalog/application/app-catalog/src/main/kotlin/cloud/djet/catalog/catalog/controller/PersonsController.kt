package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Person
import cloud.djet.catalog.catalog.service.PersonsService
import cloud.djet.catalog.catalog.controller.api.PersonsApi
import cloud.djet.catalog.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class PersonsController(service: PersonsService)
    : AbstractController<Person, PersonsService>(service), PersonsApi {


    override fun personsGetPerson(
			@PathVariable("personId") personId: String): ResponseEntity<Person> {
        return super.getById(personId)
    }

    override fun personsGetPersonList(
			@RequestParam(value = "search", required = false) search: String?,
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Person>> {
        return getAll(search, page)
    }

}
