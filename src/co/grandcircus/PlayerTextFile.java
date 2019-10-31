package co.grandcircus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PlayerTextFile {

	ArrayList<Player> Player = new ArrayList<>();

	public static void createOurPlayerFile() {

		String fileName = "Players.txt";
		Path path = Paths.get(fileName);

		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("The file was created successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong...file not created");
			}
		} else {
			System.out.println("The file already exists!");
		}

	}

	public static void writePlayers(ArrayList<Player> player) {

		String fileName = "Players.txt";
		Path path1 = Paths.get(fileName);

		File file = path1.toFile();
		PrintWriter output = null;

		try {
			output = new PrintWriter(new FileOutputStream(file, true));
			for (Player p : player) {
				output.println(p);
				output.close();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong.");
		} finally {
			output.close();
		}
	}

	public ArrayList<Player> getPlayer() {
		return Player;
	}

	public void setPlayer(ArrayList<Player> player) {
		Player = player;
	}
}
