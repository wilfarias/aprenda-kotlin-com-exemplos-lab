// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int, val email: String){
    override fun toString(): String {
        return "$nome"
    }
}

fun UsuarioFactory(): List<Usuario>{    
    val listaUsuarios = mutableListOf<Usuario>()
    
    listaUsuarios.add(Usuario("Carlos", 19, "carlos@gmail.com"))
    listaUsuarios.add(Usuario("Andre", 24, "andre@gmail.com"))
    listaUsuarios.add(Usuario("Julia", 28, "julia@gmail.com"))
    listaUsuarios.add(Usuario("Yuri", 20, "yuri@gmail.com"))
    listaUsuarios.add(Usuario("Luisa", 32, "luisa@gmail.com"))
    
    return listaUsuarios
}

data class ConteudoEducacional(val nome: String, val cargaHoraria: Int, val nivel: Nivel)

fun ConteudoEducacionalFactory(): List<ConteudoEducacional>{    
    val listaMaterias = mutableListOf<ConteudoEducacional>()
    
    listaMaterias.add(ConteudoEducacional("Introdução a linguagem", 20, Nivel.BASICO))
    listaMaterias.add(ConteudoEducacional("Estruturas de Controle de Fluxo", 40, Nivel.BASICO))
    listaMaterias.add(ConteudoEducacional("Orientação a Objetos", 60, Nivel.BASICO))
    listaMaterias.add(ConteudoEducacional("Tratamento de Exceções", 60, Nivel.INTERMEDIARIO))
    listaMaterias.add(ConteudoEducacional("Padrões de Projeto", 80, Nivel.INTERMEDIARIO))
    
    return listaMaterias
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun matricularTodos(listaUsuarios: List<Usuario>) {
        inscritos.addAll(listaUsuarios)
    }
    
    fun imprimeAlunosMatriculados(){ 
        inscritos.forEach {                                     
        	aluno -> println("Aluno: $aluno matriculado")
    	}
    }
}

fun main() {
    
    val formacaoKotlin = Formacao("Formação Kotlin", ConteudoEducacionalFactory(), Nivel.BASICO)  
    formacaoKotlin.matricularTodos(UsuarioFactory())    
    formacaoKotlin.imprimeAlunosMatriculados()
    
    formacaoKotlin.matricular(Usuario("Jorge", 42, "jorge@gmail.com"))
    println()
    formacaoKotlin.imprimeAlunosMatriculados()
  
}
