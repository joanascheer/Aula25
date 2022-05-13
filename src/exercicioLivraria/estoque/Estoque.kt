package exercicioLivraria.estoque

import exercicioLivraria.colecao.Colecao
import exercicioLivraria.livro.Livro
import exercicioLivraria.utilitarios.Utilities.Utilities.sair

class Estoque {
    internal val listaLivros: ArrayList<Livro> = ArrayList()

    private val listaDeColecoes = ArrayList<Colecao>()


    fun registraLivro(): Livro {
        val livroCriado = Livro()
        livroCriado.pegaDadosCodigo()
        livroCriado.pegaDadosTitulo()
        livroCriado.pegaDadosAutor()
        livroCriado.pegaDadosAno()
        livroCriado.pegaDadosPreco()
        livroCriado.pegaDadosQuantidade()

        listaLivros.add(livroCriado)

        //verificaLivroRepetido(livroCriado.codigo, livroCriado)

        return livroCriado

    }

    fun registraColecao(): Colecao {
        val colecao = Colecao()

        colecao.pegaCodigoColecao()
        colecao.pegaPrecoColecao()
        colecao.pegaQuantidadeEstoqueColecao()
        colecao.pegaDescricaoColecao()

        println("Quantos livros têm a coleção a ser cadastrada?")
        val numeroLivrosColecao = readln().toInt()


        for (i in 1..numeroLivrosColecao) {
            val livroColecao = Livro()

            livroColecao.pegaDadosTitulo()
            livroColecao.pegaDadosAutor()
            livroColecao.pegaDadosAno()

            colecao.retornaListaColecao().add(livroColecao)

        }

        listaDeColecoes.add(colecao)

        return colecao
    }

    fun consultarColecao() {
        println("Digite o código da coleção que deseja buscar")
        val codigoDigitadoColecao = readln().toInt()

        for (colecao in listaDeColecoes) {
            if (codigoDigitadoColecao == colecao.retornaCodigoColecao()) {
                println("O código $codigoDigitadoColecao retornou o seguinte resultado:\n" +
                        "Descrição da coleção: ${colecao.retornaDescricaoColecao()}\n" +
                        "Preço: ${colecao.retornaPrecoColecao()}\n" +
                        "Quantidade de coleção em estoque: ${colecao.quantidadeEmEstoqueColecao}\n")
                for (livro in colecao.retornaListaColecao()) {
                    println("\"-------------------------------------------\n" +
                            "Título: ${livro.titulo}\n" +
                            "Autor: ${livro.autor}\n" +
                            "Ano de lançamento: ${livro.anoLancamento}\n")
                }
            }
        }
    }

    fun consultarLivroUnico() {
        try {
            println("Digite o código do livro que deseja buscar")
            val codigoDigitado = readln().toInt()

            if (listaLivros.isEmpty()) {
                println("***********************\n" +
                        "Nenhum livro cadastrado\n" +
                        "***********************\n")
                consultarLivroUnico()
            } else {

                for (livro in listaLivros) {
                    if (codigoDigitado == livro.codigo) {
                        listaLivros.forEach {
                            println("********************************************************\n" +
                                    "O código ${livro.codigo} obteve os seguintes resultados:\n" +
                                    "********************************************************\n" +
                                    "| Título: ${it.titulo}\n" +
                                    "| Autor(a): ${it.autor}\n" +
                                    "| Ano de lançamento: ${it.anoLancamento}\n" +
                                    "| Preço: ${it.preco}\n" +
                                    "| Quantidade em estoque: ${it.quantidadeEmEstoque}\n" +
                                    "------------------------------------------------------\n")
                        }
                    } else if (codigoDigitado < 0) {
                        throw NumberFormatException()
                    } else {
                        println("Livro não cadastrado")
                        consultarLivroUnico()
                    }
                }
            }

        } catch (e: NumberFormatException) {
            println("Código inválido, tente novamente.")
            consultarLivroUnico()
        }
    }

    private fun verificaLivroRepetido(codigo: Int, livro: Livro) {

        var verifica = false

        for (i in listaLivros.indices) {
            when (codigo) {
                listaLivros[i].codigo -> {
                    verifica = true
                }
            }
        }

        if (verifica) {
            println("Você já tem este livro no seu estoque.\n" +
                    "Cadastre com um código diferente.")
            registraLivro()
        }
    }

    internal fun venderLivro(listaLivros: ArrayList<Livro>): ArrayList<Livro> {

        println("Digite o código do livro a ser vendido:")
        val codigoLivroVendido = readln().toInt()

        for (livro in listaLivros) {
            if (codigoLivroVendido == livro.codigo) {
                println("Quantos livros serão vendidos?")
                val quantidadeVendida = readln().toInt()

                if (quantidadeVendida > livro.quantidadeEmEstoque) {
                    println("Não há quantidade suficiente de exemplares disponíveis para venda.")
                    venderLivro(listaLivros)
                } else if (quantidadeVendida == livro.quantidadeEmEstoque) {
                    for (livro in listaLivros) {
                        listaLivros.remove(livro)
                        println("Venda realizada com sucesso, estoque vazio!\n" +
                                "Deseja cadastrar mais exemplares?\n" +
                                "[1] Sim | [2] Não")
                        when (readln().toInt()) {
                            1 -> registraLivro()
                            2 -> sair()
                        }
                        break
                    }
                } else {
                    val novaQuantidade = livro.quantidadeEmEstoque - quantidadeVendida
                    livro.quantidadeEmEstoque = novaQuantidade
                    println("$quantidadeVendida livros ${livro.titulo} foram vendidos!\n" +
                            "Ainda existem ${livro.quantidadeEmEstoque} exemplares no estoque!\n")
                }
            } else {
                println("Livro não encontrado!")
                venderLivro(listaLivros)
            }
        }

        return listaLivros

    }

    private fun verColecao() {
        println("Sua lista de coleções\n" +
                "*******************************************\n")
        for (colecao in listaDeColecoes) {
            println("Código da coleção: ${colecao.retornaCodigoColecao()}\n" +
                    "Descrição da coleção: ${colecao.retornaDescricaoColecao()}\n" +
                    "Preço: ${colecao.retornaPrecoColecao()}\n" +
                    "Quantidade de coleção em estoque: ${colecao.quantidadeEmEstoqueColecao}\n")
            for (livro in colecao.retornaListaColecao()) {
                println("-------------------------------------------\n" +
                        "Título: ${livro.titulo}\n" +
                        "Autor: ${livro.autor}\n" +
                        "Ano de lançamento: ${livro.anoLancamento}\n")
            }
        }
    }

    fun venderColecao() {
        verColecao()

        println("Qual é o código da coleção que deseja vender?")
        val codigoDigitado = readln().toInt()

        for (colecao in listaDeColecoes) {
            try {
                if (codigoDigitado < 0) {
                    throw NumberFormatException()

                } else if (listaDeColecoes.isEmpty()) {
                    println("A lista está vazia!")

                } else if (codigoDigitado == colecao.retornaCodigoColecao()) {
                    println("Quantas coleções serão vendidas?")
                    val quantidadeVendida = readln().toInt()

                    if (quantidadeVendida > colecao.quantidadeEmEstoqueColecao) {
                        println("Não existem exemplares suficientes. Temos ${colecao.quantidadeEmEstoqueColecao} em estoque.")
                        venderColecao()

                    } else if (quantidadeVendida == colecao.quantidadeEmEstoqueColecao) {
                        listaDeColecoes.remove(colecao)
                        println("Coleção vendida. Não temos mais exemplares em estoque!\n" +
                                "Deseja adicionar mais?\n" +
                                "[1] Sim | [2] Não")
                        when (readln().toInt()) {
                            1 -> registraColecao()
                            2 -> sair()
                        }
                    } else {
                        val novaQuantidade = colecao.quantidadeEmEstoqueColecao - quantidadeVendida
                        colecao.quantidadeEmEstoqueColecao = novaQuantidade

                        println("$quantidadeVendida exemplares vendidos. Temos ${colecao.quantidadeEmEstoqueColecao} em estoque!\n")
                    }
                } else {
                    println("Coleção não encontrada. Tente novamente.")
                    venderColecao()
                }
            } catch (e: NumberFormatException) {
                println("Código inválido")
                venderColecao()
            }
        }
    }
}
