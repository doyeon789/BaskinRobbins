package SelectType.Option;

import StartPage.BaskinRobbins_Main;

import javax.swing.*;

public class Option_Main {
    static JPanel panel3;

    public static void O_main(){
        JFrame frame = BaskinRobbins_Main.getFrame();
        panel3 = new JPanel();

        // 프레임, 패널 편집
        Option_FrameWork.Panel(panel3,frame);

        // 리로드
        panel3.revalidate();
        panel3.repaint();
    }
}







