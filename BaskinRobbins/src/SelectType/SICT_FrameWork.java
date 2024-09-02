package SelectType;

import javax.swing.*;
import java.awt.*;

public class SICT_FrameWork {
    static float f = 1.69160305F;

    public static void Frame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setSize(570, 900);
        int x = 50;
        int y = ((screenSize.height - 900) / 2) - 20;
        frame.setLocation(x, y);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void Panel(JPanel panel, JFrame frame) {
        panel.setLayout(null);
        panel.setBounds(frame.getBounds());
        panel.setBackground(new Color(247, 247, 247));
        frame.add(panel);
    }

}
