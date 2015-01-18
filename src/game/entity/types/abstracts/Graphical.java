package game.entity.types.abstracts;

import java.awt.Graphics;

/**
 * A graphical object is any object that can render itself.
 * Most every object should either be a Renderable or a Paintable instead,
 * to make your intent clear.
 * 
 * However, this notion might be utterly silly for your needs, and I'm not judging you (out loud at any rate).
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Graphical {
	/**
	 * The entity is in fact responsible for painting/rendering itself.
	 * The graphics-engine is in fact just grabbing a paintbrush,
	 * and then running all around to every single thing that's supposed to be painted, handing it the paintbrush,
	 * and saying "GO AT IT BRO!". 
	 * It's not a very smart graphics engine, but it's kind-hearted, loyal and hard working.
	 * 
	 * @param gfx The graphics object used for painting. If you give it a 2DGraphics object, you get hardware rendering.
	 */
	public void render(Graphics gfx);
	
	public void setOffset(int x, int y);
	
}
