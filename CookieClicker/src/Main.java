import java.awt.Window;

public class Main {
    public static void main(String[] args) {

        Window window = new MyWindow();



    }

    public static void AddCookie(int cookies){
        StandardData.COOKIES += cookies;
    }


}
