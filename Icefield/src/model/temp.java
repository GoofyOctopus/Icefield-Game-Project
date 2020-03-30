package model;

import java.util.Scanner;

import model.Game.Move;

public class temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Do you want to play or test?");
		System.out.println("For playing press 1");
		System.out.println("For testing press 2");
		temp main = new temp();
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		switch(answer) {
		case 1: Game g = new Game(false);
		case 2: while(main.tests());
		}
		
		/* *
		 *  using 5x5 topleft part *
		 *  2 eskimo 1 explorer *
		 *   all items are reachable *
		 *    14 test case 
		 *    * 15 or any other number is exit */	
	}
	public boolean tests() 
	{
		System.out.println("Which test cases do you want");
		System.out.println("We need to explain test cases to the user");	
		Scanner in = new Scanner(System.in);
		int answer = in.nextInt();
		switch(answer) {
		case 1: testCase1(); return true;
		case 2: testCase2(); return true;
		case 3: testCase3(); return true;
		case 4: testCase4(); return true;
		case 5: testCase5(); return true;
		case 6: testCase6(); return true;
		case 7: testCase7(); return true;
		case 8: testCase8(); return true;
		case 9: testCase9(); return true;
		case 10: testCase10(); return true;
		case 11: testCase11(); return true;
		case 12: testCase12(); return true;
		case 13: testCase13(); return true;
		case 14: testCase14(); return true;
		default : System.out.println("Test cases are done! Thank you!"); return false;
		}
	}
	/*
	 * Case N1 - Move to a stable iceberg
	 * */
	public void testCase1()
	{
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.D);//Move right to stable iceberg
		//How do we show that it's a stable iceberg
	}
	/*
	 * Case N2 - Move to an unstable iceberg
	 * */
	public void testCase2() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.S);//Move DOWN to stable iceberg
		g.makeMove(g.figures.get(0), Move.D);//Move RIGHT to stable iceberg
	}
	/*
	 * Case N2 - Move to a hole to collapse
	 * */
	public void testCase3() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.A);//Move Left to stable iceberg
	}
	public void testCase4() {}
	public void testCase5() {}
	/*
	 * Genarating blizzard
	 */
	public void testCase6() {
		Game g = new Game(true);
		g.icf.generateBlizzards();
		System.out.println("Generate blizzard test case is done!");
	}
	/*
	 * Checking capaacity of neighboring iceberg.
	 */
	public void testCase7() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(2), Move.US);
		System.out.println("Check capacity test case is done!");
		}
	/*
	 * Building igloo
	 */
	public void testCase8() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.US);
		System.out.println("Build igloo test case is done!");
	}
	/*
	 * Checking if next player method is running
	 */
	public void testCase9() {
		Game g = new Game(true);
		g.nextPlayer(g.figures.get(0));
		System.out.println("Next player test case is done!");
		}
	/*
	 * Removing snow
	 */
	public void testCase10() {
		Game g = new Game(true);
		g.makeMove(g.figures.get(0), Move.RS);
		System.out.println("Remove snow test case is done!");
	}
	public void testCase11() {}
	public void testCase12() {}
	public void testCase13() {}
	public void testCase14() {}
}

