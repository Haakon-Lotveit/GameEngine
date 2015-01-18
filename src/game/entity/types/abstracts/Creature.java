package game.entity.types.abstracts;


public interface Creature extends Paintable, Tickable {
	/**
	 * Asks if this creature will kill the player if it touches him
	 * @return true if it does, false if it doesn't.
	 */
	public boolean deadly();

}
