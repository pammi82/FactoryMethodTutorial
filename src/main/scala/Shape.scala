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

object ShapeFactory {

  def getShape(arg: String): Shape = {

    arg.toLowerCase match
      {
      case "rectangle" => new Rectangle()

      case "triangle" => new Triangle()

      case "square" => new Square()

      case _ => null

    }


  }



}