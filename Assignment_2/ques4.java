public class ques4 {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            long t1 = i*(i+1)/2;
            long t2 = i*i;
            if(t1 == t2)break;
            i++;
        }
        if(i>=1)System.out.println(i);
    }
}
