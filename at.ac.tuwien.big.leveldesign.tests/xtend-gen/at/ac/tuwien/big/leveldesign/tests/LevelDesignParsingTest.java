/**
 * generated by Xtext 2.9.2
 */
package at.ac.tuwien.big.leveldesign.tests;

import at.ac.tuwien.big.leveldesign.levelDesign.Level;
import at.ac.tuwien.big.leveldesign.tests.LevelDesignInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(LevelDesignInjectorProvider.class)
@SuppressWarnings("all")
public class LevelDesignParsingTest {
  @Inject
  private ParseHelper<Level> parseHelper;
  
  @Test
  public void loadModel() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Hello Xtext!");
      _builder.newLine();
      final Level result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}