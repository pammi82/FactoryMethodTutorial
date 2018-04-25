package abstractfactory

import scala.Console
trait Color {

  def fill

}


class Red extends Color{

  override def fill: Unit = println(Console.RED + "Inside Red::fill method \n")
}

class Blue extends Color{


  override def fill: Unit = println(Console.BLUE + "Inside Blue::fill method \n")


}

class Yellow extends Color{

  override def fill: Unit = println(Console.YELLOW + "Inside Yellow:: fill method \n")

}




trait Shape{
  def draw

}



class Rectangle extends Shape{


  override def draw: Unit = {
    println("Inside Rectangle :: Draw Method")
    var i = 0
    while (i <=7) {println("*"*30); i= i+1}

    println()
  }


}

class Square extends Shape{

  //Console.YELLOW

  override def draw: Unit= {
    println("Inside Square :: Draw Method")
    var i = 0
    while (i <=7) {println("*"*20); i= i+1}
    println()
  }

}




class Triangle extends  Shape{

  override def draw: Unit = {
    println("Inside Traingle :: Draw Method")
    var i:Int  = 1
    while(i <= 20){
      val pad : Int= (20-i)/2
      println("".padTo(pad," ").mkString("")+"*"*i)
      i = i+2


    }
    println()
  }
}



abstract class AbstractFactory{

  def getColor(color:String) :Color

  def getShape(shape : String): Shape
}


class ShapeFactory extends  AbstractFactory{


  override def getColor(color: String): Color = null


  override def getShape(shape: String): Shape = {

    shape.toLowerCase match
    {
      case "rectangle" => new Rectangle()

      case "triangle" => new Triangle()

      case "square" => new Square()

      case _ => null

    }

  }
}

class ColorFactory extends AbstractFactory{


  override def getShape(color: String): Shape = null


  override def getColor(color: String): Color = {

    color.toLowerCase match {

      case "red" => new Red()

      case "blue" => new Blue()

      case "yellow" => new Yellow()

      case _ => null

    }

  }
}


object FactoryProducer {

  def apply(choice: String): AbstractFactory = {

    choice.toLowerCase match {

      case "shape" => new ShapeFactory

      case "color" => new ColorFactory

      case _ => null

    }

  }
}



object AbstractFactoryDemo extends  App{

  val shapefactory = FactoryProducer("shape") // Instantiate the object of Class ShapeFactory

  val colorfactory = FactoryProducer("color") // Instantiate the object of Class ColorFactory



  shapefactory.getShape("triangle").draw // Instantiate the object of Class triangle and call to draw method of the class

  colorfactory.getColor("red").fill //Instantiate the object of Class Red and call to fill method of the class

  shapefactory.getShape("rectangle").draw // Instantiate the object of Class triangle and call to draw method of the class

  colorfactory.getColor("yellow").fill //Instantiate the object of Class yellow and call to fill method of the class

  shapefactory.getShape("Square").draw // Instantiate the object of Class Square and call to draw method of the class

  colorfactory.getColor("blue").fill //Instantiate the object of Class blue  and call to fill method of the class

  shapefactory.getShape("triangle").draw // Instantiate the object of Class triangle and call to draw method of the class





}