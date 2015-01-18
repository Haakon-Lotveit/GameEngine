package game.entity.examples;

import game.entity.types.abstracts.Graphical;
import game.entity.types.abstracts.Renderable;

import java.awt.Graphics;

public class DumbRenderer implements Renderable {
	private final static Graphical[] EMPTY = new Graphical[0];
	
	private Graphical[] entities;
	private int offsetX, offsetY;
	
	public DumbRenderer() {
		entities = EMPTY;
		offsetX = offsetY = 0;
	}
	
	@Override
	public void render(Graphics gfx) {
		for(Graphical entity : entities) {
			entity.render(gfx);
		}
	}

	@Override
	public void setGraphicals(Graphical... entities) {
		this.entities = entities;
		updateOffsets();
	}

	@Override
	public Graphical[] getGraphicals() {
		return entities;
	}

	private void updateOffsets() {
		for(Graphical entity : entities){
			entity.setOffset(offsetX, offsetY);
		}
	}

	@Override
	public void setOffset(int x, int y) {
		offsetX = x;
		offsetY = y;
		updateOffsets();
	}

	@Override
	public String toString() {
		return String.format("DumbRenderer with offset (%d,%d), and %d Graphicals", offsetX, offsetY, entities.length);
	}
}
