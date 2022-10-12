import javax.swing.*;

public class Item {

    int price;
    double moneyPerSecound;
    int counterNumberOfItem = 0;
    JLabel label = new JLabel("0");
    JButton buyButton = new JButton();
    MyWindow window;

    Item(String name, int price, double moneyPerSecound, MyWindow window){

        this.price = price;
        this.moneyPerSecound = moneyPerSecound;
        this.window = window;


        buyButton.setFocusPainted(false);
        buyButton.setText("Buy " + name);
        buyButton.addActionListener(e -> buyItem());
    }

    public void setBounds(int height) {
        buyButton.setBounds((StandardData.FRAME_WIDTH - (StandardData.SHOP_BUTTON_WIDTH + 25)), height,
                StandardData.SHOP_BUTTON_WIDTH, StandardData.SHOP_BUTTON_HEIGHT);
        label.setBounds(buyButton.getX() - 30,buyButton.getY(), 100, 20);
    }

    public void buyItem(){

        if(StandardData.COOKIES >= price){
            Main.eatCookie(price);
            counterNumberOfItem++;
            label.setText(String.valueOf(counterNumberOfItem));
            price = (int) (price * StandardData.PRICE_MULTIPLICATION);
        }

    }


}
