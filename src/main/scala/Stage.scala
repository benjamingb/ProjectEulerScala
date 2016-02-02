package main.scala

import main.scala.P001

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.event.ActionEvent

object Stage extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title.value = "Euler Problems"
    scene = new Scene(400, 200) {
      val label = new Label("Ingrese el Nmero de problema")
      label.layoutX = 20
      label.layoutY = 20

      val nroProblem = new TextField
      nroProblem.layoutX = 20
      nroProblem.layoutY = 50
      nroProblem.promptText = "Nro Problema"

      val button = new Button
      button.layoutX = 20
      button.layoutY = 80
      button.text = "Ejecutar"

      button.onAction = (e: ActionEvent) => {
        val nro = nroProblem.text.value
        getProblem(nro)

      }
      content = List(label, nroProblem, button)
    }
  }

  def getProblem(nro: String) = nro match {
    case _ if nro.matches("[+-]?\\d+") => {

      val answer = solutions.find(x => x._1 == nro.toInt)
      if (answer.isDefined) {
        println("Problem Nro " + nro + "\n")
        answer.get._2.zipWithIndex.foreach {
          case (e, i) => {
            println("Solution " + (i + 1));
            println("Answer: " + Util.time {
              e
            } + "\n");
          }
        }
      } else {
        println("Problema Nro " + nro + " Aún no definido");
      }
    }
    case _ => {
      println("Ingrese un nnúmero Valido")
    }
  }

  lazy val solutions = List(
    (1, List(
      P001.Solution1(3, 5, 1000).sumMultiple
      ,P001.Solution2(3, 5, 1000).sumMultiple
      ,P001.Solution3(3, 5, 1000).sumMultiple
      ,P001.Solution4(3, 5, 1000).sumMultiple
      )),
    (2, List(
      P002.Solution1(4000000).maxSumNums
      ,P002.Solution2(4000000).maxSumNums
      ,P002.Solution3(4000000).maxSumNums
    )))
}
