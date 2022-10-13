import javax.swing.*;

public class Item {

    int price;
    double moneyPerSecound;
    int counterNumberOfItem = 0;

    double multiplicationValue;
    JLabel label = new JLabel("0");
    JLabel label2 = new JLabel();
    JButton buyButton = new JButton();
    MyWindow window;

    Item(String name, int price, double moneyPerSecound, MyWindow window, double multiplicationValue){

        this.price = price;
        this.moneyPerSecound = moneyPerSecound;
        this.window = window;
        this.multiplicationValue = multiplicationValue;

        buyButton.setFocusPainted(false);
        buyButton.setText("Buy " + name);
        buyButton.addActionListener(e -> buyItem());
    }

    public void setBounds(int height) {

        buyButton.setBounds((StandardData.FRAME_WIDTH - (StandardData.SHOP_BUTTON_WIDTH + 10)), height,
                StandardData.SHOP_BUTTON_WIDTH, StandardData.SHOP_BUTTON_HEIGHT);
        label.setBounds(buyButton.getX() - 30,buyButton.getY() + 4, 100, 20);
        label2.setBounds(buyButton.getX() - 105,buyButton.getY() + 4, 100, 20);
        label2.setText("price: " + price);
    }

    public void buyItem(){

        if(StandardData.COOKIES >= price){
            Main.eatCookie(price);
            counterNumberOfItem++;
            label.setText(String.valueOf(counterNumberOfItem));
            price = (int) (price * multiplicationValue) + 1;
            label2.setText("price: " + price);
        }

    }


}
