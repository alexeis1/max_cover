package ru.netology.lesson4.variouscommision

/**
 * Домашнее задание к занятию «2.1. Функции, автотесты и Continuous Integration»
 * Задача №1 - Максимальное покрытие
 */

enum class CardTypes {
    Mastercard, Maestro, Visa, Mir, VKPay
}

fun main()
{

}

/**
 *
 * Description
 * calcPaymentCommission вычисляет комиссию в копейках
 * cardType       - Тип карты/счёта (по умолчанию - Vk Pay)
 * lastPayments   - Сумма предыдущих переводов в этом месяце (по умолчанию - 0)
 * currentPayment - Сумма совершаемого перевода в копейках
 * результат      - комиссия в копейках
 */
fun calcPaymentCommission (cardType : CardTypes = CardTypes.VKPay,
                           lastMonthPayments : Long = 0, currentPayment : Long) : Long
{
    val noCommission = 0L
    return when(cardType) {
        CardTypes.Mastercard, CardTypes.Maestro ->
                                         calcMastercardMaestroCommission(currentPayment, lastMonthPayments)
        CardTypes.Visa, CardTypes.Mir -> calcVisaMirCommission          (currentPayment)
        else                          -> noCommission
    }
}

/**
 * Description
 * calcMastercardMaestroCommission
 * вычисляет комиссию в копейках для Mastercard, Maestro
 * currentPayment - Сумма совершаемого перевода в копейках
 * результат      - комиссия в копейках
 */
fun calcMastercardMaestroCommission(currentPayment : Long, lastMonthPayments : Long) : Long
{
    val noCommission                = 0L
    val commissionPercent           = 0.6F
    val commissionFix               = 20_00.0F
    val mastercardMaestroMonthLimit = 75_000_00
    return if (lastMonthPayments < mastercardMaestroMonthLimit) {
        noCommission
    } else {
        (currentPayment * commissionPercent / 100.0F + commissionFix).toLong()
    }
}

/**
 * Description
 * calcVisaMirCommission
 * вычисляет комиссию в копейках для Visa, Mir
 * currentPayment - Сумма совершаемого перевода в копейках
 * результат      - комиссия в копейках
 */
fun calcVisaMirCommission(currentPayment : Long) : Long
{
    val commissionPercent = 0.75F
    val commissionMin     = 35_00L
    val result = (currentPayment * commissionPercent / 100.0F).toLong()
    return if (result >= commissionMin) result else commissionMin
}
