import java.io.*;
import java.util.ArrayList;

public class SaveFiles {

    public static void saveData(ArrayList<Item> items){
        String data = "";
        for (Item item : items) {
            data += (item.price + ",");
            data += (item.counterNumberOfItem + "/");
        }
        data += StandardData.COOKIES + "/";
        data += StandardData.cookiesPerSecond;

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\widme\\OneDrive\\Dokumente\\GitHub\\CookieClicker\\CookieClicker\\src\\resources\\data.txt"));
            bw.write(data);
            System.out.println(data);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void openData(ArrayList<Item> items){
        String data = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\widme\\OneDrive\\Dokumente\\GitHub\\CookieClicker\\CookieClicker\\src\\resources\\data.txt"));
            data = br.readLine();
            for (Item item :
                    items) {
                String[] datalist = data.split(",");
                for (int i = 0; i < (datalist.length - 3); i++) {
                    String[] itemdata = datalist[i].split("/");
                    item.price = Integer.parseInt(itemdata[0]);
                    item.counterNumberOfItem = Integer.parseInt(itemdata[1]);
                }
                StandardData.COOKIES = Long.parseLong(datalist[datalist.length - 1]);
                StandardData.cps = Double.parseDouble(datalist[datalist.length - 2]);
            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
