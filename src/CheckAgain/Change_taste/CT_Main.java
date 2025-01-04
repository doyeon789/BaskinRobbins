package CheckAgain.Change_taste;

import SelectType.Select_Taste.ST_FrameWork;
import StartPage.BaskinRobbins_Main;

import javax.swing.*;

public class CT_Main {
    static JPanel panel_change;

    public static void CTmain()  {

        JFrame frame = BaskinRobbins_Main.getFrame();
        panel_change = new JPanel();


        // 프레임, 패널 편집
        CT_FrameWork.Panel(panel_change,frame);

        // 리로드
        panel_change.revalidate();
        panel_change.repaint();
    }
    public static JPanel getPanel_change(){
        return panel_change;
    }
}
