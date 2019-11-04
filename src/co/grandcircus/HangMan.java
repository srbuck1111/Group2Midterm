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
							+ "||\n"
							+ "  1 miss\n");
			break;
		case 2:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||    T\n"
							+ "||\n"
							+ "||\n"
							+ "  2 misses\n");
			break;
		case 3:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\n"
							+ "||\n"
							+ "||\n"
							+ "  3 misses\n");
			break;
		case 4:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\\\n"
							+ "||\n"
							+ "||\n"
							+ "  4 misses\n");
			break;
		case 5:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\\\n"
							+ "||    (\n"
							+ "||\n"
							+ "5 misses\n");
			break;
		case 6:
			System.out.println("_______\n"
							+ "||    )\n"
							+ "||    O\n"
							+ "||   /T\\\n"
							+ "||   ((\n"
							+ "||\n"
							+ "  Dead.");
			break;
		default:
			System.out.println("_______\n"
					+ "||    )\n"
					+ "||\n"
					+ "||\n"
					+ "||\n"
					+ "||\n"
					+ "  0 misses\n");
			break;
			
		}
		
	}
	
}
