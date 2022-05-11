package conversorMoeda

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class LibraEsterlina: Moeda() {

    override fun recebeMoeda(): BigDecimal {
        val libraEsterlina = LibraEsterlina()
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

        libraEsterlina.converte(valor)
        return valor
    }

    override fun converte(valor: BigDecimal) {
        val valorConvertido = valor * BigDecimal(6.33)
        println("A Libra Esterlina na cotação de hoje << ${formataData()} >> está em R$6,33.\n" +
                "O valor que pediu para converter de $valor £ é R$ %.2f".format(valorConvertido))
    }

    override fun formataData(): String {
        val formato = "dd/MM/yyyy"
        val simpleDateFormat = SimpleDateFormat(formato)
        return simpleDateFormat.format(Date())
    }

}