package mercadinho

class Outros(
    override var nomeProduto: String = "",
    quantidade: Int = 0,
) : Produto(tipoDeProduto = "Outro", nomeProduto) {
    var quantidadeOutros = quantidade

    fun criaObjOutro(): Outros {

        try {
            println("Quantidade:")
            quantidadeOutros = readln().toInt()

            if (quantidade < 0) {
                throw IllegalArgumentException()
            }

            println("$tipoDeProduto:")
            nomeProduto = readln()

        } catch (e: NumberFormatException) {
            println("Para a categoria Outros, a quantidade deve ser informada em unidades inteiras.")
            criaObjOutro()
        } catch (e: UnsupportedOperationException) {
            // todos os alimentos
            println("Não é permitido inserir valor vazio.")
            criaObjOutro()
        } catch (e: IllegalArgumentException) {
            // todos os alimentos
            println("Não é possível inserir números negativos.")
            criaObjOutro()
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir nome vazio.")
            criaObjOutro()
        }
        return Outros(nomeProduto, quantidadeOutros)
    }

    fun mostraListaOutros(listaOutros: MutableList<Outros>) {

        listaOutros.forEach {
            println("Produto: ${Verduras().tipoDeProduto}\n" +
                    "Nome: ${it.nomeProduto}\n" +
                    "Quantidade: ${quantidadeOutros}")
        }
    }
}
