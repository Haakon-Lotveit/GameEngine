package game.entity.types.specifics;

import game.entity.types.abstracts.Creature;
import game.entity.types.abstracts.Paintable;
import game.entity.types.abstracts.Tickable;

/**
 * This class represents a two-dimensional level with a 2D grid of movement.
 * The details are very up to you. You can for instance layer up tiles to make more complex stuff if that is your cup of tea.
 * You can also add layered effects on top and what not. 
 * It's all up to you, which means that you have to keep the order of drawing in mind.
 * 
 * A square tile-based implementation comes with the engine as an example.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Level {
	/**
	 * Can you legally go in a given tile
	 * If the tile is out of bounds, the answer is no.
	 * If the tile is not walkable, the answer is no.
	 * While walkable(-1,-1) is a legal call, the answer is always no.
	 * You are allowed to walk on top of a monster or an item, and that may trigger some consequence.
	 * 
	 * @param column 0-n, where lower numbers are more to the left.
	 * @param row 0-n, where lower numbers are further up.
	 * @return true if you can legally go there, false if not.
	 */
	public boolean walkable(int column, int row);
	
	/**
	 * Gives you the tile at the map.
	 * @param column The column of the map. 0 is leftmost.
	 * @param row The row of the map. 0 is topmost.
	 * @return the Tile that you're standing on.
	 */
	public Tile tileAt(int column, int row);
	/**
	 * Used to figure out how big the level is.
	 * @return How many tiles wide a level is.
	 */
	public int numColumns();
	/**
	 * USed to figure out how big the level is.
	 * @return How many tiles tall a level is.
	 */
	public int numRows();
	/**
	 * Used to ask about starting position.
	 * In the case of multiple players, this returns the answer for player 1.
	 * @return the column the player is starting on.
	 */
	public int startingColumn();
	/**
	 * Used to ask about starting position.
     * In the case of multiple players, this returns the answer for player 1.
	 * @return the row the player is starting on.
	 */
	public int startingRow();
	/**
	 * Adds a paintable entity to the level.
	 * Entities added this way will be painted, but will not be ticked. 
	 * @param entity
	 */
	public void add(Paintable entity);
	
	/**
	 * Adds a tickable entity to this level.
	 * Entities added this way will not be painted, but will be ticked.
	 * @param entity
	 */
	public void add(Tickable entity);
	
	/**
	 * Adds a creature entity to this level.
	 * Entities added this way will be painted, and will be ticked.
	 * @param entity
	 */
	public void add(Creature entity);
}
