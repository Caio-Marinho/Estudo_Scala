import scala.io.StdIn.readLine

// Hierarquia base
abstract class Animal {
  def nome: String
  def som(): String
}

abstract class Pet extends Animal

class Gato extends Pet {
  override def nome: String = "Gato"
  override def som(): String = "Miau"
}

class Cachorro extends Pet {
  override def nome: String = "Cachorro"
  override def som(): String = "Au Au"
}

// Classe que usa limite superior no tipo P
class Jaula[P <: Pet](val pet: P) {
  def mostrarSom(): Unit = {
    println(s"O ${pet.nome} faz ${pet.som()}")
  }
}

object Main extends App {

  // Função que cria pet baseado na entrada (retorna Pet)
  def criarPet(tipo: String): Option[Pet] = tipo.toLowerCase match {
    case "gato" => Some(new Gato)
    case "cachorro" => Some(new Cachorro)
    case _ => None
  }

  println("Digite o tipo do animal (gato/cachorro):")
  val entrada = readLine()

  criarPet(entrada) match {
    case Some(pet) =>
      // Aqui usamos limite superior para garantir que só Pets entram na Jaula
      val jaula = new Jaula(pet)
      jaula.mostrarSom()
    case None =>
      println("Tipo inválido! Use 'gato' ou 'cachorro'.")
  }
}
