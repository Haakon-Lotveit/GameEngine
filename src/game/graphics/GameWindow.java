package game.graphics;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import game.entity.examples.AnimatedTile;
import game.entity.examples.DumbRenderer;
import game.entity.examples.FlatStaticLevel;
import game.entity.examples.StaticImage;
import game.entity.examples.StaticSquareTile;
import game.entity.types.abstracts.Renderable;
import game.resource.loader.SquareSpriteLoader;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * The gamewindow provides you with a window of a certain size with a canvas that can be painted on.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public class GameWindow {
	private JFrame window;
	private GameCanvas gc;
	
	/**
	 * Creates a new game-window.
	 * 
	 * @param title the title on the top of the window.
	 * @param size the size of the canvas. NOT the size of the window.
	 */
	public GameWindow(String title, Dimension size){
		window = new JFrame(title);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setSize(0, 0);

		gc = new GameCanvas(size, window);
		
		window.pack();
		window.setVisible(true);
	}
	
	public GameCanvas getCanvas() {
		return gc;
	}
	
	public static void main(String[] args) throws IOException {
		/* Sets up the basic environment */
		GameWindow gw = new GameWindow("Simple test", new Dimension(800, 600));
		
		/* starts the strong independent painting thread that don't need no main */
		gw.gc.start();
		
		/* Declares the file where the image we're gonna use is on. */
		File image = new File("res/art/tiles/basic-tiles.png");
		
		/* Get us a spriteloader to load it for us. */
		SquareSpriteLoader loader = new SquareSpriteLoader(image, 64);
		
		BufferedImage[] graffix = new BufferedImage[4];
		for(int i = 0; i < graffix.length; ++i) {
			graffix[i] = loader.getImage(i, 0);
		}
		
		AnimatedTile at = new AnimatedTile(0, 0, 15, graffix, 64);
		Renderable atHolder = new DumbRenderer();
		atHolder.setGraphicals(at);
		atHolder.setOffset(20, 20);
		gw.gc.addRenderingTarget(atHolder);
	}
}
