package at.ac.tuwien.big.leveldesign.ui.nodes;

import at.ac.tuwien.big.leveldesign.levelDesign.Room;
import de.fxdiagram.annotations.properties.ModelNode;
import de.fxdiagram.core.XRoot;
import de.fxdiagram.core.extensions.CoreExtensions;
import de.fxdiagram.core.model.ModelElementImpl;
import de.fxdiagram.core.model.ToString;
import de.fxdiagram.mapping.IMappedElementDescriptor;
import de.fxdiagram.mapping.shapes.BaseDiagram;

@ModelNode
@SuppressWarnings("all")
public class Room3DDiagram extends BaseDiagram<Room> {
  public Room3DDiagram(final IMappedElementDescriptor<Room> descriptor) {
    super(descriptor);
  }
  
  @Override
  public void doActivate() {
    super.doActivate();
    XRoot _root = CoreExtensions.getRoot(this);
    _root.setCurrentTool(null);
  }
  
  /**
   * Automatically generated by @ModelNode. Needed for deserialization.
   */
  public Room3DDiagram() {
  }
  
  public void populate(final ModelElementImpl modelElement) {
    super.populate(modelElement);
  }
  
  public String toString() {
    return ToString.toString(this);
  }
}
