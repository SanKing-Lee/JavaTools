import java.text.DateFormat;
import java.util.Scanner;

public class MillsToTime {
    private static DateFormat dateFormat = DateFormat.getDateTimeInstance();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLong()){
            long millis = in.nextLong();
            System.out.println("格林乔治时间:\t" + dateFormat.format(millis).toString());
            System.out.println("Unix时间戳:\t" + dateFormat.format(millis*1000).toString());
        }
        in.close();        
    }
}