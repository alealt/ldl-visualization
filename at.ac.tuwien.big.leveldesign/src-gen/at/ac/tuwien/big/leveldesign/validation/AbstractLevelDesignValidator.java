/*
 * generated by Xtext 2.10.0
 */
package at.ac.tuwien.big.leveldesign.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractLevelDesignValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(at.ac.tuwien.big.leveldesign.levelDesign.LevelDesignPackage.eINSTANCE);
		return result;
	}
	
}