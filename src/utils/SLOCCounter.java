
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SLOCCounter {

	private File rootFile;
	private String type;
	private Integer count = null;

	public SLOCCounter(String rootPath, String type) {
		if (rootPath == null || type == null) {
			throw new NullPointerException();
		}
		if (type.startsWith(".")) {
			this.type = type;
		} else {
			this.type = "." + type;
		}
		File f = new File(rootPath);
		if (!f.exists()) {
			throw new IllegalArgumentException("File: " + f.toString() + " :does not exist");
		}
		rootFile = f;
	}

	public String getType() {
		return type;
	}

	public String getRootPath() {
		return rootFile.getAbsolutePath();
	}

	public static void main(String[] args) {
		SLOCCounter c = new SLOCCounter(
				"F:\\MyDocuments\\00ComputerScience\\1stYear\\00Modules\\COMP1202Programming1\\workspace", "java");
		System.out.println("Source lines of code: " + c.getCount());
	}

	/**
	 * Returns the number of non-empty lines of code in all files of type
	 * {@code type} reachable from the directory {@code rootFile}
	 *
	 * @return Number of lines of code in all the files in the directory
	 *         specified upon creation of a {@code SLOCCounter} object
	 */
	public int getCount() {
		if (count != null) {
			return count;
		} else {
			List<File> files = getFiles();
			int cnt = 0;

			for (File f : files) {
				BufferedReader br = null;
				try {
					br = new BufferedReader(new FileReader(f));
					String line = null;
					while ((line = br.readLine()) != null) {
						if (!line.equals("")) {
							cnt++;
						}
					}
				} catch (IOException e) {} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {}
					}
				}
			}
			return (count = cnt);
		}
	}

	/**
	 * Recursively explores all files from the root file of the SLOCCounter,
	 * adds all the reachable files that end in the specified type of file of
	 * the SLOCCounter to a list, and this list is then returned
	 *
	 * @return The list of all files ending in the specified type of SLOCCounter
	 *         which are reachable from the root file given by SLOCCounter
	 */
	private List<File> getFiles() {
		ArrayList<File> files = new ArrayList<>();
		if (!rootFile.isDirectory()) {
			files.add(rootFile);
			return files;
		} else {
			files.addAll(filesAux(rootFile));
			return files;
		}
	}

	private List<File> filesAux(File parent) {
		List<File> ret = new ArrayList<>();
		File[] files = parent.listFiles();
		for (File f : files) {
			if (!f.isDirectory() && f.getName().endsWith(type)) {
				ret.add(f);
			} else if (f.isDirectory()) {
				ret.addAll(filesAux(f));
			}
		}
		return ret;
	}
}
