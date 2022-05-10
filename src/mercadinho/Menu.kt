package mercadinho

import mercadinho.Sistema.Utilities.listaDeGrao
import mercadinho.Sistema.Utilities.listaDeLegume
import mercadinho.Sistema.Utilities.listaDeVerdura
import mercadinho.Sistema.Utilities.listaOutros

class Menu {

    init {
        println("** Seja bem vindo(a) ao **\n" +
                " B A L E I A * S T O R E \n")

        menu()
    }

    private fun menu() {

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

                        Sistema().mostraLista(listaDeVerdura, listaDeGrao, listaDeLegume, listaOutros)

                        println("          t o t a l           \n")

                        Sistema().mostraindices(listaDeVerdura, listaDeGrao, listaDeLegume, listaOutros)
                        Sistema.sair()


                    }
                    else -> throw IllegalArgumentException()

                }

            } catch (e: IllegalArgumentException) {
                println("Tipo de alimento inválido")
                menu()
            }
        }

    }

}