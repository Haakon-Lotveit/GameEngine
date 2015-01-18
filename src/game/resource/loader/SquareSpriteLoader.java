package game.resource.loader;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Loads a square spritesheet into memory.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public class SquareSpriteLoader {
	
	protected final BufferedImage SHEET;
	protected final int TILESIZE;
	
	/**
	 * This creates a new SpriteLoader for efficient buffering of sprites.
	 * 
	 * @param spriteSheet a bitmap of some kind. Preferably .png, as other formats are untested. (But might work! Might!)
	 * @param tilesize how big a sprite is. All sprites are considered to be squares in this loader, so 32 means a 32×32 pixel sprite.
	 * @throws IOException If the sprite cannot be loaded. You're probably in big trouble at that point, and might need to go debugging.
	 */
	public SquareSpriteLoader(File spriteSheet, int tilesize) throws IOException{
		this.SHEET = ImageIO.read(spriteSheet);
		this.TILESIZE = tilesize;
	}
	
	/**
	 * Retrieves a sprite from the sheet based on column and rows.
	 * There is no error-checking going on here. 
	 * @param xPos which column you want, from 0..(n-1), where n is the number of columns.
	 * @param yPos which row you want, from 0..(n-1), where n is the number of rows.
	 * @return the sprite, given that it exists.
	 */
	public BufferedImage getImage(int xPos, int yPos) {
		return SHEET.getSubimage(xPos * TILESIZE, yPos * TILESIZE, TILESIZE, TILESIZE);
	}
	
	/**
	 * Lar dere sakse ut et bilde fra arket fra hvilke som helst koordinater, med den størrelsen dere selv vil ha.
	 * For eksempel kan dere be om et bilde som er fra (0,0) til (64,64) ved å be om 
	 * getImage(0,0 new Dimension(64,64));
	 * Det er anbefalt at dere holder dere til den enklere getImage-metoden til normal bruk.
	 * Heller ikke her er det noen sjekk om at dere gir korrekte opplysninger.
	 * 
	 * @param xPos Hvilken horizontal piksel (den lengst til venstre er 0) du vil begynne på
	 * @param yPos Hvilken vertikal piksel (den lengst oppe er 0) du vil begynne på
	 * @param size Størrelsen på bildet.
	 * @return bildet kopiert ut fra arket, gitt at parametrene gir mening.
	 */
	public BufferedImage getImage(int xPos, int yPos, Dimension size){
		return SHEET.getSubimage(xPos, yPos, size.width, size.height);
	}
	
	/**
	 * Tells you the number of columns in the spritesheet.
	 * @return the number of columns. Note: Not the number of pixels!
	 */
	public int numColumns(){
		return SHEET.getWidth() / TILESIZE;
	}
	
	/**
	 * Tells you the number of rows in the spritesheet.
	 * @return the number of rows. Note: Not the number of vertical pixels!
	 */
	public int numRows(){
		return SHEET.getHeight() / TILESIZE;
	}
	
	/**
	 * returns the size of a sprite.
	 * @return a number n, that represents the size of the n×n pixel sprite.
	 */
	public int tilesize(){
		return TILESIZE;
	}
	
	/**
	 * Returns the buffered image that's being used.
	 * @return the actual sprite sheet that's being used. NOT A COPY.
	 */
	public BufferedImage getSheet(){
		return SHEET;
	}
}
