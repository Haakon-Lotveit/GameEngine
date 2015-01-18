package game.entity.types.abstracts;

/**
 * A Geographic entity is any entity with X and Y coordinates in the tile world.
 * It doesn't have to be tickable (consider a movable block, or a pick-up, or something else), or paintable.
 * However, all things paintable are also Geographic, since the system needs to know where to paint it.
 * 
 * Note that in this system (0,0) is the top-left corner of the map.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Geographic {
	/**
	 * Gets the top horizontal position of the entity
	 * @return a non-negative number (0 and upwards)
	 */
	public int getXTilePosition();
	/**
	 * Gets the vertical position of the entity
	 * @return a non-negative number (0 and upwards)
	 */
	public int getYTilePosition();
	
	/**
	 * This tells you if the entity is deadly or not.
	 * @return true if it kills you, false if it's not.
	 */
	public boolean isDeadly();
}
