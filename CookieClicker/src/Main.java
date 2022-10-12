public class Main {
    static MyWindow window;

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


}
