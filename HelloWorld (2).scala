object Calculadora {
  private var valor: Double = 0

  def reset(): Unit = valor = 0

  def soma(n: Double): Calculadora.type = {
    valor += n
    this
  }

  def subtracao(n: Double): Calculadora.type = {
    valor -= n
    this
  }

  def multiplicacao(n: Double): Calculadora.type = {
    valor *= n
    this
  }

  def divisao(n: Double): Calculadora.type = {
    valor /= n
    this
  }

  override def toString: String = s"Resultado: $valor"
}

object HelloWorld {
  def main(args: Array[String]): Unit = {
    Calculadora.reset() // importante para reusar
    println(
      Calculadora
        .soma(2)
        .soma(1)
        .subtracao(1)
        .divisao(2)
    ) // Resultado: 1.0
  }
}
