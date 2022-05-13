package exercicioLivraria.colecao

import exercicioLivraria.livro.Livro

class Colecao(
    var codigoColecao: Int = 0,
    internal var precoColecao: Double = 0.0,
    var descricaoColecao: String = "",
    val listaColecao: ArrayList <Livro> = ArrayList(),
    var quantidadeEmEstoqueColecao: Int = 0,
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

    fun pegaQuantidadeEstoqueColecao() : Int{
        println("Digite a quantidade desta coleção em estoque")
        quantidadeEmEstoqueColecao = readln().toInt()
        return quantidadeEmEstoqueColecao
    }


}