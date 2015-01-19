package game.entity.examples;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.entity.types.specifics.Tile;

public class AnimatedTile implements Tile {
	private int xTile, yTile;
	private int framesBeforeChanging;
	private int currentFrame, framecounter;
	private int tilesize;
	private boolean deadly;
	BufferedImage[] graphics;
	
	private int xPixel, yPixel;
	
	public AnimatedTile(int xTile, int yTile, int framesBeforeChanging, BufferedImage[] graphics, int tilesize, boolean deadly) {
		this.xTile = xTile;
		this.yTile = yTile;
		this.framesBeforeChanging = framesBeforeChanging;
		this.tilesize = tilesize;
		this.graphics = graphics;
		currentFrame = 0;
		framecounter = 0;
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
		BufferedImage image = graphics[currentFrame];
		gfx.drawImage(image, xPixel, yPixel, tilesize, tilesize, null);
		if(0 == ++framecounter % framesBeforeChanging) {
			currentFrame = (1 + currentFrame) % graphics.length;
		}
	}

	@Override
	public void setOffset(int x, int y) {
		this.xPixel = xTile * tilesize + x;
		this.yPixel = yTile * tilesize + y;
	}

}
