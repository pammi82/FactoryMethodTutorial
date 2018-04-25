package factory

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

object ShapeFactory {

    def apply(arg:String): Shape ={
      arg.toLowerCase match
      {
        case "rectangle" => new Rectangle()

        case "triangle" => new Triangle()

        case "square" => new Square()

        case _ => null

      }
    }




}


object Main extends App {

  val rectangle = ShapeFactory("Rectangle")  // Instantiate the object of class Rectangle

  rectangle.draw // call to class Rectangle draw method

  val triangle = ShapeFactory("triangle")  // Instantiate the object of class Triangle

  triangle.draw // call to class triangle draw method

  ShapeFactory("square").draw // Instantiate the object of class Square anc call to draw method of it


}