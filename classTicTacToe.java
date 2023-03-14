import java.util.Scanner;

class Player{
	
	private String name;
	private char symbol;
	
	public Player(String name, char symbol) {
		setName(name);
		setSymbol(symbol);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(!name.isEmpty())
			this.name = name;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public void setSymbol(char symbol) {
		if(symbol != '\0')
			this.symbol = symbol;
	}
	
}

class Board{
	
	private char[][] board;
	private int size = 3;
	private int count;
	private char p1Symbol, p2Symbol;
	private static final char EMPTY = ' ';
	static final int Player_1_Wins = 1;
	static final int Player_2_Wins = 2;
	static final int DRAW = 3;
	static final int INCOMPLETE = 4;
	static final int INVALID_MOVE = 5;
	
	public Board(char p1Symbol, char p2Symbol) {
		board = new char[size][size];
		for(int i = 0;i < size;i++) {
			for(int j = 0;j < size;j++)
				board[i][j] = EMPTY;
		}
		this.p1Symbol = p1Symbol;
		this.p2Symbol = p2Symbol;
	}
	
	int move(char symbol, int x, int y) {
		
		if(x < 0 || x > size-1 || y < 0 || y > size-1 || board[x][y] != EMPTY) {
			return INVALID_MOVE;
		}
		board[x][y] = symbol;
		count++;
		// horizontal
		if(board[x][0] == board[x][1] && board[x][0] == board[x][2]) {
			return symbol == p1Symbol ? Player_1_Wins : Player_2_Wins;
		}
		// vertical
		if(board[0][y] == board[1][y] && board[0][y] == board[2][y]) {
			return symbol == p1Symbol ? Player_1_Wins : Player_2_Wins;
		}
		// 1st diagonal
		if(board[0][0] != EMPTY && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
			return symbol == p1Symbol ? Player_1_Wins : Player_2_Wins;
		}
		if(board[0][2] != EMPTY && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
			return symbol == p1Symbol ? Player_1_Wins : Player_2_Wins;
		}
		if(count == size*size) {
			return DRAW;
		}
		return INCOMPLETE;
		
	}
	
	void print() {
		int bar = 2;
		int sides = 0;
		System.out.println("---------------");
		for(int i = 0;i < size;i++) {
			System.out.print("   ");
			for(int j = 0;j < size;j++) {
				System.out.print(board[i][j]);
				if(sides < 2)
					System.out.print("|");
				sides++;
			}
			System.out.println();
			if(bar-- > 0)
				System.out.println("  -------");
			sides = 0;
		}
		System.out.println("---------------");
		
	}
	
}

public class classTicTacToe {
	
	private static Player p1, p2;
	private static Board board;
	private static int playerNumber;
	
	private static Player takeIP(int num) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the Name of " + num + " Player : ");
		String name = scn.nextLine();
		System.out.println("Enter the Symbol of " + num + " Player : ");
		char symbol = scn.next().charAt(0);
		Player p = new Player(name, symbol); 
		return p;
		
	}
	
	private static void startGame() {
		
		Scanner scn = new Scanner(System.in);
		p1 = takeIP(++playerNumber); 
		p2 = takeIP(++playerNumber);
		while(p1.getSymbol() == p2.getSymbol()) {
			System.out.println("Symbol Already Taken !!");
			p2.setSymbol(scn.next().charAt(0));
		}
		board = new Board(p1.getSymbol(), p2.getSymbol());
		boolean player1Turn = true;
		int status = board.INCOMPLETE;
		while(status == board.INCOMPLETE || status == board.INVALID_MOVE) {
			if(player1Turn) {
				System.out.println("Player " + p1.getName() + "'s TURN : ");
				System.out.println("Enter X and Y values respectively : ");
				int x = scn.nextInt();
				int y = scn.nextInt();
				status = board.move(p1.getSymbol(), x, y);
				if(status == board.INVALID_MOVE) {
					System.out.println("Invalid Move !! Please Try Again : ");
					continue;
				}
			}
			else {
				System.out.println("Player " + p2.getName() + "'s TURN : ");
				System.out.println("Enter X and Y values respectively : ");
				int x = scn.nextInt();
				int y = scn.nextInt();
				status = board.move(p2.getSymbol(), x, y);
				if(status == board.INVALID_MOVE) {
					System.out.println("Invalid Move !! Please Try Again : ");
					continue;
				}
			}
			player1Turn = !player1Turn;
			board.print();
		}
		if(status == board.Player_1_Wins)
			System.err.println("Player " + p1.getName() + " WINS !!!");
		else if(status == board.Player_2_Wins)
			System.err.println("Player " + p2.getName() + " WINS !!!");
		else
			System.err.println("The Game is a DRAW !!!");
		
	}
	
	public static void main(String[] args) {
		
		startGame();

	}

}
