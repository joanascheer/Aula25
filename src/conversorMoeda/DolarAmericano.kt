package conversorMoeda

import java.math.BigDecimal

class DolarAmericano: Moeda() {
    override fun recebeMoeda(): BigDecimal {
        val dolarAm = DolarAmericano()
        try {
            println("Qual o valor a ser convertido?")
            valor = readln().toBigDecimal()
            if (valor <= BigDecimal(0.0)) {
                throw IllegalArgumentException()
            }
        } catch (e: NumberFormatException) {
            println("Para moeda, o valor monetário deve ser um número decimal.")
            recebeMoeda()
        } catch (e: IllegalArgumentException) {
            println("Valor inválido, por favor, tente novamente.")
            recebeMoeda()
        }

        dolarAm.converte(valor)
        return valor
    }

    override fun converte(valor: BigDecimal) {
        val valorConvertido = valor * BigDecimal(5.41)
        println("U$ $valor convertido em R$$valorConvertido")
    }
}