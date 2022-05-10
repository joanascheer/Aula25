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

            println("$tipoDeProduto:")
            nomeProduto = readln()

        } catch (e: NumberFormatException) {
            println("Para grãos, a quantidade deve ser informada com ponto.")
            criaObjGrao()
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir valor vazio.")
            criaObjGrao()
        } catch (e: IllegalArgumentException) {
            println("Não é possível inserir números negativos.")
            criaObjGrao()
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir nome vazio.")
            criaObjGrao()
        }
        return Graos(nomeProduto, quantidadeGrao)
    }

}
