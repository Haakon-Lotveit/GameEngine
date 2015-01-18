package game.entity.types.abstracts;


/**
 * A paintable entity is anything that you want drawn by the graphics engine.
 * Since the graphics-engine is rather simple and not too bright,
 * it needs to be told in no uncertain terms where to paint the entity.
 * (If such a system was not implemented, everything would be drawn in the top-left corner of the canvas,
 *  and that would look absolutely mortifying.)
 *  
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Paintable extends Geographic, Graphical {
	
}
