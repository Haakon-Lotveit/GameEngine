package game.entity.types.specifics;

import game.entity.types.abstracts.Geographic;
import game.entity.types.abstracts.Movable;
import game.entity.types.abstracts.Paintable;

/**
 * Represents a player.
 * Precisely how to control the player and what not is left to the implementors.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public interface Player extends Geographic, Movable, Paintable {

}
