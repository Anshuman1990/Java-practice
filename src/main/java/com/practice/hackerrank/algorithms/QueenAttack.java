package com.practice.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author asaha
 *
 */
public class QueenAttack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQueen = in.nextInt();
		int cQueen = in.nextInt();
		System.out.println(n+","+k);
		System.out.println(rQueen+","+cQueen);
		ArrayList<int[]> Obstacle = new ArrayList<int[]>(k);
		for (int i = 0; i < k; i++) {
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();
			Obstacle.add(new int[] { rObstacle, cObstacle });
		}
		ArrayList<int[]> data = getLocations(rQueen, cQueen, n, Obstacle);
		System.out.println("Size= " + data.size());
		Iterator<int[]> itr = data.iterator();
		while (itr.hasNext()) {
			int[] a = itr.next();
			System.out.println(a[0] + "," + a[1]);
		}
	}

	private static ArrayList<int[]> getLocations(int rQueen, int cQueen, int n, ArrayList<int[]> obs) {
		ArrayList<int[]> locations = new ArrayList<int[]>();
		int tR = rQueen;
		int tC = cQueen;
		boolean chk = false;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R+,C");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R,C+");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R+,C+");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R-,C");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R,C-");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R-,C-");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R-,C+");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		while (tR != 0 || tC != 0) {
			int[] D = createPoints(tR, tC, "R+,C-");
			for (int i = 0; i < obs.size(); i++) {
				boolean val = validate(D[0], D[1], obs.get(i), n);
				if (!val) {
					chk = true;
					break;
				}
			}
			if (chk) {
				chk = false;
				break;
			} else {
				locations.add(D);
				tR = D[0];
				tC = D[1];
			}
		}
		tR = rQueen;
		tC = cQueen;
		return locations;
	}

	private static boolean validate(int currX, int currY, int[] obs, int N) {
		boolean ischeck = true;
		if (currX <= 0 || currY <= 0 || currX > N || currY > N
				|| (obs.length != 0 ? currX == obs[0] : false) && (obs.length != 0 ? currY == obs[1] : false)) {
			ischeck = false;
		}
		return ischeck;
	}

	private static int[] createPoints(int currR, int currC, String type) {
		switch (type) {
		case "R+,C":
			return new int[] { currR + 1, currC };
		case "R,C+":
			return new int[] { currR, currC + 1 };
		case "R+,C+":
			return new int[] { currR + 1, currC + 1 };
		case "R-,C":
			return new int[] { currR - 1, currC };
		case "R,C-":
			return new int[] { currR, currC - 1 };
		case "R-,C-":
			return new int[] { currR - 1, currC - 1 };
		case "R+,C-":
			return new int[] { currR + 1, currC - 1 };
		case "R-,C+":
			return new int[] { currR - 1, currC + 1 };
		default:
			return null;
		}
	}
}
