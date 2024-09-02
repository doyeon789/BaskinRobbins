package SelectType;

import javax.swing.*;

public class SelectIceCreamType_Main {
    public static void SICT_main() {

        JFrame frame = new JFrame("Baskin Robbins");
        JPanel panel = new JPanel();

        SICT_FrameWork.Frame(frame);
        SICT_FrameWork.Panel(panel,frame);

        panel.revalidate();
        panel.repaint();
    }
}







