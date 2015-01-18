package game.entity.types.abstracts;

/**
 * A tickable entity is any entity that can do things.
 * To make it do things, override the tick method.
 * Do note that making it do things <i>every</i> tick will make it move pretty fast.
 * Therefore it can be wise to only do something every n tick.
 * Just because an entity is tickable does not mean that it has to be on the board.
 * For instance, you could create a tickable spawner that exists outside the board and spawns monsters at random locations.
 * 
 * An important note though, is that levels are meant to hand out ticks to all its tickable entities.
 * The ticking works approximately like this:
 * From a prioritized queue in the game engine, every entity is handed a tick.
 * When it's done with it, it hands it over to the next entity.
 * For the game engine, this queue consists of special entities and the current level.
 * The level will then hand out the ticks according to its rules.
 * Note that the monsters themselves belong on levels, and therefore the game engine knows nothing about them.
 * This is by design, and keeps the game engine simple and lets you bake in more fun things into the levels.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Tickable {
	/**
	 * This is the method that is to be executed every time the engine ticks.
	 */
	public void tick();
}
