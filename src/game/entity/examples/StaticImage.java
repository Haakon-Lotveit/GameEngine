package game.entity.examples;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import game.entity.types.abstracts.Graphical;

public class StaticImage implements Graphical {

	BufferedImage image;
	int width, height, placeX, placeY, offsetX, offsetY, pixelX, pixelY;

	public StaticImage(BufferedImage image) {
		this.image = image;
		this.width = image.getWidth();
		this.height = image.getHeight();
		setPosition(0,0);
		setOffset(0,0);
	}

	private void updateX(){
		this.pixelX = placeX + offsetX;
	}
	private void updateY(){
		this.pixelY = placeY + offsetY;
	}
	
	public void setPosition(int x, int y) {
		placeX = x;
		updateX();
		placeY = y;
		updateY();
	}

	@Override
	public void render(Graphics gfx) {
		gfx.drawImage(image, pixelX, pixelY, width, height, null);
	}

	@Override
	public void setOffset(int x, int y) {
		this.offsetX = x;
		this.offsetY = y;
		updateX();
		updateY();
	}
	
	@Override
	public String toString() {
		return String.format("Static image (%d). Dimension: (%d,%d), Offset (%d,%d), Relative position (%d,%d), Actual position (%d,%d).",
							 hashCode(),  width,height,  offsetX,offsetY,  placeX,placeY,  pixelX,pixelY);
	}

}
