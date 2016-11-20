package at.ac.tuwien.big.leveldesign.ui.interpreter;

import java.util.List;

/**
 * Created by alexander on 27/06/16.
 */
public interface Interpreter {

    /**
     * Interpret model and calculate actions if necessary
     */
    void process();

    /**
     * Get next actions which should be executed in parallel
     */
    List<Action> nextActions();
}
