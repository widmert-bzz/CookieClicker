import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


public class Main {
    static MyWindow window;

    static double amountOfCookies = 0;

    public static void main(String[] args) {
        window = new MyWindow();
        if(!StandardData.reset){
            SaveFiles.openGameData();
        }
    }

    public static void addCookie(int cookies) {
        StandardData.COOKIES += cookies;
        window.cookieCounter.setText(String.valueOf(StandardData.COOKIES));
    }

    public static void eatCookie(int cookies) {
        StandardData.COOKIES -= cookies;
        window.cookieCounter.setText(String.valueOf(StandardData.COOKIES));
    }

    public static void addGeneratedCookies(ArrayList<Item> items) {
        BigDecimal bd = BigDecimal.valueOf(StandardData.cookiesPerSecond + StandardData.cps);
        try{
            window.cookiesPerSecond.setText(bd.setScale(1, RoundingMode.HALF_UP) + "/s");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for (Item item : items) {
            amountOfCookies += item.moneyPerSecound * item.counterNumberOfItem * 0.1;
        }
        if (amountOfCookies >= 1) {
            addCookie((int) amountOfCookies);
            amountOfCookies = 0;
        }
    }
}
