package ru.netology.lesson4

import org.junit.Test

import org.junit.Assert.*
import ru.netology.lesson4.variouscommision.*

class MainKtTest {
//Минимальная коммиссия Виза/Мир
    @Test
    fun calcVisaMirCommission_commissionMin() {
        val currentPayment = 10_00L
        val result = calcVisaMirCommission(currentPayment)
        assertEquals(35_00L, result)
    }
//стандартная коммиссия Виза/Мир
    @Test
    fun calcVisaMirCommission_commissionPercent() {
        val currentPayment = ((35_00L + 1L) * 100L / 0.75F).toLong()
        val result = calcVisaMirCommission(currentPayment)
        assertEquals((currentPayment * 0.75F / 100.0F).toLong(), result)
    }
//месячный лимит не достигнут
    @Test
    fun calcMastercardMaestro_noCommission() {
        val currentPayment = 10_00L
        val monthLimit     = 10_000_00L
        val result = calcMastercardMaestroCommission(currentPayment, monthLimit)
        assertEquals(0L, result)
    }
//месячный лимит превышен
    @Test
    fun calcMastercardMaestro_CommissionPercent() {
        val currentPayment = 1_000_00L  // 1000 * 0.6% = 6р + 20р фикс = 26р
        val monthLimit     = 80_000_00L //>75_000_00
        val result = calcMastercardMaestroCommission(currentPayment, monthLimit)
        assertEquals(26_0L, result)
    }


    @Test
    fun calcPaymentCommission() {

    }




}