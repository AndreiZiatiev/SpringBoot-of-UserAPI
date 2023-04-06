package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Contact
import cloud.djet.catalog.catalog.domain.Address
import cloud.djet.catalog.domain.Element
import cloud.djet.catalog.domain.Period
import cloud.djet.catalog.domain.Identity
import cloud.djet.catalog.catalog.CatalogApplication
import cloud.djet.catalog.catalog.repository.PartyContactsRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MvcResult
import org.springframework.util.LinkedMultiValueMap
import java.util.*
import kotlin.test.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [CatalogApplication::class])
@AutoConfigureMockMvc
class PartyContactsApiIT : AbstractIntegrationTest<Contact>() {

	private val url = "/parties/parent-id/contacts"

	@Autowired
	lateinit var repository: PartyContactsRepository

	@Test
	fun `partyContactsCreateContact with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyContactsCreateContact with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyContactsGetContact with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyContactsGetContact with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyContactsGetContactList api`() {
		repository.deleteAll()
		val res1 = createWithRequiredFields()
		val res2 = createWithAllFields()

		val savedRes1 = repository.save(res1)
		val savedRes2 = repository.save(res2)

		val params = LinkedMultiValueMap<String, String>()
		params["sort"] = "entity.history.createdAt"
		val result = super.findAll(url, params)

		resourceAsserts(savedRes1, result, 0)
		resourceAsserts(savedRes2, result, 1)
	}

	@Test
	fun `partyContactsModifyContact with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyContactsUpdateContact with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyContactsUpdateContact with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: Contact, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.identity.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.identity.id"))
		}
		assertEquals(savedResource.identity.name, getValue(result, "$prefix.identity.name"))
		assertEquals(savedResource.identity.description, getValue(result, "$prefix.identity.description"))
		assertEquals(savedResource.entity.state, getValue(result, "$prefix.entity.state"))
		assertEquals(savedResource.type, getValue(result, "$prefix.type"))
		assertListsEquals(savedResource.address, getValue(result, "$prefix.address"))
		assertEquals(savedResource.person, getValue(result, "$prefix.person"))
	}

	private fun createWithRequiredFields(): Contact {
	return Contact(
				type = "test_enum_value",
				address = listOf(Address(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					text = "test string value",
					line = listOf("test_list_string_value"),
					city = "test string value",
					district = "test string value",
					state = "test string value",
					postalCode = "test string value",
					country = "test_enum_value",
					useFor = "test_enum_value",
					addressType = "test_enum_value"
				)),
				person = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

	private fun createWithAllFields(): Contact {
		return Contact(
				type = "test_enum_value",
				address = listOf(Address(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					text = "test string value",
					line = listOf("test_list_string_value"),
					city = "test string value",
					district = "test string value",
					state = "test string value",
					postalCode = "test string value",
					country = "test_enum_value",
					useFor = "test_enum_value",
					addressType = "test_enum_value"
				)),
				person = "test string value"
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

}
