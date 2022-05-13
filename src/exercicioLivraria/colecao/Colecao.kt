package exercicioLivraria.colecao

import exercicioLivraria.estoque.Estoque
import exercicioLivraria.livro.Livro

class Colecao(
    private var codigoColecao: Int = 0,
    private var precoColecao: Double = 0.0,
    private var descricaoColecao: String = "",
    listaColecao: ArrayList <Livro> = ArrayList()
) {

    fun pegaCodigoColecao() : Int {
        println("Digite o código da coleção:")
        codigoColecao = readln().toInt()
        return codigoColecao
    }

    fun pegaPrecoColecao() : Double {
        println("Digite o preço da Coleção:")
        precoColecao = readln().toDouble()
        return precoColecao
    }

    fun pegaDescricaoColecao() {
        println("Descrição:")
        descricaoColecao = readln()
    }

    fun cadastraColecao() {

    }


}