package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.User
import cloud.djet.catalog.catalog.domain.EmailAddress
import cloud.djet.catalog.catalog.domain.UserPhone
import cloud.djet.catalog.catalog.domain.ReferenceIdentity
import cloud.djet.catalog.catalog.domain.TermsAndConditions
import cloud.djet.catalog.domain.Element
import cloud.djet.catalog.domain.Period
import cloud.djet.catalog.catalog.CatalogApplication
import cloud.djet.catalog.catalog.repository.UsersRepository
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
class UsersApiIT : AbstractIntegrationTest<User>() {

	private val url = "/users"

	@Autowired
	lateinit var repository: UsersRepository

	@Test
	fun `usersCreateUser with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `usersCreateUser with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `usersGetUser with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `usersGetUser with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `usersGetUserList api`() {
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
	fun `usersModifyUser with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `usersUpdateUser with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `usersUpdateUser with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: User, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.identity.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.identity.id"))
		}
		assertEquals(savedResource.identity.name, getValue(result, "$prefix.identity.name"))
		assertEquals(savedResource.identity.description, getValue(result, "$prefix.identity.description"))
		assertEquals(savedResource.entity.state, getValue(result, "$prefix.entity.state"))
		assertObjectEquals(savedResource.email, getValue(result, "$prefix.email"))
		assertObjectEquals(savedResource.phone, getValue(result, "$prefix.phone"))
		assertEquals(savedResource.profile, getValue(result, "$prefix.profile"))
		assertListsEquals(savedResource.parties, getValue(result, "$prefix.parties"))
		assertEquals(savedResource.primaryParty, getValue(result, "$prefix.primaryParty"))
		assertObjectEquals(savedResource.provider, getValue(result, "$prefix.provider"))
		assertListsEquals(savedResource.termsAndConditions, getValue(result, "$prefix.termsAndConditions"))
	}

	private fun createWithRequiredFields(): User {
	return User(
				email = EmailAddress(
					address = "test string value",
					verified = false,
					dateAdded = 9223372036854775807L,
					dateBounced = 9223372036854775807L
				),
				phone = null,
				profile = null,
				parties = null,
				primaryParty = null,
				provider = null,
				termsAndConditions = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
		}
	}

	private fun createWithAllFields(): User {
		return User(
				email = EmailAddress(
					address = "test string value",
					verified = false,
					dateAdded = 9223372036854775807L,
					dateBounced = 9223372036854775807L
				),
				phone = UserPhone(
					mobile = "test string value",
					home = "test string value",
					work = "test string value"
				),
				profile = "test string value",
				parties = listOf("test_list_string_value"),
				primaryParty = "test string value",
				provider = ReferenceIdentity(
					resourceId = "test string value",
					name = "test string value",
					description = "test string value",
					type = "test string value",
					uri = "test string value"
				),
				termsAndConditions = listOf(TermsAndConditions(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					isSet = false,
					termsAndConditionsText = "test string value",
					version = "test string (was object) value"
				))
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
		}
	}

}
