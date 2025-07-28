// Classe base
class Pessoa(val nome: String)

// Subclasse Funcionario
class Funcionario(nome: String) extends Pessoa(nome)

// Subclasse Supervisor
class Supervisor(nome: String) extends Funcionario(nome)

// Main object com as funções dentro
object HelloWorld {

  // Função com limite superior (apenas Supervisor ou superiores)
  def registrarDados[P <: Supervisor](usuario: P): Unit = {
    println(s"${usuario.nome} pode registrar dados.")
  }

  // Função com limite inferior (apenas Supervisor ou inferiores)
  def aprovarPedido[P >: Supervisor](usuario: P): Unit = {
    usuario match {
      case s: Supervisor  => println(s"${s.nome} pode aprovar pedido.")
      case f: Funcionario => println(s"${f.nome} também pode aprovar pedido.")
      case p: Pessoa      => println(s"${p.nome} talvez não tenha permissão.")
      case _              => println("Usuário desconhecido.")
    }
  }

  def main(args: Array[String]): Unit = {
    val p = new Pessoa("Carlos")
    val f = new Funcionario("Julia")
    val s = new Supervisor("Rafael")
    println(p.nome) //carlos
    // Teste de registrar dados (apenas Supervisor ou superior)
    registrarDados(s)  // OK
    // registrarDados(f) // ERRO de compilação: f não é subtype de Supervisor

    // Teste de aprovar pedido (Supervisor ou inferior)
    aprovarPedido(s)  // OK
    aprovarPedido(f)  // OK
    aprovarPedido(p)  // OK (mas pode ser limitado na lógica)
  }
}
