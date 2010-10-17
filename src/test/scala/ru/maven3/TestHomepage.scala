package ru.maven3

import org.apache.wicket.util.tester.WicketTester
import org.junit.Before
import org.junit.Test

class TestHomepage{

	var tester = new WicketTester(new LegUp())
	
	@Before
	def setup(){
		tester = new WicketTester(new LegUp())
		tester.startPage(classOf[HomePage])
	}
	
	@Test
	def testRenders(){
		tester.assertRenderedPage(classOf[HomePage])
	}
	
	@Test
	def testSubmit(){
		val formTester = tester.newFormTester("form")
		formTester.setValue("nameField", "Howdy")
		formTester.submit()
		
		tester.assertLabel("form:nameLabel", "Howdy")
	}

}