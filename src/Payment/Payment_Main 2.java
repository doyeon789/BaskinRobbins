package Payment;

import StartPage.BaskinRobbins_Main;

import javax.swing.*;

public class Payment_Main {
    static JPanel panel_payment;

    public static void P_Main(){
        JFrame frame = BaskinRobbins_Main.getFrame();
        panel_payment =  new JPanel();

        P_FrameWork.Panel(panel_payment,frame);

        panel_payment.revalidate();
        panel_payment.repaint();
    }
    public static JPanel getPanel_payment(){
        return panel_payment;
    }
}