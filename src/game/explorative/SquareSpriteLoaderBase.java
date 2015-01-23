package game.explorative;

import game.resource.loader.SquareSpriteLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.io.File.separatorChar;
/**
 * An easier way to instantiate spriteloaders.
 * While you can definitively make things hard on yourself by using this,
 * you can also make things a lot easier:
 * Tell it about a folder it is supposed to load sprites from, and it will first read a file called "spritesheets.info", 
 * and parse information from that. The file will have information about which files will be loaded, and the sizes of the tiles.
 * Note that all tiles must be the same size for this type of loader to work.
 * 
 * When the parser is done, you can leave comments in the files by the traditional UNIX character '#', which will comment out until the end of the line.
 * (Comments are not yet implemented. They will be implemented before more advanced file formats, but getting the parser to work takes precedence.)
 * 
 * An example of this file can be found in the /res/art/ folder. 
 * As we move away from squares and into rectangles, this class and the file-format will be changed.
 * 
 * However, in this early version, we will assume the following:
 * All tiles are square.
 * All tiles are the same size.
 * There is no space between the tiles.
 * The user will choose good names that do not overlap.
 * 
 * In later versions, after this format works, more advanced file formats will be likely to be possible.
 * No backwards compatibility is guaranteed, or even desired at this point.
 * 
 * @author Haakon Løtveit (haakon.lotveit@student.uib.no)
 *
 */
public class SquareSpriteLoaderBase {
	private static final String FILENAME = "spritesheets.info";
	
	private Map<String, SquareSpriteLoader> spriteLoaders;
	
	public SquareSpriteLoaderBase() {
		this.spriteLoaders = new HashMap<>();
	}
	
	/* A convenience method so that you don't have to write new File(...) just to get at a folder. */
	/**
	 * This will load a folder of spritesheets into the system, according to the file "spritesheets.info" in that folder.
	 * @param string the path to the folder you want.
	 * @throws IOException if the SpriteLoader chokes when reading the image-file.
	 */
	public void loadFolder(String string) throws IOException {
		File folder = new File(string);
		loadFolder(folder);
	}

	/**
	 * This will load a folder of spritesheets into the system, according to the file "spritesheets.info" in that folder.
	 * @param folder the folder you want to load from.
	 * @throws IOException if the SpriteLoader chokes when reading the image-file.
	 */
	public void loadFolder(File folder) throws IOException {
		if(!folder.isDirectory()){
			throw new FileNotFoundException(String.format("The argument \"%s\" is not a valid folder.", folder.getAbsolutePath()));
		}
		
		File spritesheetsInfo = new File(folder.getAbsolutePath() + separatorChar + FILENAME);
		if(spritesheetsInfo.exists());
		
		String[] configLines = FileUtils.slurpFile(spritesheetsInfo).split("\n");
		for(String line : configLines) {
			try(Scanner parser = new Scanner(line)){
				int tileSize = parser.nextInt();
				String spriteLoaderName = parser.next();
				String imageFileName = parser.nextLine().trim();
				String pathSpec = folder.getAbsolutePath() + separatorChar + imageFileName;
				File spriteSheet = new File(pathSpec);
				System.out.println(spriteLoaders.keySet());
				if(size() == 1){
					throw new IOException(String.format("Name \"%s\" is already taken for SpriteLoader \"%s\"", spriteLoaderName, spriteLoaders.get(spriteLoaderName)));
				}
				
				SquareSpriteLoader loader = new SquareSpriteLoader(spriteSheet, tileSize);
				spriteLoaders.put(spriteLoaderName, loader); 
			}
		}
	}
	
	public int size() {
		return spriteLoaders.size();
	}
	
	public SquareSpriteLoader get(String name) {
		return spriteLoaders.get(name);
	}
}
