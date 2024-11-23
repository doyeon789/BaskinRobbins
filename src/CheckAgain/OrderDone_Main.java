package CheckAgain;

import StartPage.BaskinRobbins_Main;

import javax.swing.*;


public class OrderDone_Main {
    static JPanel panel5 = new JPanel();

    public static void OD_main(){
        JFrame frame = BaskinRobbins_Main.getFrame();

        OD_FrameWork.Panel(panel5,frame);

        // 리로드
        panel5.revalidate();
        panel5.repaint();
    }
    public static JPanel getPanel5(){
        return panel5;
    }
}






