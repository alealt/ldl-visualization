/**
 * generated by Xtext 2.9.2
 */
package at.ac.tuwien.big.leveldesign;

import at.ac.tuwien.big.leveldesign.LevelDesignStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class LevelDesignStandaloneSetup extends LevelDesignStandaloneSetupGenerated {
  public static void doSetup() {
    LevelDesignStandaloneSetup _levelDesignStandaloneSetup = new LevelDesignStandaloneSetup();
    _levelDesignStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
