package StartPage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Baskin Robbins");
        JPanel panel = new JPanel();

        FrameWork.Frame(frame);
        FrameWork.Panel(panel,frame);

        panel.revalidate();
        panel.repaint();
    }
}
