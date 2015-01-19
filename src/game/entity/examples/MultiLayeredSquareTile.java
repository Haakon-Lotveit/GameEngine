package game.entity.examples;

import java.awt.Graphics;

import game.entity.types.specifics.Tile;

public class MultiLayeredSquareTile implements Tile {
	final private int xTile, yTile;
	final private boolean deadly;
	final private Tile[] tiles;
	
	
	public MultiLayeredSquareTile(int xTile, int yTile, Tile...tiles) {
		this.xTile = xTile;
		this.yTile = yTile;
		this.tiles = tiles;
		
		boolean deadly = false;
		for(Tile tile : tiles){
			deadly |= tile.isDeadly();
		}
		this.deadly = deadly;
		
		setOffset(0, 0);
	}
	
	@Override
	public int getXTilePosition() {
		return xTile;
	}

	@Override
	public int getYTilePosition() {
		return yTile;
	}

	@Override
	public boolean isDeadly() {
		return deadly;
	}

	@Override
	public void render(Graphics gfx) {
		for(int i = 0; i < tiles.length; ++i){
			tiles[i].render(gfx);
		}
	}

	@Override
	public void setOffset(int x, int y) {
		for(Tile tile : tiles){
			tile.setOffset(x, y);
		}
	}

}
