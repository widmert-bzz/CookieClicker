import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MyWindow extends JFrame {

    public JLabel cookieCounter;

    public MyWindow() {
        var panel = new JPanel();

        ArrayList<Item> items = new ArrayList<>();


        //creating Items
        items.add(new Item("grandma", 20, 0.3, this, 1.02));
        items.add(new Item("machine", 300, 1.5, this, 1.05));
        items.add(new Item("mine", 1500, 5, this, 1.08));
        items.add(new Item("factory", 5000, 10, this, 1.1));


        addBounds(panel,items);

        setTitle(StandardData.FRAME_NAME);
        setSize(StandardData.FRAME_WIDTH, StandardData.FRAME_HEIGHT);

        var cookieButton = new JButton();

        cookieCounter = new JLabel(String.valueOf(StandardData.COOKIES));


        setButtonBounds(cookieButton);

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

        java.util.Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Main.addGeneratedCookies(items);
                Rectangle r = panel.getBounds();
                StandardData.FRAME_WIDTH = r.width;
                StandardData.FRAME_HEIGHT = r.height;
                setButtonBounds(cookieButton);
                for (int i = 0; i < items.size(); i++) {
                    items.get(i).setBounds(10 + i * 35);
                }
            }
        }, 0, 200);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static void addBounds(JPanel panel, ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            panel.add(items.get(i).buyButton);
            panel.add(items.get(i).label);
            panel.add(items.get(i).label2);
            items.get(i).setBounds(10 + i * 35);
        }
    }

    private static void setButtonBounds(JButton cookieButton){
        cookieButton.setBounds((StandardData.FRAME_WIDTH / 2) - (StandardData.BUTTON_WIDTH / 2),
                (StandardData.FRAME_HEIGHT / 2) - (StandardData.BUTTON_HEIGHT / 2),
                StandardData.BUTTON_WIDTH, StandardData.BUTTON_HEIGHT);
    }



}
