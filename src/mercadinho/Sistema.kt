package mercadinho

class Sistema {
    val listaDeVerdura: MutableList<Verduras> = ArrayList()
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
                        val grao = Graos().criaObjGrao()
                        listaDeGrao.add(grao)
                    }
                    "3" -> {

                    }
                    "4" -> {

                    }
                    "5" -> {
                        //Verduras().mostraListaVerdura(listaDeVerdura) -> só nao pega quantidade
                        mostraLista(listaDeVerdura,listaDeGrao)
                    } else -> throw IllegalArgumentException()

                }

            } catch (e: IllegalArgumentException) {
                println("Tipo de alimento inválido")
                menu()
            }
        }

    }

    fun mostraLista(listaDeVerdura: MutableList<Verduras>, listaDeGrao: MutableList<Graos>) {


        listaDeVerdura.forEach {
            println("${it.tipoDeProduto}: ${it.nomeProduto}\n" +
                    "Quantidade: ${it.quantidadeVerdura}\n")
        }
        listaDeGrao.forEach {
            println("${it.tipoDeProduto}: ${it.nomeProduto}\n" +
                    "Quantidade: ${it.quantidadeGrao}\n")
        }
    }

//    fun insereProdutoLista() : ArrayList<Produto> {
//        val listaDeProduto: ArrayList<Produto> = ArrayList()
//
//        println("Quantidade:")
//    }



    companion object Utilities {


    }
}