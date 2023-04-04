package cloud.djet.catalog.catalog.controller

import cloud.djet.catalog.catalog.domain.Account
import cloud.djet.catalog.catalog.domain.PaymentInstrument
import cloud.djet.catalog.domain.Element
import cloud.djet.catalog.domain.Period
import cloud.djet.catalog.catalog.domain.PaymentInstrumentSpec
import cloud.djet.catalog.catalog.domain.BankSpec
import cloud.djet.catalog.catalog.domain.CardSpec
import cloud.djet.catalog.catalog.domain.BillingInformation
import cloud.djet.catalog.catalog.domain.Address
import cloud.djet.catalog.catalog.domain.HumanName
import cloud.djet.catalog.catalog.domain.ContactPoint
import cloud.djet.catalog.catalog.domain.ShippingInformation
import cloud.djet.catalog.domain.Identity
import cloud.djet.catalog.catalog.CatalogApplication
import cloud.djet.catalog.catalog.repository.PartyAccountsRepository
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
class PartyAccountsApiIT : AbstractIntegrationTest<Account>() {

	private val url = "/parties/parent-id/accounts"

	@Autowired
	lateinit var repository: PartyAccountsRepository

	@Test
	fun `partyAccountsCreateAccount with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsCreateAccount with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsGetAccount with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsGetAccount with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsGetAccountList api`() {
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
	fun `partyAccountsModifyAccount with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsUpdateAccount with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `partyAccountsUpdateAccount with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)
		savedRes.identity.name = "new identity"
		savedRes.identity.description = "new description"

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: Account, result: MvcResult, index: Int = -1) {
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
		assertEquals(savedResource.legalEntity, getValue(result, "$prefix.legalEntity"))
		assertEquals(savedResource.country, getValue(result, "$prefix.country"))
		assertEquals(savedResource.accountNumber, getValue(result, "$prefix.accountNumber"))
		assertListsEquals(savedResource.paymentInstruments, getValue(result, "$prefix.paymentInstruments"))
		assertListsEquals(savedResource.billingInformation, getValue(result, "$prefix.billingInformation"))
		assertListsEquals(savedResource.shippingInformation, getValue(result, "$prefix.shippingInformation"))
	}

	private fun createWithRequiredFields(): Account {
	return Account(
				type = "test_enum_value",
				legalEntity = "test string value",
				country = null,
				accountNumber = null,
				paymentInstruments = null,
				billingInformation = null,
				shippingInformation = null
		).apply {
			this.identity.name = "test name"
			this.identity.description = "test description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

	private fun createWithAllFields(): Account {
		return Account(
				type = "test_enum_value",
				legalEntity = "test string value",
				country = "test_enum_value",
				accountNumber = "test string value",
				paymentInstruments = listOf(PaymentInstrument(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					type = "test_enum_value",
					name = "test string value",
					spec = PaymentInstrumentSpec(
					bank = BankSpec(
					routingNumber = "test string valu",
					accountNumber = "test string valu"
				),
					card = CardSpec(
					cardNumber = "test string valu",
					cardToken = "test string value",
					paymentURL = "test string value",
					transactionId = "test string value",
					approved = false,
					paymentId = "test string value"
				)
				)
				)),
				billingInformation = listOf(BillingInformation(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					address = Address(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					use = "test_enum_value",
					type = "test_enum_value",
					text = "test string value",
					line = listOf("test_list_string_value"),
					city = "test string value",
					district = "test string value",
					state = "test string value",
					postalCode = "test string value",
					country = "test_enum_value"
				),
					name = HumanName(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					use = "test_enum_value",
					text = "test string value",
					family = "test string value",
					given = listOf("test_list_string_value"),
					prefix = listOf("test_list_string_value"),
					suffix = listOf("test_list_string_value")
				),
					phone = ContactPoint(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					system = "test_enum_value",
					value = "test string value",
					use = "test_enum_value"
				),
					email = ContactPoint(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					system = "test_enum_value",
					value = "test string value",
					use = "test_enum_value"
				)
				)),
				shippingInformation = listOf(ShippingInformation(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					address = Address(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					use = "test_enum_value",
					type = "test_enum_value",
					text = "test string value",
					line = listOf("test_list_string_value"),
					city = "test string value",
					district = "test string value",
					state = "test string value",
					postalCode = "test string value",
					country = "test_enum_value"
				),
					name = HumanName(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					use = "test_enum_value",
					text = "test string value",
					family = "test string value",
					given = listOf("test_list_string_value"),
					prefix = listOf("test_list_string_value"),
					suffix = listOf("test_list_string_value")
				),
					phone = ContactPoint(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					system = "test_enum_value",
					value = "test string value",
					use = "test_enum_value"
				),
					email = ContactPoint(
					header = Element(
					order = 8,
					rank = 8,
					period = Period(
					start = Date(),
					end = Date()
				)
				),
					system = "test_enum_value",
					value = "test string value",
					use = "test_enum_value"
				),
					deliveryInstructions = "test string value"
				))
		).apply {
			this.identity.name = "test user name"
			this.identity.description = "test user description"
			this.entity.state = "active"
			this.entity.parent = Identity(id = "parent-id")
		}
	}

}
