package co.grandcircus;

public class HangMan {

	public static void printMan(int misses) {
		
		switch (misses) {
		
		case 1:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||\n"
							+ "||\n"
							+ "||\n");
			break;
		case 2:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||    T\n"
							+ "||\n"
							+ "||\n");
			break;
		case 3:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\n"
							+ "||\n"
							+ "||\n");
			break;
		case 4:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\\\n"
							+ "||\n"
							+ "||\n");
			break;
		case 5:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\\\n"
							+ "||    (\n"
							+ "||\n");
			break;
		case 6:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\\\n"
							+ "||   ((\n"
							+ "||\n");
			break;
		default:
			System.out.println("_______\n"
					+ "||    )\n"
					+ "||\n"
					+ "||\n"
					+ "||\n"
					+ "||\n");
			break;
			
		}
		
	}
	
}
