package mercadinho

class Graos(
    override var nomeProduto: String = "",
    quantidade: Double = 0.0,
) : Produto(tipoDeProduto = "Grãos", nomeProduto) {
    var quantidadeGrao = quantidade

    fun criaObjGrao(): Graos {

        try {
            println("Quantidade:")
            quantidadeGrao = readln().toDouble()

            if (quantidadeGrao < 0) {
                throw IllegalArgumentException()
            }
        } catch (e: NumberFormatException) {
            println("Para grãos, a quantidade deve ser informada com ponto.")
            criaObjGrao()
        } catch (e: UnsupportedOperationException) {
            // todos os alimentos
            println("Não é permitido inserir valor vazio.")
            criaObjGrao()
        } catch (e: IllegalArgumentException) {
            // todos os alimentos
            println("Não é possível inserir números negativos.")
            criaObjGrao()
        }

        try {
            println("$tipoDeProduto:")
            nomeProduto = readln()
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir nome vazio.")
            criaObjGrao()
        } catch (e: Exception) {
            println("O nome do produto deve ser escrito com letras entre A e Z.")
            criaObjGrao()
        }
        return Graos(nomeProduto, quantidadeGrao)
    }

    fun mostraListaGrao(listaDeGraos: MutableList<Graos>) {

        listaDeGraos.forEach {
            println("Produto: ${Verduras().tipoDeProduto}\n" +
                    "Nome: ${it.nomeProduto}\n" +
                    "Quantidade: ${quantidadeGrao}")
        }
    }
}
