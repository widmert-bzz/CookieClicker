import javax.swing.*;
import java.awt.*;

public class Item {

    int price;
    double moneyPerSecound;
    int counterNumberOfItem = 0;
    JLabel label = new JLabel("0");
    JLabel label2 = new JLabel();
    JButton buyButton = new JButton();
    MyWindow window;

    Item(String name, int price, double moneyPerSecound, MyWindow window) {

        label.setForeground(Color.white);
        label2.setForeground(Color.white);
        label.setFont(new Font("Tahoma", Font.PLAIN, 13));
        label2.setFont(new Font("Tahoma", Font.PLAIN, 13));


        this.price = price;
        this.moneyPerSecound = moneyPerSecound;
        this.window = window;

        //run without next line to reset
        if(!StandardData.reset){
            SaveFiles.openItemData(this);
        }


        java.net.URL imgURL = getClass().getResource("./resources/ButtonTexture.png");

        if (imgURL != null) {
            var imageIcon = new ImageIcon(imgURL);
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(StandardData.SHOP_BUTTON_WIDTH, StandardData.SHOP_BUTTON_HEIGHT, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            buyButton.setIcon(imageIcon);
        }


        buyButton.setFocusPainted(false);
        buyButton.setText(name);
        buyButton.setForeground(Color.white);
        buyButton.setBorderPainted(false);
        buyButton.setHorizontalTextPosition(JButton.CENTER);
        buyButton.setVerticalTextPosition(JButton.CENTER);
        buyButton.addActionListener(e -> buyItem());
        buyButton.setOpaque(false);
        buyButton.setContentAreaFilled(false);

        setPriceAndNumberText();
    }

    public void setBounds(int height) {

        buyButton.setBounds((StandardData.FRAME_WIDTH - (StandardData.SHOP_BUTTON_WIDTH + 10)), height,
                StandardData.SHOP_BUTTON_WIDTH, StandardData.SHOP_BUTTON_HEIGHT);
        label.setBounds(buyButton.getX() - 30, buyButton.getY() + 4, 100, 20);
        label2.setBounds(buyButton.getX() - 170, buyButton.getY() + 4, 100, 20);
        setPriceAndNumberText();
    }

    public void buyItem() {

        if (StandardData.COOKIES >= price) {
            Main.eatCookie(price);
            counterNumberOfItem++;
            price = (int) ((price * StandardData.MULTIPLICATION));
            calculateCookiesPerSecond();
            setPriceAndNumberText();
        }

    }

    public void setPriceAndNumberText(){
        label2.setText("Cost: " + price);
        label.setText(String.valueOf(counterNumberOfItem));
    }

    private void calculateCookiesPerSecond() {
        StandardData.cookiesPerSecond += moneyPerSecound;
    }


}
