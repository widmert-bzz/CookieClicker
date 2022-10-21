import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MyWindow extends JFrame {

    public JLabel cookieCounter;
    public JLabel cookiesPerSecond;

    public static ArrayList<Item> items = new ArrayList<>();

    public Image image;

    public MyWindow() {
        var panel = new JPanel();
        panel.setBackground(new Color(35, 42, 54));


        //creating Items
        items.add(new Item("Cursor", 15, 0.1, this));
        items.add(new Item("Grandma", 100, 1, this));
        items.add(new Item("Farm", 1100, 8, this));
        items.add(new Item("Mine", 12000, 47, this));
        items.add(new Item("Factory", 130000, 260, this));
        items.add(new Item("Bank", 1400000, 1400, this));
        items.add(new Item("Temple", 20000000, 7800, this));
        items.add(new Item("Wizard", 330000000, 44000, this));


        addBounds(panel, items);

        setTitle(StandardData.FRAME_NAME);
        setSize(StandardData.FRAME_WIDTH, StandardData.FRAME_HEIGHT);

        var cookieButton = new JButton();

        cookieCounter = new JLabel(String.valueOf(StandardData.COOKIES));
        cookiesPerSecond = new JLabel("0/s");

        cookieCounter.setForeground(Color.white);
        cookiesPerSecond.setForeground(Color.white);


        cookieCounter.setFont(new Font("Tahoma", Font.PLAIN, 40));
        cookiesPerSecond.setFont(new Font("Tahoma", Font.PLAIN, 20));

        setButtonBounds(cookieButton);

        cookieCounter.setBounds(StandardData.TEXT_X, StandardData.TEXT_Y, 500, 50);
        cookiesPerSecond.setBounds(StandardData.TEXT_X, StandardData.TEXT_Y + 50, 100, 20);

        panel.add(cookiesPerSecond);
        panel.add(cookieCounter);
        panel.add(cookieButton);

        this.getContentPane().add(panel);

        java.net.URL imgURL = getClass().getResource("./resources/cookie.png");

        if (imgURL != null) {
            var imageIcon = new ImageIcon(imgURL);
            image = imageIcon.getImage(); // transform it
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
            StandardData.clicksLast++;
            StandardData.COOKIES++;
            cookieCounter.setText(String.valueOf(StandardData.COOKIES));

        });

        //Update 0.1s
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
        }, 0, 100);

        java.util.Timer t2 = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                StandardData.cps = 2 * ((StandardData.clicks1 + StandardData.clicks2 + StandardData.clicks3) / 3.0);
                StandardData.clicks3 = StandardData.clicks2;
                StandardData.clicks2 = StandardData.clicks1;
                StandardData.clicks1 = StandardData.clicksLast;
                StandardData.clicksLast = 0;
            }
        }, 0, 500);


        //before closing
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            public void run() {
                SaveFiles.saveData(items);
            }
        }));
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

    private static void setButtonBounds(JButton cookieButton) {

        cookieButton.setBounds((StandardData.FRAME_WIDTH / 2) - (StandardData.BUTTON_WIDTH / 2),
                (StandardData.FRAME_HEIGHT / 2) - (StandardData.BUTTON_HEIGHT / 2),
                (StandardData.BUTTON_WIDTH), (StandardData.BUTTON_HEIGHT));


    }


}
