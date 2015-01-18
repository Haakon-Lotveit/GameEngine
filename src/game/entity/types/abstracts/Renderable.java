package game.entity.types.abstracts;

/**
 * A renderable is anything that is supposed to be rendered. 
 * This includes the level itself, but not directly the entities on that level.
 * For those, use Paintable. The renderer can have responsibilities for other Renderables and Paintables itself.
 * 
 * Even though Paintable is mostly the same, it's a good idea to keep things separate to have a clearer idea of what is what.
 * We call this "Using the type system to help you", 
 * kinda like those two massive chinese coins Mulan used to climb to the top of that pole in the Disney movie.
 * 
 * As a rule of thumb, Paintables are given their paintbrushes from renderables.
 * A gratuitous example would be a level (Renderable) giving the monsters (Paintable)
 *  on that level a paintbrush to paint themselves.
 *  
 * Also note that while most of the things you'll be telling it to take care of are likely to be paintable,
 * there's nothing (except sanity, good taste and common sense) stopping you from arbitrarily nest Renderables within each-other.
 * If that's what you need to do, go for it.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Renderable extends Graphical {
	/**
	 * This sets the graphical entities that this Renderable needs to take care of.
	 * The order of the entities matter. Lower indices gets painted before higher ones.
	 * @param entities all the things that this Renderable should paint.
	 */
	public void setGraphicals(Graphical... entities);
	
	/**
	 * Grabs you all of the graphical entities that this Renderable is taking care of.
	 * Note that you are not guaranteed to get an array that is safe to manipulate.
	 * You can in fact get a reference to the array that is currently being used.
	 * But that is not guaranteed either. Implementors are free to chose,
	 * and you must check their documentation to be certain.
	 * 
	 * However, there is a guarantee that the order will be correct.
	 * 
	 * @return an array representing all the entities this Renderable is taking care of.
	 */
	public Graphical[] getGraphicals();

}
