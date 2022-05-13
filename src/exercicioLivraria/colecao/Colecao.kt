package exercicioLivraria.colecao

import exercicioLivraria.livro.Livro

class Colecao(
    private var codigoColecao: Int = 0,
    private var precoColecao: Double = 0.0,
    private var descricaoColecao: String = "",
    private val listaColecao: ArrayList<Livro> = ArrayList(),
    var quantidadeEmEstoqueColecao: Int = 0,
) {

    fun retornaListaColecao() : ArrayList<Livro> = listaColecao

    fun pegaCodigoColecao(): Int {
        println("Digite o código da coleção:")
        codigoColecao = readln().toInt()
        return codigoColecao
    }

    fun retornaCodigoColecao(): Int = codigoColecao

    fun pegaPrecoColecao(): Double {
        println("Digite o preço da Coleção:")
        precoColecao = readln().toDouble()
        return precoColecao
    }

    fun retornaPrecoColecao() : Double {
        return precoColecao
    }

    fun pegaDescricaoColecao() {
        println("Descrição:")
        descricaoColecao = readln()
    }

    fun retornaDescricaoColecao() : String{
        return descricaoColecao
    }

    fun pegaQuantidadeEstoqueColecao(): Int {
        println("Digite a quantidade desta coleção em estoque")
        quantidadeEmEstoqueColecao = readln().toInt()
        return quantidadeEmEstoqueColecao
    }

}