package mercadinho

import kotlin.system.exitProcess

class Sistema {

    fun mostraLista(
        listaDeVerdura: MutableList<Verduras>,
        listaDeGrao: MutableList<Graos>,
        listaDeLegume: MutableList<Legumes>,
        listaOutros: MutableList<Outros>,
    ) {


        listaDeVerdura.forEach {
            println("${it.tipoDeProduto}: ${it.nomeProduto}\n" +
                    "Quantidade: ${it.quantidadeVerdura}\n")
        }
        listaDeGrao.forEach {
            println("${it.tipoDeProduto}: ${it.nomeProduto}\n" +
                    "Quantidade: ${it.quantidadeGrao}\n")
        }
        listaDeLegume.forEach {
            println("${it.tipoDeProduto}: ${it.nomeProduto}\n" +
                    "Quantidade: ${it.quantidadeLegume}\n")
        }
        listaOutros.forEach {
            println("${it.tipoDeProduto}: ${it.nomeProduto}\n" +
                    "Quantidade: ${it.quantidadeOutros}\n")
        }
    }

    fun mostraindices(
        listaDeVerdura: MutableList<Verduras>,
        listaDeGrao: MutableList<Graos>,
        listaDeLegume: MutableList<Legumes>,
        listaOutros: MutableList<Outros>,
    ) {
        for (i in listaDeVerdura.indices) {
            println("A quantidade de verduras é ${listaDeVerdura.size}")
        }

        for (i in listaDeGrao.indices) {
            println("A quantidade de grãos é ${listaDeGrao.size}")
        }

        for (i in listaDeLegume.indices) {
            println("A quantidade de legumes é ${listaDeLegume.size}")
        }

        for (i in listaOutros.indices) {
            println("A quantidade de outros produtos comprados é ${listaOutros.size}")
        }

    }


    companion object Utilities {

        fun sair() {
            println("Obrigado(a) por comprar conosco!\n")
            exitProcess(0)
        }

        val listaDeVerdura: MutableList<Verduras> = ArrayList()
        val listaDeLegume: MutableList<Legumes> = ArrayList()
        val listaOutros: MutableList<Outros> = ArrayList()
        val listaDeGrao: MutableList<Graos> = ArrayList()
    }
}