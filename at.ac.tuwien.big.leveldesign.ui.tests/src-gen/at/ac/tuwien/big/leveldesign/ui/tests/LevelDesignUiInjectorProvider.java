/*
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.ui.tests;

import at.ac.tuwien.big.leveldesign.ui.internal.LeveldesignActivator;
import com.google.inject.Injector;
import org.eclipse.xtext.junit4.IInjectorProvider;

public class LevelDesignUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return LeveldesignActivator.getInstance().getInjector("at.ac.tuwien.big.leveldesign.LevelDesign");
	}

}
