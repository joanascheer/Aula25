package exercicioLivraria.menu

import exercicioLivraria.estoque.Estoque
import exercicioLivraria.utilitarios.Utilities.Utilities.sair

class Menu {
    init {
        println("************************\n" +
                "   Sistema de Estoque   \n" +
                "  * Baleia Bookstore *  \n")

        val estoque = Estoque()
        menuprincipal(estoque)
    }

    private fun menuprincipal(estoque: Estoque) {
        while (true) {
            try {
                println("O que deseja fazer?\n" +
                        "[1] Cadastrar livro\n" +
                        "[2] Cadastrar coleção\n" +
                        "[3] Consultar livro\n" +
                        "[4] Efetuar venda\n" +
                        "[5] Sair do sistema")
                when (readln().toInt()) {
                    1 -> estoque.registraLivro()
                    2 -> estoque.registraColecao()
                    3 -> menuConsulta(estoque)
                    4 -> menuVenda(estoque)
                    5 -> sair()
                    else -> {
                        println("Opção inválida!")
                        menuprincipal(estoque)
                    }
                }
            } catch (e: NumberFormatException) {
                println("Valor inválido!")
                menuprincipal(estoque)
            }

        }
    }

    private fun menuConsulta(estoque: Estoque) {
        println("Deseja consultar:\n" +
                "[1] Livro\n" +
                "[2] Coleção\n" +
                "[3] Sair")
        when (readln().toInt()) {
            1 -> estoque.consultarLivroUnico(estoque.listaLivros)
            2 -> estoque.consultarColecao(estoque.listaDeColecoes)
            3 -> sair()
        }
    }

    private fun menuVenda(estoque: Estoque) {
        println("Você deseja vender:\n" +
                "[1] Livro | [2] Coleção")
        when (readln().toInt()) {
            1 -> estoque.venderLivro(estoque.listaLivros)
            2 -> estoque.venderColecao()
        }
    }

}