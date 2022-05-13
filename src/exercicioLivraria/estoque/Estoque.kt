package exercicioLivraria.estoque

import exercicioLivraria.colecao.Colecao
import exercicioLivraria.livro.Livro
import exercicioLivraria.utilitarios.Utilities.Utilities.sair

class Estoque {

    internal val listaLivros: ArrayList<Livro> = ArrayList()
    val listaColecao: ArrayList<Livro> = ArrayList()

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

    fun registraColecao(): ArrayList<Livro> {

        val colecao = Colecao()

        colecao.pegaCodigoColecao()
        colecao.pegaPrecoColecao()
        colecao.pegaDescricaoColecao()

        println("Quantos livros têm a coleção a ser cadastrada?")
        val numeroLivrosColecao = readln().toInt()

        for (i in 1..numeroLivrosColecao) {
            val livroColecao = Livro()
            livroColecao.pegaDadosCodigo()
            livroColecao.pegaDadosTitulo()
            livroColecao.pegaDadosAutor()
            livroColecao.pegaDadosAno()
            livroColecao.pegaDadosPreco()
            livroColecao.pegaDadosQuantidade()

            listaColecao.add(livroColecao)
        }

        return listaColecao
    }

    fun consultarLivroUnico() {

        println("Digite o código do livro que deseja buscar")
        val codigoDigitado = readln().toInt()

        if (listaLivros.isEmpty()) {
            println("***********************\n" +
                    "Nenhum livro cadastrado\n" +
                    "***********************\n")
            consultarLivroUnico()
        } else {
            listaLivros.forEach {
                println("O código $codigoDigitado teve os seguintes resultados:\n" +
                        "Título: ${it.titulo}\n" +
                        "Autor(a): ${it.autor}\n" +
                        "Ano de lançamento: ${it.anoLancamento}\n" +
                        "Preço: ${it.preco}\n" +
                        "Quantidade em estoque: ${it.quantidadeEmEstoque}")
            }
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

    //quebrou aqui, arrumar logica
    internal fun venderLivro(listaLivros: ArrayList<Livro>): ArrayList <Livro> {

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
                    var novaQuantidade = livro.quantidadeEmEstoque - quantidadeVendida
                    livro.quantidadeEmEstoque = novaQuantidade
                }
            }
        }

        return listaLivros

    }

}