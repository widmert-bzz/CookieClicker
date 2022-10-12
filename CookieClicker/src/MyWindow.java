import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {

        setTitle(StandardData.FRAME_NAME);
        setSize(StandardData.FRAME_WIDTH, StandardData.FRAME_HEIGHT);

        var panel = new JPanel();
        var cookieButton = new JButton();
        var grandmaButton = new JButton("Buy Grandma");
        JLabel cookieCounter = new JLabel(String.valueOf(StandardData.COOKIES));
        JLabel grandmaAmount = new JLabel("0");

        cookieButton.setBounds((StandardData.FRAME_WIDTH / 2) - (StandardData.BUTTON_WIDTH / 2),
                (StandardData.FRAME_HEIGHT / 2) - (StandardData.BUTTON_HEIGHT / 2),
                StandardData.BUTTON_WIDTH, StandardData.BUTTON_HEIGHT);

        grandmaButton.setBounds((StandardData.FRAME_WIDTH - (StandardData.SHOP_BUTTON_WIDTH + 20)), 10,
                StandardData.SHOP_BUTTON_WIDTH, StandardData.SHOP_BUTTON_HEIGHT);

        cookieCounter.setBounds(StandardData.TEXT_X, StandardData.TEXT_Y, 100, 20);
        grandmaAmount.setBounds(grandmaButton.getX() - 30,grandmaButton.getY(), 100, 20);

        grandmaButton.setFocusPainted(false);

        panel.add(cookieButton);
        panel.add(cookieCounter);

        panel.add(grandmaAmount);
        panel.add(grandmaButton);

        this.getContentPane().add(panel);

        java.net.URL imgURL = getClass().getResource("./resources/cookie.png");

        if (imgURL != null) {
            var imageIcon = new ImageIcon(imgURL);
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(StandardData.BUTTON_WIDTH, StandardData.BUTTON_HEIGHT, Image.SCALE_FAST);
            imageIcon = new ImageIcon(newimg);
            cookieButton.setIcon(imageIcon);
        }

        panel.setLayout(null);
        setVisible(true);
        cookieButton.setOpaque(false);
        cookieButton.setContentAreaFilled(false);
        cookieButton.setBorderPainted(false);

        cookieButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                StandardData.COOKIES++;
                cookieCounter.setText(String.valueOf(StandardData.COOKIES));
            }
        });

        grandmaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(StandardData.COOKIES >= StandardData.GRANDMA_PRICE){
                    StandardData.COOKIES -= (int) StandardData.GRANDMA_PRICE;
                    cookieCounter.setText(String.valueOf(StandardData.COOKIES));
                    StandardData.Grandma++;
                    StandardData.GRANDMA_PRICE = StandardData.GRANDMA_PRICE * StandardData.PRICE_MULTIPLICATION;
                    grandmaAmount.setText(String.valueOf(StandardData.Grandma));
                }


            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
