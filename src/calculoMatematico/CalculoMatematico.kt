package calculoMatematico

class CalculoMatematico(
    private var numero1: Int = 0,
    private var numero2: Int = 0,
) {

    fun divide () : Int {
        try {
            println("Digite o primeiro número inteiro:")
            numero1 = readln().toInt()
            println("digite o segundo número inteiro:")
            numero2 = readln().toInt()

            numero1/numero2

        } catch (e: ArithmeticException) {
            println("A operação não pôde ser realizada.")
            return 0
        }

        return numero1/numero2
    }

//    fun divide () : Int {
//        try {
//            println("Digite o primeiro número inteiro:")
//            numero1 = readln().toInt()
//            println("digite o segundo número inteiro:")
//            numero2 = readln().toInt()
//
//            numero1/numero2
//
//        } catch (e: Exception) {
//            println("Você deve digitar números inteiros para realizar o cálculo.")
//            divide()
//        }
//
//        return numero1/numero2
//    }
}