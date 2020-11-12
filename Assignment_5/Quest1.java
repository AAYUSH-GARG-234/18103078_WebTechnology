public class Quest1 extends Thread {
    public void run() {
        for(int i=1;i<=100;i++) {
            System.out.println(i);
            if((i)%10 == 0) {
                System.out.println("value of count: "+count");
            }
            try {
                Thread.sleep(1000);
            }
            catch(Exception e){}
        }
    }
    public static void main(String[] args)
    {
        Quest1 obj = new Quest1();
        obj.start();
    }
}
