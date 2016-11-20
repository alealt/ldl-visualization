/*
 * generated by Xtext 2.9.2
 */
package at.ac.tuwien.big.leveldesign.tests

import at.ac.tuwien.big.leveldesign.levelDesign.Level
import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(LevelDesignInjectorProvider)
class LevelDesignParsingTest{

	@Inject
	ParseHelper<Level> parseHelper;

	@Test 
	def void loadModel() {
		val result = parseHelper.parse('''
			Hello Xtext!
		''')
		Assert.assertNotNull(result)
	}

}
