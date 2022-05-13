package exercicioLivraria.livro

import exercicioLivraria.utilitarios.Utilities.Utilities.sucesso

class Livro(
    var codigo: Int = 0,
    internal var titulo: String = "",
    internal var autor: String = "",
    internal var anoLancamento: Int = 0,
    internal var preco: Double = 0.0,
    internal var quantidadeEmEstoque: Int = 0
) {

    fun pegaDadosCodigo(): Int {
        try {
            println("Digite o código do livro:")
            codigo = readln().toInt()

            if (codigo <= 0) {
                throw IllegalArgumentException()
            } else {
                sucesso()
            }

        } catch (e: IllegalArgumentException) {
            println("Valor inválido, por favor, tente novamente.")
            pegaDadosCodigo()
        } catch (e: NumberFormatException) {
            println("O código deve ser composto por um número inteiro.")
            pegaDadosCodigo()
        }

        return codigo
    }

    fun pegaDadosTitulo(): String {
        try {
            println("Digite o título do livro:")
            titulo = readln()
        } catch (e: IllegalArgumentException) {
            println("Título inválido, por favor, tente novamente.")
            pegaDadosTitulo()
        }

        return titulo
    }

    fun pegaDadosAutor(): String {
        try {
            println("Digite o nome do autor do livro:")
            autor = readln()
            sucesso()
        } catch (e: IllegalArgumentException) {
            println("Valor inválido, por favor, tente novamente.")
            pegaDadosAutor()
        }

        return autor
    }

    fun pegaDadosAno(): Int {
        try {
            println("Digite o ano de lançamento do livro:")
            anoLancamento = readln().toInt()

            if (anoLancamento <= 0) {
                throw IllegalArgumentException()
            } else {
                sucesso()
            }

        } catch (e: IllegalArgumentException) {
            println("Ano inválido, por favor, tente novamente.")
            pegaDadosAno()
        } catch (e: NumberFormatException) {
            println("O ano de lançamento deve ser composto por um número inteiro.")
            pegaDadosAno()
        }

        return anoLancamento
    }

    fun pegaDadosQuantidade(): Int {
        try {
            println("Digite a quantidade deste exemplar no estoque:")
            quantidadeEmEstoque = readln().toInt()

            if (quantidadeEmEstoque < 0) {
                throw IllegalArgumentException()
            } else {
                sucesso()
            }

        } catch (e: IllegalArgumentException) {
            println("A quantidade não pode ser inferior à 0 (zero).")
            pegaDadosQuantidade()
        } catch (e: NumberFormatException) {
            println("O código deve ser composto por um número inteiro.")
            pegaDadosQuantidade()
        }

        return quantidadeEmEstoque
    }

    fun pegaDadosPreco(): Double {
        try {
            println("Digite o preço do livro:")
            preco = readln().toDouble()

            if (preco < 0) {
                throw IllegalArgumentException()
            } else {
                sucesso()
            }

        } catch (e: IllegalArgumentException) {
            println("O preço do livro não pode ser negativo.")
            pegaDadosPreco()
        } catch (e: NumberFormatException) {
            println("O preço deve ser declarado usando ponto para casa decimal.")
            pegaDadosPreco()
        }

        return preco
    }

}