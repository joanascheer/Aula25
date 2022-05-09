package mercadinho

class Verduras(override var nomeProduto: String = "",
quantidade : Double = 0.0) : Produto(tipoDeProduto = "Verdura", nomeProduto) {
    var quantidadeVerdura = quantidade


    fun criaObjVerdura() : Verduras{

        try {
            println("Quantidade:")
            quantidadeVerdura = readln().toDouble()

            if (quantidadeVerdura < 0) {
                throw IllegalArgumentException()
            }
        } catch (e: NumberFormatException) {
            println("Para verdura, a quantidade deve ser informada com ponto.")
            criaObjVerdura()
        } catch (e: UnsupportedOperationException) {
            // todos os alimentos
            println("Não é permitido inserir valor vazio.")
            criaObjVerdura()
        } catch (e: IllegalArgumentException) {
            // todos os alimentos
            println("Não é possível inserir números negativos.")
            criaObjVerdura()
        }

        try {
            println("$tipoDeProduto:")
            nomeProduto = readln()
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir nome vazio.")
            criaObjVerdura()
        } catch (e: Exception) {
            println("O nome do produto deve ser escrito com letras entre A e Z.")
            criaObjVerdura()
        }
        return Verduras(nomeProduto,quantidadeVerdura)
    }

    fun mostraListaVerdura(listaDeVerdura: MutableList<Verduras>) {

        for (i in listaDeVerdura.indices) {
            println("${ listaDeVerdura[i] }")
        }
        listaDeVerdura.forEach {
            println("Produto: ${Verduras().tipoDeProduto}\n" +
                    "Nome: ${it.nomeProduto}\n" +
                    "Quantidade: ${Verduras().quantidadeVerdura}")
        }
    }
}
