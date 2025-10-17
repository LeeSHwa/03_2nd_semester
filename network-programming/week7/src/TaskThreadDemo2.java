
public class TaskThreadDemo2 {

    public static void main(String[] args) {

        Thread printA = new PrintChar('a', 100);
        Thread printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNumJoin(100);

        //PrintNum print100 = new PrintNum(100);
        Thread thread4 = new Thread(print100);

        thread4.start();
        // thread3.run(); 
        printA.start();
        printB.start();

    }

}

class PrintChar extends Thread {

    private char charToPrint;

    private int times;

    public PrintChar(char c, int t) {

        charToPrint = c;

        times = t;

    }

    @Override

    public void run() {

        for (int i = 0; i < times; i++) {

            System.out.print(charToPrint + " ");

        }

    }

}

class PrintNum implements Runnable {

    private int lastNum;

    public PrintNum(int n) {

        lastNum = n;

    }

    public void run() {

        for (int i = 1; i <= lastNum; i++) {

            System.out.print(i + " ");

        }

    }

}

class PrintNumJoin implements Runnable {

	private int lastNum;
	public PrintNumJoin(int n) {
		lastNum = n;
	}

	public void run() {
		Thread thread4 = new Thread(new PrintChar('C', 10));
		thread4.start();
		try {
			for (int i = 1; i <= lastNum; i++) {
				System.out.print(" " + i);
				if (i == 3)
					thread4.join();
			}
		} catch (InterruptedException ex) {
		}
	}

}