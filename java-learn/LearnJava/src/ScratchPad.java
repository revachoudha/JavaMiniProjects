public class ScratchPad {
    
    public static void main(String[] args) {

        double radian=0;
        for (int i = 0; i < 8; i++) {
            double ans = (Math.round(radian*100))/100.0;
            System.out.println(ans);
            radian=radian+(Math.PI/4);            
        }
    }
}
