package mercadinho

class Legumes(
    override var nomeProduto: String = "",
    quantidade: Int = 0,
) : Produto(tipoDeProduto = "Legume", nomeProduto) {
    var quantidadeLegume = quantidade

    fun criaObjLegume(): Legumes {

        try {
            println("Quantidade:")
            quantidadeLegume = readln().toInt()

            if (quantidade < 0) {
                throw IllegalArgumentException()
            }
            println("$tipoDeProduto:")
            nomeProduto = readln()

        } catch (e: NumberFormatException) {
            println("Para legume, a quantidade deve ser informada em unidades inteiras.")
            criaObjLegume()
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir valor vazio.")
            criaObjLegume()
        } catch (e: IllegalArgumentException) {
            println("Não é possível inserir números negativos.")
            criaObjLegume()
        } catch (e: UnsupportedOperationException) {
            println("Não é permitido inserir nome vazio.")
            criaObjLegume()
        }
        return Legumes(nomeProduto, quantidadeLegume)
    }

}
