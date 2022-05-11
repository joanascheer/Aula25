package conversorMoeda

import java.math.BigDecimal

abstract class Moeda () {
    var valor: BigDecimal = BigDecimal(0.0)

    abstract fun recebeMoeda() : BigDecimal

    abstract fun converte(valor: BigDecimal)

}