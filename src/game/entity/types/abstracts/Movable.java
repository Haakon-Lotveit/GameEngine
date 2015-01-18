package game.entity.types.abstracts;

import game.geography.CompassDirection;
import game.geography.PersonalDirection;

/**
 * A movable entity is a geographic entity that can change its positions.
 * If you tell it to move, this charmingly rustic mind will go there. Even if it isn't allowed.
 * Unlike the graphics engine which is slightly disobedient, this interface's charm comes from its blind obedience.
 * "Go on top of that lava!", you say, and then it goes on top of that lava.
 * You have great power over these entities, and with it comes great responsibility.
 * The implementing objects may not know anything about its levels.
 * In that case asking them if they can go somewhere is going to be slightly tricky, and you shouldn't trust them.
 * Don't accuse them of lying though. Their answers merely reflect their philosophical approach to logical truth:
 * If a statement is undecidable, and yet you must give a binary answer, what do you say?
 * True, because there is nothing saying it is not so?
 * False, because there is nothing saying it is so?
 * or a random answer, to teach people to not ask silly questions?
 * 
 * If you want useful answers, make sure that the implementing classes knows about their levels,
 * so that they may find their true selves and their place in the universe.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Movable extends Geographic {
	
	/**
	 * Attempts to move the object to a specific place.
	 * There is no guarantee that the object will do something intelligent with this order.
	 * You could tell it to move to the fiery pits of Mordor and then it does just that.
	 * That would be a shame.
	 * 
	 * @param xPosition the column you want it to go to.
	 * @param yPosition the row you want it to go to.
	 * @return true if it moved there, false if it didn't.
	 */
	public boolean setPosition(int xPosition, int yPosition);
	
	/**
	 * Asks the object if it could legally move in a given direction 
	 * @param dir The direction you ask about.
	 * @return true if it can, false if not.
	 */
	public boolean canMove(CompassDirection dir);
	
	/**
	 * Attempts to move in a given direction.
	 * If it cannot move that way, it will just stand still,
	 * but is free to change the direction it's facing.
	 * @param dir the direction you want it to move.
	 */
	public void move(CompassDirection dir);
	
	/**
	 * Attempts to move in a given direction.
	 * If it cannot move that way, it will just stand still,
	 * but is free to change the direction it's facing.
	 * @param dir the direction you want it to move.
	 */
	public void move(PersonalDirection dir);
	
	/**
	 * Makes the object gaze soulfully in a given direction.
	 * @param dir where you want its gaze to wander.
	 */
	public void faceDirection(CompassDirection dir);
	
	/**
	 * Turns the entity the direction you specify.
	 * (If you specify up, then it will not change direction.)
	 * @param dir the direction you want it to face
	 */
	public void faceDirection(PersonalDirection dir);
}
