package game.graphics;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import game.entity.examples.DumbRenderer;
import game.entity.examples.StaticImage;
import game.entity.types.abstracts.Renderable;
import game.resource.loader.SquareSpriteLoader;

import java.awt.Dimension;
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
		
		/* get us a thing to render */
		StaticImage si = new StaticImage(loader.getImage(0, 0));
		
		/* We need to put it in a container for the canvas to accept it. */
		Renderable container = new DumbRenderer();
		container.setGraphicals(si);
		
		gw.gc.addRenderingTarget(container);
		 
		try {
			Thread.sleep(1500);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		container.setOffset(50,50);
		
		try {
			Thread.sleep(1500);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		si.setPosition(400, 80);
		
		try {
			Thread.sleep(1500);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		
		si.setPosition(0, 0);
		
		System.out.println(container);
		System.out.println(si);
		
		gw.gc.removeAllRenderingTargets();
		
	}
}
