import org.junit.Assert.assertEquals
import org.junit.Test

class CommissionTest {

    @Test
    fun testMaxDay() {
        val type = "Visa"
        val transfer = 155_000.0
        val previous = 10_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Дневной лимит был превышен", result)
    }

    @Test
    fun testMaxMonth() {
        val type = "Visa"
        val transfer = 140_000.0
        val previous = 500_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Месячный лимит был превышен", result)
    }

    @Test
    fun testVisa() {
        val type = "Visa"
        val transfer = 140_000.0
        val previous = 10_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Коммиссия составила " + 1085.0, result)
    }

    @Test
    fun testVisaMin() {
        val type = "Visa"
        val transfer = 25.0
        val previous = 10_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Коммиссия составила " + 0.0, result)
    }

    @Test
    fun testMir() {
        val type = "Mir"
        val transfer = 25.0
        val previous = 10_000.0
        val promotion = true

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Коммиссия составила " + 0.0, result)
    }

    @Test
    fun testMaestro() {
        val type = "Maestro"
        val transfer = 74_000.0
        val previous = 10_000.0
        val promotion = true

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Коммиссия составила " + 0.0, result)
    }

    @Test
    fun testMaestroPromotion() {
        val type = "Maestro"
        val transfer = 74_000.0
        val previous = 10_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Коммиссия составила " + 464.0, result)
    }

    @Test
    fun testMastercard() {
        val type = "Mastercard"
        val transfer = 74_000.0
        val previous = 10_000.0
        val promotion = true

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Коммиссия составила " + 0.0, result)
    }

    @Test
    fun testMastercardPromotion() {
        val type = "Mastercard"
        val transfer = 74_000.0
        val previous = 10_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Коммиссия составила " + 464.0, result)
    }

    @Test
    fun testVkPayMax() {
        val type = "VK Pay"
        val transfer = 74_000.0
        val previous = 10_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Дневной лимит по карте VK Pay превышен", result)
    }

    @Test
    fun testVkPayMaxDay() {
        val type = "VK Pay"
        val transfer = 16_000.0
        val previous = 10_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Дневной лимит по карте VK Pay превышен", result)
    }

    @Test
    fun testVkPayMaxMonth() {
        val type = "VK Pay"
        val transfer = 14_000.0
        val previous = 26_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Месячный лимит по карте VK Pay превышен", result)
    }

    @Test
    fun unknownCard() {
        val type = "TEST"
        val transfer = 14_000.0
        val previous = 26_000.0
        val promotion = false

        val result = calculateCommission(cardType = type,
            sum = transfer,
            previousSum = previous,
            promotion = promotion)

        assertEquals("Данной карты не существует", result)
    }
}