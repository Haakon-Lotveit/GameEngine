package game.graphics;

import game.entity.types.abstracts.Renderable;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class GameCanvas {
	private Canvas canvas;
	private List<Renderable> targets;
	private PaintingThread thread;
	
	private void init() {
		canvas = new Canvas();
		targets = new ArrayList<>(8);
		thread = null;
	}
	
	public void start(){
		if(null != thread){
			thread.interrupt();
		}
		thread = new PaintingThread(this);
	}
	
	public void stop() {
		if(null != thread){
			thread.interrupt();
		}
		thread = null;
	}
	public GameCanvas(){
		init();
	}
	
	public GameCanvas(Dimension size, JFrame window) {
		init();
		canvas.setSize(size);
		window.add(canvas);
	}

	public void setSize(Dimension size) {
		canvas.setSize(size);
	}

	/**
	 * We never really want to call this method.
	 * It signals that we really want to use the canvas and not the abstraction.
	 * Instead, consider adding a specialized method.
	 * @return the canvas we're using.
	 */
	public Canvas getCanvas() {
		System.err.println("[DEBUG] We're using getCanvas()!");
		return canvas;
	}

	/**
	 * This adds the canvas to the given JFrame.
	 * You can (but that doesn't mean should) add it to more than one JFrame.
	 * I have no idea what happens if you do that.
	 * @param window the JFrame you want to add this to.
	 */
	public void addToFrame(JFrame window) {
		window.add(canvas);
	}

	public void render() {

		BufferStrategy bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(2); // If there is no bufferstrategy (which there shouldn't be at start-up) create one, and don't render anymore this frame.
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
//		RENDER HERE
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		for(Renderable picasso : targets) {
			picasso.render(g);
		}
		
//		END RENDER
		g.dispose();
		bs.show();
		
		}

	/**
	 * Adds the target to the rendering targets list.
	 * Do note that these rendering targets are assumed to all be independent of each other.
	 * If you have several renderables you need to paint in a specific order,
	 * consider putting them in a renderable to hold them.
	 * 
	 * @param target
	 */
	public void addRenderingTarget(Renderable target) {
		if(null == target) {			
			throw new NullPointerException();
		}
		targets.add(target);
	}
}
