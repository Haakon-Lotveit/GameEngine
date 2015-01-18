package game.entity.examples;

import java.awt.Graphics;

import game.entity.types.abstracts.Creature;
import game.entity.types.abstracts.Graphical;
import game.entity.types.abstracts.Paintable;
import game.entity.types.abstracts.Tickable;
import game.entity.types.specifics.Level;
import game.entity.types.specifics.Tile;

public class FlatStaticLevel implements Level {
	private final StaticSquareTile[][] tiles;

	public FlatStaticLevel(StaticSquareTile[][] tiles) {
		this.tiles = tiles;
		setOffset(0, 0);
	}

	@Override
	public boolean walkable(int column, int row) {
		return true;
	}

	@Override
	public Tile tileAt(int column, int row) {
		return tiles[column][row];
	}

	@Override
	public int numColumns() {
		return tiles.length;
	}

	@Override
	public int numRows() {
		return tiles[0].length; // Note that this assumes assumptions about the shape of tiles;
	}

	@Override
	public int startingColumn() {
		return 0;
	}

	@Override
	public int startingRow() {
		return 0;
	}

	@Override
	public void add(Paintable entity) {
		throw new RuntimeException();
	}

	@Override
	public void add(Tickable entity) {
		throw new RuntimeException();
	}

	@Override
	public void add(Creature entity) {
		throw new RuntimeException();
	}

	@Override
	public void setGraphicals(Graphical... entities) {
		throw new RuntimeException();
	}

	@Override
	public Graphical[] getGraphicals() {
		throw new RuntimeException();
	}

	@Override
	public void render(Graphics gfx) {
		for(Tile[] col : tiles) {
			for(Tile field : col) {
				field.render(gfx);
			}
		}

	}

	@Override
	public void setOffset(int x, int y) {
		for(Tile[] col : tiles) {
			for(Tile field : col) {
				field.setOffset(x, y);
			}
		}
	}

}
