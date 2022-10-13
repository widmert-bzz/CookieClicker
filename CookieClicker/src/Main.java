import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static java.lang.System.currentTimeMillis;

public class Main {
    static MyWindow window;

    static double amountOfCookies = 0;

    public static void main(String[] args) {
        window = new MyWindow();


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

        double millisecounds = currentTimeMillis();

        BigDecimal bd = BigDecimal.valueOf(StandardData.cookiesPerSecond);
        window.cookiesPerSecond.setText(bd.setScale(1, RoundingMode.HALF_UP) + "/s");
        for (Item item : items) {
            amountOfCookies += item.moneyPerSecound * item.counterNumberOfItem * 0.2;
        }
        if (amountOfCookies >= 1) {
            addCookie((int) amountOfCookies);
            amountOfCookies = 0;
        }
    }
}
