package q9_1;

import java.util.ArrayList;

public class ThreadTester {
	public static void main(String[] args) {
		final int NUMOFTHREADS = 4;
		final int NUMBERSTOSUM = 100;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < NUMOFTHREADS; i++) {
			Runnable r1 = new Summer(NUMBERSTOSUM, NUMOFTHREADS, i, list);
			Thread t1 = new Thread(r1);
			t1.start();
			
			try {
				t1.join();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}

		}

		int total = 0;
		for (int j = 0; j < list.size(); j++) {
			total += list.get(j);
		}
		System.out.println(total);

	}

}
