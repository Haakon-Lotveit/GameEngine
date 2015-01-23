package game.explorative;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Contains convenience methods for file I/O.
 * 
 * 
 * @author haakon
 *
 */
public class FileUtils {
	public static String slurpFile(String filename) throws FileNotFoundException {
		return FileUtils.slurpFile(new File(filename));
	}
	
	public static String slurpFile(File file) throws FileNotFoundException {
		try(Scanner slurpee = new Scanner(file)) {
			return slurpee.useDelimiter("\\Z").next();
		}
	}
}
