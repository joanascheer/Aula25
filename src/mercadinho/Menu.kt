package mercadinho

class Menu {
    init {
        println("** Seja bem vindo(a) ao **\n" +
                " B A L E I A * S T O R E \n")

        menu()
    }

    fun menu() {
        try {
            while (true) {
                println("Que tipo de alimento deseja inserir na sua cestinha?\n" +
                        "[1] Verdura\n" +
                        "[2] Legume\n" +
                        "[3] Grão\n" +
                        "[4] Outro\n" +
                        "[5] Sair do sistema")
                when(readln()) {
                    "1" -> {

                    }
                    "2" -> {

                    }
                    "3" -> {

                    }
                    "4" -> {

                    }
                    "5" -> {

                    } else -> {
                    println("Opção inválida")
                    menu()
                    }

                }
            }
        } catch (e: IllegalArgumentException) {
            println("Tipo de alimento inválido!")
        }

    }
}