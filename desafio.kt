enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }
enum class Metodologia { CURSO, DESAFIO_DE_PROJETO, DESAFIO_DE_CODIGO, MENTORIA}


class Usuario (val nome: String, val matricula: Int)


data class ConteudoEducacional(
    	val nome: String, 
    	val duracao: Int? = 120, 
        val nivel: Nivel? = Nivel.BASICO, 
        val metodologia: Metodologia = Metodologia.CURSO){
    
    fun getMetodologia(): String{
        when (metodologia) {
    		Metodologia.CURSO -> return "📘 Curso"
    		Metodologia.DESAFIO_DE_PROJETO -> return "🛠️ Desafio de Projeto"
    		Metodologia.DESAFIO_DE_CODIGO -> return "💻 Desafio de Código"
    		Metodologia.MENTORIA -> return "🎞️ Mentoria (Live)"
		}
    }
    
    fun getNivel(): String{
        when (nivel) {
    		Nivel.BASICO -> return "🟢 Básico       "
    		Nivel.INTERMEDIARIO -> 	return "🟡 Intermediário"
    		Nivel.AVANCADO -> return "🔴 Avançado     "
            else -> return ""
		}
    }
  
    fun getDuracao() = if(duracao != null) "🕑 ${duracao/60} hrs" else ""
    
    override fun toString()= "    | ${getMetodologia()}\n  ->| $nome\n    | ${getNivel()}\t${getDuracao()}\n"
}


data class TrilhaEducacional(val titulo: String, val conteudos: List<ConteudoEducacional>){
    override fun toString(): String{
        var output = "> $titulo\t\t${conteudos.size} atividades\n"
        for(conteudo in conteudos){
			output += "${conteudo.toString()}\n"
        }
        return output
    }
}


data class Formacao(
        val nome: String, 
        val trilhas: List<TrilhaEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("O estudante ${usuario.nome} foi matriculado com sucesso.")
    }
    
    override fun toString(): String{
        var output = "$nome\n"
        for(trilha in trilhas){
			output += "${trilha.toString()}\n"
        }
        return output
    }
}


fun main() {
    val trilha1 = TrilhaEducacional("Prepare-se Para a Jornada (Onboarding)", listOf(
    	ConteudoEducacional("Bootcamps DIO: Educação Gratuita e Empregabilidade Juntas!"),
    	ConteudoEducacional("Aula Inaugural - Santander Bootcamps 2023", null, null, Metodologia.MENTORIA),
    ))
    
    val trilha2 = TrilhaEducacional("Princípios de Desenvolvimento de Software", listOf(
    	ConteudoEducacional("Organizando seus Estudos com os Roadmaps DIO e o Notion"),
    	ConteudoEducacional("Versionamento de Código com Git e GitHub"),
        ConteudoEducacional("Desafios de Projetos: Crie Um Portfólio Vencedor", duracao=60),
        ConteudoEducacional("Contribuindo em um Projeto Open Source no GitHub", duracao=60, metodologia = Metodologia.DESAFIO_DE_PROJETO),
    ))
    
    val trilha3 = TrilhaEducacional("Conhecendo a Lingagem de Programação Kotlin", listOf(
    	ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial", 60),
        ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin"),
        ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin"),
        ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin"),
        ConteudoEducacional("O Poder das Funções em Kotlin"),
        ConteudoEducacional("Tratamento de Exceções em Kotlin", nivel=Nivel.INTERMEDIARIO),
        ConteudoEducacional("Abstraindo Formações da DIO Usando Orientação a Objetos com Kotlin", metodologia = Metodologia.DESAFIO_DE_PROJETO)
    ))
    
    val trilha4 = TrilhaEducacional("Resolvendo Seus Primeiros Desafios de Código", listOf(
    	ConteudoEducacional("Desafios de Código: Aperfeiçoe Sua Lógica e Pensamento Computacional", 60),
        ConteudoEducacional("Desafios Kotlin: Equilibrando Saldo", 60, metodologia = Metodologia.DESAFIO_DE_CODIGO),
        ConteudoEducacional("Desafios Kotlin: Organizando Seus Ativos", 60, metodologia = Metodologia.DESAFIO_DE_CODIGO),
        ConteudoEducacional("Desafios Kotlin: Condicionalmente Rico", 60, metodologia = Metodologia.DESAFIO_DE_CODIGO),
        ConteudoEducacional("Desafios Kotlin: Juros Compostos", 60, metodologia = Metodologia.DESAFIO_DE_CODIGO),
        ConteudoEducacional("Desafios Kotlin: Juros Compostos", 60, metodologia = Metodologia.DESAFIO_DE_CODIGO)
    ))
    
    val trilha5 = TrilhaEducacional("Introdução ao Desenvolvimento Mobile com Kotlin", listOf(
    	ConteudoEducacional("Visão Geral do Mercado de Desenvolvimento Mobile", duracao=60),
    	ConteudoEducacional("Instalando e Configurando o Android Studio"),
    	ConteudoEducacional("Entendendo a Estrutura e Depurando Apps Android"),
    	ConteudoEducacional("Criando um App Android com Suporte a Vários Idiomas", metodologia = Metodologia.DESAFIO_DE_PROJETO),
    	ConteudoEducacional("Princípios de Interface de Usuário e Layouts Android", nivel=Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Manipulando Entradas do Usuário em Apps Android", nivel=Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Fundamentos de Multiscreen em Apps Android", 180, nivel=Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Noções Básicas de Rede em Apps Android com Kotlin", nivel=Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Armazenamento de Dados Essencial em Apps Android com Kotlin", 180, nivel=Nivel.INTERMEDIARIO),
    	ConteudoEducacional("Criando um App Android para Compartilhar seu Portfólio de Projetos", nivel=Nivel.INTERMEDIARIO, metodologia = Metodologia.DESAFIO_DE_PROJETO)
    ))
    
    val trilha6 = TrilhaEducacional("Praticando Sua Abstraçao no Domínio Bancário", listOf(
    	ConteudoEducacional("Desafios Kotlin: Abrindo Contas", 60, nivel=Nivel.INTERMEDIARIO, metodologia = Metodologia.DESAFIO_DE_CODIGO),
    	ConteudoEducacional("Desafios Kotlin: Herança Bancária", 60, nivel=Nivel.INTERMEDIARIO, metodologia = Metodologia.DESAFIO_DE_CODIGO),
    	ConteudoEducacional("Desafios Kotlin: Cofres Seguros", 60, nivel=Nivel.INTERMEDIARIO, metodologia = Metodologia.DESAFIO_DE_CODIGO),
    	ConteudoEducacional("Desafios Kotlin: Reunião de Acionistas", 60, metodologia = Metodologia.DESAFIO_DE_CODIGO),
    	ConteudoEducacional("Desafios Kotlin: A Última Transação", 60, nivel=Nivel.INTERMEDIARIO, metodologia = Metodologia.DESAFIO_DE_CODIGO)
    ))
    
    val trilha7 = TrilhaEducacional("Ganhando PRodutividade com o Android JEtpack", listOf(
    	ConteudoEducacional("Visão Geral Sobre o Android Jetpack", nivel=Nivel.AVANCADO),
    	ConteudoEducacional("Explorando Componentes do Material Design em Apps Android", 180, nivel=Nivel.AVANCADO),
    	ConteudoEducacional("Gerenciando o Fluxo de Navegação de Apps Android", nivel=Nivel.AVANCADO),
    	ConteudoEducacional("Ciclo de Vida Android ViewModel, LiveData e Coroutines", 240, nivel=Nivel.AVANCADO),
    	ConteudoEducacional("Simplificando a Persistência de Dados no Android com Room", 180, nivel=Nivel.AVANCADO),
    	ConteudoEducacional("Programação em Segundo Plano no Android com WorkManager", nivel=Nivel.AVANCADO),
    	ConteudoEducacional("Injeção de Dependências no Android com Hilt", nivel=Nivel.AVANCADO),
    	ConteudoEducacional("Interfaces de Usuário Dinâmicas no Android com Jetpack Compose", nivel=Nivel.AVANCADO, metodologia = Metodologia.DESAFIO_DE_PROJETO),
    	ConteudoEducacional("Explore o Android Jetpack Para Não Perder Nenhum Jogo do Brasil na Copa", 240),
    	ConteudoEducacional("Avalie este Bootcamp")
    ))
    
    
    val formacaoKotlin = Formacao("Santander Bootcamp 2023 -  Mobile Android com Kotlin", mutableListOf(
        trilha1,
        trilha2,
        trilha3,
        trilha4,
        trilha5,
        trilha6,
        trilha7
    ))
    
    println(formacaoKotlin)
    formacaoKotlin.matricular(Usuario("João", 2023001))
    formacaoKotlin.matricular(Usuario("Maria", 2023002))
    formacaoKotlin.matricular(Usuario("Ana", 2023003))
}