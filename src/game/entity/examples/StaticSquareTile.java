package game.entity.examples;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.entity.types.specifics.Tile;

public class StaticSquareTile implements Tile {
	private final BufferedImage image;
	private final int xTile, yTile, tileSize;
	private int xPixel, yPixel, offsetX, offsetY;
	
	public StaticSquareTile(BufferedImage image, int xTile, int yTile, int tileSize) {
		this.image = image;
		this.xTile = xTile;
		this.yTile = yTile;
		this.tileSize = tileSize;
		setOffset(0, 0);
		
		updateDrawingPositions();
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
		return false;
	}

	@Override
	public void render(Graphics gfx) {
		gfx.drawImage(image, xPixel, yPixel, image.getWidth(), image.getHeight(), null);
	}

	@Override
	public void setOffset(int x, int y) {
		this.offsetX = x;
		this.offsetY = y;
		updateDrawingPositions();
	}

	private void updateDrawingPositions() {
		xPixel = xTile * tileSize + offsetX;
		yPixel = yTile * tileSize + offsetY;
	}
}
