public class Quest2 extends Thread {

	public static long maxDiv = 0;
	public static long num = 0;

	public long start;

	public Q2(long s) {
		this.start = s;
	}

	public void run() {
		for(long i = this.start; i<=this.start+10000; i++) {
			long cur_divisors=0;
            for(long j=i; j>0; j--)
            {
                if(i%j==0)
                {
                    cur_divisors+=1;
                }
            }
            if(cur_divisors > maxDiv)
            {
            	synchronized(this) {
            		maxDiv = cur_divisors;
	                num = i;
            	}
            }
		}
	}

	public static void main(String[] args) {
		Q2 th1 = new Q2(1);
		Q2 th2 = new Q2(10001);
		Q2 th3 = new Q2(20001);
		Q2 th4 = new Q2(30001);
		Q2 th5 = new Q2(40001);
		Q2 th6 = new Q2(50001);
		Q2 th7 = new Q2(60001);
		Q2 th8 = new Q2(70001);
		Q2 th9 = new Q2(80001);
		Q2 th10 = new Q2(90001);

		long st = System.currentTimeMillis();

		th1.start();
		try {
			th1.join();
		} catch (Exception e) {

		}

		th2.start();
		try {
			th2.join();
		} catch (Exception e) {

		}

		th3.start();
		try {
			th3.join();
		} catch (Exception e) {

		}

		th4.start();
		try {
			th4.join();
		} catch (Exception e) {

		}

		th5.start();
		try {
			th5.join();
		} catch (Exception e) {

		}

		th6.start();
		try {
			th6.join();
		} catch (Exception e) {

		}

		th7.start();
		try {
			th7.join();
		} catch (Exception e) {

		}

		th8.start();
		try {
			th8.join();
		} catch (Exception e) {

		}

		th9.start();
		try {
			th9.join();
		} catch (Exception e) {

		}

		th10.start();
		try {
			th10.join();
		} catch (Exception e) {

		}

		long total_time = System.currentTimeMillis() - st;

		System.out.println("Number =  " + num + " Divisors = " + maxDiv);
        System.out.println("Total time elapsed in milliseconds: " + (total_time));
	}
}
