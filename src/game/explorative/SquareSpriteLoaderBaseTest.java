package game.explorative;

import static org.junit.Assert.*;
import game.resource.loader.SquareSpriteLoader;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class SquareSpriteLoaderBaseTest {
	private static final String ART = "res/art/";
	private SquareSpriteLoaderBase subject;
	
	@Before
	public void setUp() throws Exception {
		subject = new SquareSpriteLoaderBase();
		subject.loadFolder(ART);
	}

	@Test
	public void testNecessaryFileExists() {
		File foo = new File("res/art/spritesheets.info");
		assertTrue("foo is not a file", foo.isFile());
	}
	
	@Test
	public void testSize() throws Throwable {
		assert(subject.size() == 1);
	}
	
	@Test
	public void testGet() throws Throwable {
		SquareSpriteLoader loader = subject.get("basic-tiles");
		assertNotNull("Fant ikke loaderen", loader);
	}
	
	@Test
	public void testLoadFolderCollisionDetection() throws Throwable {
		try {
			subject.loadFolder(ART);
			fail("Same folder loaded twice without the collision detector knowing");
		}
		catch (IOException exception) {
			; // Success!
		}
	}
}
