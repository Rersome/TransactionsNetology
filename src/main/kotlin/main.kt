val MAX_SUM_DAY = 150_000.0
val MAX_SUM_MONTH = 600_000.0
val MAX_TRANSFER_ONCE_VKPAY = 15_000.0
val MAX_TRANSFER_MONTH_VKPAY = 40_000.0
val PROCENT_COMMISSION_MASTERCARD_MAESTRO = 0.006
val TRANSFER_PROMOTION_MAX_MASTERCARD_MAESTRO = 75_000.0
val TRANSFER_PROMOTION_MIN_MASTERCARD_MAESTRO = 300.0
val LITTLE_FEE_MASTERCARD_MAESTRO = 20.0
val LITTLE_FEE_MASTERCARD_VISA_MIR = 35.0
val PROCENT_COMMISSION_VISA_MIR = 0.0075

fun main() {
    println(calculateCommission("Mastercard", 1500.0, 150000.0, true))
}

fun calculateCommission(cardType: String = "Mir",
                        previousSum: Double = 0.0,
                        sum: Double,
                        promotion: Boolean): String {

    if (cardType == "VK Pay" && sum >= MAX_TRANSFER_ONCE_VKPAY) {
        return "Дневной лимит по карте VK Pay превышен"
    }

    if (cardType == "VK Pay" && previousSum + sum >= MAX_TRANSFER_MONTH_VKPAY) {
        return "Месячный лимит по карте VK Pay превышен"
    }

    if (sum > MAX_SUM_DAY) {
        return "Дневной лимит был превышен"
    }

    if (previousSum + sum > MAX_SUM_MONTH) {
        return "Месячный лимит был превышен"
    }

    val commission = when (cardType) {
        "Mir", "Visa" -> {
            when {
                sum >= 35 -> sum * PROCENT_COMMISSION_VISA_MIR + LITTLE_FEE_MASTERCARD_VISA_MIR
                else -> 0.0
            }
        }
        "Mastercard", "Maestro" -> {
            when {
                sum > TRANSFER_PROMOTION_MIN_MASTERCARD_MAESTRO && sum < TRANSFER_PROMOTION_MAX_MASTERCARD_MAESTRO && promotion -> 0.0
                else -> sum * PROCENT_COMMISSION_MASTERCARD_MAESTRO + LITTLE_FEE_MASTERCARD_MAESTRO
            }
        }
        else -> return "Данной карты не существует"
    }
    return "Коммиссия составила $commission"
}