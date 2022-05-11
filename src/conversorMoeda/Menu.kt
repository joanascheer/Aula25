package conversorMoeda

import kotlin.system.exitProcess

class Menu {

    init {
        println("*** Boas Vindas ao Conversor de Moedas ***\n")
        menuInicial()
    }

    fun menuInicial() {
        while (true) {
            try {
                println("Qual moeda deseja converter?\n" +
                        "[1] Dólar Americano\n" +
                        "[2] Dólar Canadense\n" +
                        "[3] Euro\n" +
                        "[4] Libra Esterlina\n" +
                        "[5] Sair do programa")
                when (readln().toInt()) {
                    1 -> {
                        avisoConversao()
                        DolarAmericano().recebeMoeda()
                        novaConversao()
                    }
                    2 -> {
                        avisoConversao()
                        DolarCanadense().recebeMoeda()
                        novaConversao()
                    }
                    3 -> {
                        avisoConversao()
                        Euro().recebeMoeda()
                        novaConversao()
                    }
                    4 -> {
                        avisoConversao()
                        LibraEsterlina().recebeMoeda()
                        novaConversao()
                    }
                    5 -> sair()
                    else -> throw IllegalArgumentException()
                }
            } catch (e: IllegalArgumentException) {
                println("Tipo de moeda inválido")
            }
        }
    }

    companion object Utilities {
        fun sair() {
            println("Obrigado(a) por utilizar nosso programa\n")
            exitProcess(0)
        }

        fun avisoConversao() {
            println("*** Este programa realiza apenas a conversão para o real brasileiro (R$) ***\n")
        }

        fun novaConversao() {
            try {
                println("Deseja realizar uma nova conversão?\n" +
                        "[1] SIM | [2] NÃO")
                when(readln().toInt()) {
                    1 -> Menu().menuInicial()
                    2 -> sair()
                    else -> throw IllegalArgumentException()
                }
            } catch (e: IllegalArgumentException) {
                println("Opção inválida")
                novaConversao()
            }

        }
    }

}