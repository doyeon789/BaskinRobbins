package CheckAgain;

import SelectType.Select_Taste.ST_Main;
import StartPage.BaskinRobbins_Main;

import javax.swing.*;


public class OrderDone_Main {
    static JPanel panel5;

    public static void OD_main(){
        JFrame frame = BaskinRobbins_Main.getFrame();

        panel5 = new JPanel();
        panel5 = ST_Main.getPanel4();

        System.out.println("hi");

        // 리로드
        panel5.revalidate();
        panel5.repaint();
    }
}






