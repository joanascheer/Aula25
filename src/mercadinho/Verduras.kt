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

            println("$tipoDeProduto:")
            nomeProduto = readln()

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
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir nome vazio.")
            criaObjVerdura()
        }
        return Verduras(nomeProduto,quantidadeVerdura)
    }

    fun mostraListaVerdura(listaDeVerdura: MutableList<Verduras>) {

        listaDeVerdura.forEach {
            println("Produto: ${Verduras().tipoDeProduto}\n" +
                    "Nome: ${it.nomeProduto}\n" +
                    "Quantidade: ${quantidadeVerdura}")
        }
    }
}