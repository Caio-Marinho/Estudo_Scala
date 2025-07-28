class Calculadora(val valor: Double) {
  def soma(n: Double): Calculadora = new Calculadora(valor + n)
  def subtracao(n: Double): Calculadora = new Calculadora(valor - n)
  def multiplicacao(n: Double): Calculadora = new Calculadora(valor * n)
  def divisao(n: Int): Calculadora = new Calculadora(valor/n)

  override def toString: String = s"Resultado: $valor"
}

object Calculadora {
  def apply(): Calculadora = new Calculadora(0)
}

object HelloWorld {
	def main(args: Array[String]): Unit = {
	println(Calculadora().soma(2).soma(1).subtracao(1).divisao(2))
	}
}