package SelectType.Select_Taste;

import StartPage.BaskinRobbins_Main;

import javax.swing.*;
// 이전 패널 보이게 설정
// panel2.setVisible(true);

public class ST_Main {
    static JPanel panel4;

    public static void ST_main()  {


        JFrame frame = BaskinRobbins_Main.getFrame();
        panel4 = new JPanel();

        // 프레임, 패널 편집
        ST_FrameWork.Panel(panel4,frame);

        // 리로드
        panel4.revalidate();
        panel4.repaint();
    }
    public static JPanel getPanel4(){
        return panel4;
    }
}
