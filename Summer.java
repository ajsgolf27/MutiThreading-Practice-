package q9_1;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Summer implements Runnable {

	private ArrayList<Integer> totalArray = new ArrayList<Integer>();
	private int total = 0;
	private int n = 0;
	private int k = 0;
	private int j = 0;

	Lock aLock = new ReentrantLock();

	public Summer(int n, int k, int j, ArrayList<Integer> addedValues) {
		this.n = n;
		this.k = k;
		this.j = j;
		this.totalArray = addedValues;

	}

	@Override
	public void run() {
		aLock.lock();
		try {
			int n1 = (j * (n / k)) + 1;
			int n2 = ((j + 1) * (n / k));

			for (int i = n1; i <= n2; i++) {
				total += i;
			}
			totalArray.add(total);
		} finally {
			aLock.unlock();
		}

	}

	public int getTotal() {

		return total;
	}

}
