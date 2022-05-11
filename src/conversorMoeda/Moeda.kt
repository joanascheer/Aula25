package conversorMoeda

import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

abstract class Moeda () {

    var valor: BigDecimal = BigDecimal(0.0)

    abstract fun recebeMoeda() : BigDecimal

    abstract fun converte(valor: BigDecimal)

    abstract fun formataData() : String

}