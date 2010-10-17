package ru.maven3

import org.apache.wicket.protocol.http._
import org.apache.wicket.markup.html._
import org.apache.wicket.markup.html.form._
import org.apache.wicket.model.IModel
import org.apache.wicket.markup.html.basic.Label

class LegUp extends WebApplication {
  def getHomePage = classOf[HomePage]
}

class HomePage extends WebPage {
  var name = "Hello!"
  val form = new Form[String]("form")
  add(form)
  form.add(new TextField[String]("nameField", new ToySafeModel[String](name, {null; name = _})))
  form.add(new Label("nameLabel", new ToySafeModel[String](name , null)))
}

class ToySafeModel[T](accessor: => T, mutator: T => Unit) extends IModel[T]() {
  override def getObject() = accessor
  override def setObject(t: T) = mutator(t)
  override def detach() = Nil
}