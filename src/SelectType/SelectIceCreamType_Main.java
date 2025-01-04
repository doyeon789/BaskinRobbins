package SelectType;

import StartPage.BaskinRobbins_Main;

import javax.swing.*;

public class SelectIceCreamType_Main {
    static JPanel panel2;

    public static void SICT_main()  {

        JFrame frame = BaskinRobbins_Main.getFrame();
        panel2 = new JPanel();

        // 프레임, 패널 편집
        SICT_FrameWork.Panel(panel2,frame);

        // 리로드
        panel2.revalidate();
        panel2.repaint();
    }

    // 다른 클래스에 이 패널을 전달하기 위한 함수
    public static JPanel getPanel2(){
        return panel2;
    }
}






