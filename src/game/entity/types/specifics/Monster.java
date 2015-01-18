package game.entity.types.specifics;

import game.entity.types.abstracts.Creature;

public interface Monster extends Creature {
	/**
	 * This kills the monster, which stops it from being on the level, doing things, and being painted.
	 * It does not remove it from the level though, so it can be reset later.
	 */
	public void die();
	
	/**
	 * Resets the monster as it was at the beginning of the level.
	 */
	public void reset();
	
}
