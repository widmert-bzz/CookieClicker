import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow() {

        setTitle(StandardData.FRAME_NAME);
        setSize(StandardData.FRAME_WIDTH, StandardData.FRAME_HEIGHT);

        var panel = new JPanel();
        var button = new JButton();

        button.setBounds((StandardData.FRAME_WIDTH / 2) - (StandardData.BUTTON_WIDTH / 2),
                (StandardData.FRAME_HEIGHT / 2) - (StandardData.BUTTON_HEIGHT / 2),
                StandardData.BUTTON_WIDTH, StandardData.BUTTON_HEIGHT);

        panel.add(button);

        this.getContentPane().add(panel);

        java.net.URL imgURL = getClass().getResource("./resources/cookieIcon.png");

        if (imgURL != null) {
            var imageIcon = new ImageIcon(imgURL);
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(StandardData.BUTTON_HEIGHT - 20, StandardData.BUTTON_HEIGHT - 20, java.awt.Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newimg);
            button.setIcon(imageIcon);
        }

        panel.setLayout(null);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
