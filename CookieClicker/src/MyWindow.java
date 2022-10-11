import javax.swing.*;

public class MyWindow extends JFrame {

    public MyWindow(){

        setTitle(StandardData.FRAME_NAME);
        setSize(StandardData.FRAME_WIDTH,StandardData.FRAME_HEIGHT);

        JPanel panel = new JPanel();
        JButton button = new JButton(StandardData.BUTTON_TEXT);

        button.setBounds(StandardData.FRAME_WIDTH / 2 - StandardData.BUTTON_WIDTH /2 , StandardData.FRAME_HEIGHT / 2 - StandardData.BUTTON_HEIGHT / 2,
                StandardData.FRAME_WIDTH,StandardData.FRAME_HEIGHT);

        panel.add(button);
        this.getContentPane().add(panel);

        button.setIcon(new ImageIcon(""));

        panel.setLayout(null);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
