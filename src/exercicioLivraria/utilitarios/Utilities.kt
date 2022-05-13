package exercicioLivraria.utilitarios

import kotlin.system.exitProcess

class Utilities {
    companion object Utilities {
        fun sucesso() {
            println("Processo realizado com sucesso!")
        }

        fun sair() {
            println("Obrigado(a) por utilizar o sistema!")
            exitProcess(0)
        }

    }
}