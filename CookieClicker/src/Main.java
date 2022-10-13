import java.util.ArrayList;
public class Main {
    static MyWindow window;

    static double amountOfCookies = 0;

    public static void main(String[] args) {
        window = new MyWindow();


    }

    public static void addCookie(int cookies){
        StandardData.COOKIES += cookies;
        window.cookieCounter.setText(String.valueOf(StandardData.COOKIES));
    }

    public static void eatCookie(int cookies){
        StandardData.COOKIES -= cookies;
        window.cookieCounter.setText(String.valueOf(StandardData.COOKIES));
    }

    public static void addGeneratedCookies(ArrayList<Item> items){

        for (Item item : items) {
            amountOfCookies += item.moneyPerSecound * item.counterNumberOfItem * 0.2;
        }
        if(amountOfCookies >= 1){
            addCookie((int) amountOfCookies);
            amountOfCookies = 0;
        }

    }


}
