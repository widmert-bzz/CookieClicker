import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyWindow extends JFrame {

    public int test;

    public JLabel cookieCounter;

    public MyWindow() {
        var panel = new JPanel();


        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("grandma", 50, 0.2, this));

        for (int i = 0; i < items.size(); i++) {
            panel.add(items.get(i).buyButton);
            panel.add(items.get(i).label);
            items.get(i).setBounds((i + 1) * 10);
        }

        setTitle(StandardData.FRAME_NAME);
        setSize(StandardData.FRAME_WIDTH, StandardData.FRAME_HEIGHT);

        var cookieButton = new JButton();

        cookieCounter = new JLabel(String.valueOf(StandardData.COOKIES));


        cookieButton.setBounds((StandardData.FRAME_WIDTH / 2) - (StandardData.BUTTON_WIDTH / 2),
                (StandardData.FRAME_HEIGHT / 2) - (StandardData.BUTTON_HEIGHT / 2),
                StandardData.BUTTON_WIDTH, StandardData.BUTTON_HEIGHT);



        cookieCounter.setBounds(StandardData.TEXT_X, StandardData.TEXT_Y, 100, 20);

        panel.add(cookieButton);
        panel.add(cookieCounter);

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

        cookieButton.addActionListener(e -> {
            StandardData.COOKIES++;
            cookieCounter.setText(String.valueOf(StandardData.COOKIES));
        });


        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }




}
