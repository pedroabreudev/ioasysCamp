fun main() {
    val variavel: Variaveis = Variaveis()
    //variavel.alterarNome()
    //variavel.verificarStatus()
    
    val estrutura: EstruturasDados = EstruturasDados()
    //estrutura.alterarLista()
    //estrutura.alterarMap()
    //estrutura.executarScopeFunctions()
    
    val nullsafety: NullSafety = NullSafety()
    //nullsafety.testarNome()
    
    val meuVeiculo: Veiculo = Veiculo("Ford", 2010)
    //meuVeiculo.ligar()
    
    val meuCarro: Carro = Carro("Ford", 2010)
    //meuCarro.ligar()
    
    val meuCachorro: Cachorro = Cachorro("Meu Cachorro")
    //meuCachorro.correr()
    
    val meuProgramador: Programador = Programador("Nome")
    meuProgramador.trabalhar()
    meuProgramador.descansar()
}

class Variaveis {
    
    val nomeImutavel: String = "Nome imutavel"
    var nomeMutavel: String = "Nome mutavel"
    
    var status: Int = 3
    
    fun alterarNome() {
        println(nomeMutavel)
        nomeMutavel = "Novo nome"
        println(nomeMutavel)
    }
    
    fun verificarStatus() {
        when (status) {
            0 -> println("Status 0")
            1 -> println("Status 1")
            else -> printarNaTela()
        }
    }
    
    fun printarNaTela() {
        println("Print na funcao")
    }
}

class EstruturasDados {
    
    val lista = mutableListOf("Banana", "Pera", "Uva")
    val outraLista = listOf("teste", "teste2")
    
    val map = mutableMapOf(
        "Chave1" to 1.99,
        "Chave2" to 2.99
    )
    
    fun alterarLista() {
        lista.addAll(outraLista)
        println(lista)
    }
    
    fun alterarMap() {
        map.put("Chave3", 3.99)
        println(map)
    }
    
    fun executarScopeFunctions() {
        lista.forEach { meuNome: String ->
            println(meuNome)
        }
        
        lista.map {
            "Fruta: $it"
        }.forEach {
            println(it)
        }
    }
}

class NullSafety {
    
    var nome: String? = null
    
    fun testarNome() {
        println(nome ?: "Nome alternativo")
        
        //NPE
        //println(nome!!.length)
        
        nome = "Nome"
        nome?.let {
            println("Nome nao nulo")
        }
        
        println(nome?.length)
    }
}

data class ClasseQualquer(
    val atributoQualquer: String
)

open class Veiculo(
    private val modelo: String,
    private val ano: Int
) {
    
    open fun ligar() {
        println("Veiculo ligando")
    }
}

data class Carro(
    val modelo: String,
    val ano: Int
): Veiculo(modelo, ano) {
    
    override fun ligar() {
        println("Meu carro ligando")
    }
}

abstract class Animal(
    private val nome: String
) {
    
    fun correr() {
        println("Animal correndo")
    }
    
    abstract fun pular()
}

data class Cachorro(
    val nome: String
): Animal(nome) {
    
    override fun pular() {
        println("Cachorro pulando")
    }
}

interface Trabalhador {
    
    fun trabalhar()
    
    fun descansar()
}

data class Programador(
    val nome: String
): Trabalhador {
    
    override fun trabalhar() {
        println("Programador trabalhando")
    }
    
    override fun descansar() {
        println("Programador descansando")
    }
}