package mercadinho

import kotlin.system.exitProcess

class Sistema {
    val listaDeVerdura: MutableList<Verduras> = ArrayList()
    val listaDeLegume: MutableList<Legumes> = ArrayList()
    val listaOutros: MutableList<Outros> = ArrayList()
    val listaDeGrao: MutableList<Graos> = ArrayList()

    init {
        println("** Seja bem vindo(a) ao **\n" +
                " B A L E I A * S T O R E \n")

        menu()
    }

    fun menu() {


        while (true) {
            try {
                println("Que tipo de alimento deseja inserir na sua cestinha?\n" +
                        "[1] Verdura\n" +
                        "[2] Legume\n" +
                        "[3] Grão\n" +
                        "[4] Outro\n" +
                        "[5] Sair do sistema")
                when (readln()) {
                    "1" -> {
                        val verdura = Verduras().criaObjVerdura()
                        listaDeVerdura.add(verdura)
                    }
                    "2" -> {
                        val legume = Legumes().criaObjLegume()
                        listaDeLegume.add(legume)
                    }
                    "3" -> {
                        val grao = Graos().criaObjGrao()
                        listaDeGrao.add(grao)
                    }
                    "4" -> {
                        val outro = Outros().criaObjOutro()
                        listaOutros.add(outro)
                    }
                    "5" -> {
                        println("-----------------------------\n" +
                                "*** Sua lista de produtos ***\n" +
                                "-----------------------------\n")

                        mostraLista(listaDeVerdura, listaDeGrao, listaDeLegume, listaOutros)

                        println("          t o t a l           \n")

                        mostraindices(listaDeVerdura, listaDeGrao, listaDeLegume, listaOutros)
                        sair()


                    }
                    else -> throw IllegalArgumentException()

                }

            } catch (e: IllegalArgumentException) {
                println("Tipo de alimento inválido")
                menu()
            }
        }

    }

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

//    fun insereProdutoLista() : ArrayList<Produto> {
//        val listaDeProduto: ArrayList<Produto> = ArrayList()
//
//        println("Quantidade:")
//    }


    companion object Utilities {

        fun sair() {
            println("Obrigado(a) por comprar conosco!\n")
            exitProcess(0)
        }
    }
}